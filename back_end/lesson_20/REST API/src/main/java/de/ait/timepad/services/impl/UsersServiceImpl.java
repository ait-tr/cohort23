package de.ait.timepad.services.impl;

import de.ait.timepad.dto.*;
import de.ait.timepad.dto.pages.ArticlesDto;
import de.ait.timepad.dto.pages.UsersDto;
import de.ait.timepad.exceptions.ForbiddenFieldException;
import de.ait.timepad.exceptions.ForbiddenUpdateUserOperationException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.Article;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.ArticlesRepository;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.UsersService;
import de.ait.timepad.utils.PageRequestsUtil;import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.timepad.dto.UserDto.from;
import static de.ait.timepad.dto.ArticleDto.from;
import static de.ait.timepad.dto.UserDto.fromWithArticles;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final ArticlesRepository articlesRepository;

    private final PageRequestsUtil pageRequestsUtil;

    private final PasswordEncoder passwordEncoder;

    @Value("${users.sort.fields}")
    private List<String> sortFields;

    @Value("${users.filter.fields}")
    private List<String> filterFields;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }

    /**
     * Метод для получения списка всех пользователей с пагинацией и сортировкой
     * @param pageNumber номер страницы
     * @param orderByField поле, по которому нужно отсортировать
     * @param desc сортировка в обратном порядке
     * @param filterBy по какому полю нужно сделать фильтрацию
     * @param filterValue значение поля, по которому нужно сделать фильтрацию
     * @param articlesState если задано значение published, то кладем опубликованные статьи
     * @return список пользователей со статьями или без
     */
    @Override
    public UsersDto getAllUsers(UsersRequest request) {

        // получаем запрос на страницу с пользователями с помощью класса-утилиты
        PageRequest pageRequest = pageRequestsUtil.getPageRequest(request.getPage(), request.getOrderBy(), request.getDesc(), sortFields);
        // получаем страницу с пользователями на основе запроса на страницу
        Page<User> page = getUsersPage(request.getFilterBy(), request.getFilterValue(), request.getArticles(), pageRequest);
        // формируем результат, который превратиться в JSON
        UsersDto result = UsersDto.builder()
                .count(page.getTotalElements()) // берем количество пользователей в базе
                .pagesCount(page.getTotalPages()) // берем общее количество страниц
                .build();

        if (isRequestForPublishedArticles(request.getArticles())) { // если попросили опубликованные статьи
            result.setUsers(fromWithArticles(page.getContent())); // берем пользователей с их статьями
        } else { // если не просили статьи
            result.setUsers(from(page.getContent())); // не берем статьи
        }

        return result;
    }

    /**
     * Проверяем, запросили ли опубликованные статьи
     * @param articlesState published - значит просим опубликованные
     * @return <code>true</code> если запросили опубликованные статьи
     */
    private static boolean isRequestForPublishedArticles(String articlesState) {
        return articlesState != null && articlesState.equals("published");
    }

    /**
     * Получение страницы с пользователями исходя из условий выборки
     * @param filterBy по какому полю отбираем
     * @param filterValue значения поля, которое отбираем
     * @param articles если задано published - то возвращаем со статьями (опубликованными)
     * @param pageRequest запрос на получение страницы (сортировка + пагинация)
     * @return страница с пользователями
     */
    private Page<User> getUsersPage(String filterBy, String filterValue, String articles, PageRequest pageRequest) {
        // создаем пустую страницу, если запрос был сформирован не правильно - можем просто вернуть пустую страницу
        Page<User> page = Page.empty();
        if (isRequestForPublishedArticles(articles)) { // если запросили с опубликованными статьями
            page = usersRepository.findAll(pageRequest); // возвращаем всех пользователей с опубликованными статьями
        } else if (filterBy == null || filterBy.equals("")) { // если не указали параметр фильтрации
            page = usersRepository.findAll(pageRequest); // пока возвращаем все, что есть
        } else { // если не просили статьи и при этом указали параметры фильтрации
            pageRequestsUtil.checkField(filterFields, filterBy); // проверяем, что по этим полям можно фильтровать
            if (filterBy.equals("role")) { // если хотят получить по роли
                User.Role role = User.Role.valueOf(filterValue); // преобразуем строку в enum
                page = usersRepository.findAllByRole(role, pageRequest); // запрашиваем по роли из репозитория
            } else if (filterBy.equals("state")) { // если хотят получить по состоянию
                User.State state = User.State.valueOf(filterValue); // преобразуем строку в enum
                page = usersRepository.findAllByState(state, pageRequest); // запрашиваем по состоянию из репозитория
            }
        }
        return page; // возвращаем страницу
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User user = getUserOrThrow(userId);

        usersRepository.delete(user);

        return from(user);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {

        User user = getUserOrThrow(userId);

        if (updateUser.getNewRole().equals("ADMIN")) {
            throw new ForbiddenUpdateUserOperationException("role", "ADMIN");
        }

        if (updateUser.getNewState().equals("BANNED")) {
            throw new ForbiddenUpdateUserOperationException("state", "BANNED");
        }

        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public ArticlesDto getArticlesOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return ArticlesDto.builder()
                .articles(from(user.getArticles()))
                .count(user.getArticles().size())
                .build();
    }

    @Override
    public ArticlesDto getPublishedArticlesArticlesOfUser(Integer pageNumber, Long userId) {
        User user = getUserOrThrow(userId);

        PageRequest pageRequest = pageRequestsUtil.getDefaultPageRequest(pageNumber);
        Page<Article> page = articlesRepository.findAllByAboutAndState(pageRequest, user, Article.State.PUBLISHED);

        return ArticlesDto.builder()
                .articles(from(page.getContent()))
                .count(page.getContent().size())
                .pagesCount(page.getTotalPages())
                .build();
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User", userId));
    }
}
