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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Value("${users.sort.fields}")
    private List<String> sortFields;

    @Value("${users.filter.fields}")
    private List<String> filterFields;

    @Value("${users.page.size}")
    private Integer pageSize;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers(Integer pageNumber,
                                String orderByField,
                                Boolean desc,
                                String filterBy,
                                String filterValue,
                                String articlesState) {
        // создаем запрос на страницу
        PageRequest pageRequest = getPageRequest(pageNumber, orderByField, desc);

        Page<User> page = getUsersPage(filterBy, filterValue, articlesState, pageRequest);

        UsersDto result = UsersDto.builder()
                .count(page.getTotalElements()) // берем количество пользователей в базе
                .pagesCount(page.getTotalPages()) // берем общее количество страниц
                .build();

        if (isRequestForPublishedArticles(articlesState)) { // если попросили опуликованные статьи
            result.setUsers(fromWithArticles(page.getContent()));
        } else { // если не просили статьи
            result.setUsers(from(page.getContent()));
        }

        return result;
    }

    private static boolean isRequestForPublishedArticles(String articlesState) {
        return articlesState != null && articlesState.equals("published");
    }

    private Page<User> getUsersPage(String filterBy, String filterValue, String articles, PageRequest pageRequest) {
        Page<User> page = Page.empty();
        if (isRequestForPublishedArticles(articles)) { // если у вас попросили опубликованные статьи
            page = usersRepository.findAll(pageRequest); // пока просто возвращаем всех пользователей
        }
        else if (filterBy == null || filterBy.equals("")) { // если не была задана фильтрация
            page = usersRepository.findAll(pageRequest); // просто возвращаем данные
        } else { // если была задана фильтрация
            checkField(filterFields, filterBy); // проверяем поле - есть ли оно в списке разрешенных для фильтрации полей
            if (filterBy.equals("role")) {
                User.Role role = User.Role.valueOf(filterValue);
                page = usersRepository.findAllByRole(role, pageRequest);
            } else if (filterBy.equals("state")) {
                User.State state = User.State.valueOf(filterValue);
                page = usersRepository.findAllByState(state, pageRequest);
            }
        }
        return page;
    }

    private PageRequest getPageRequest(Integer pageNumber, String orderByField, Boolean desc) {

        if (orderByField != null && !orderByField.equals("")) { // проверяем, задал ли клиент поле для сортировки?

            checkField(sortFields, orderByField); // проверяем, доступно ли нам поле для сортировки

            Sort.Direction direction = Sort.Direction.ASC; // предполагаем, что сортировка будет в прямом порядке

            if (desc != null && desc) { // если клиент задал сортировку в обратном порядке
                direction = Sort.Direction.DESC; // задаем обратный порядок сортировки
            }

            Sort sort = Sort.by(direction, orderByField); // создаем объект для сортировки направление + поле

            return PageRequest.of(pageNumber, pageSize, sort); // создаем запрос на получение страницы пользователей с сортировкой
        } else {
            return getDefaultPageRequest(pageNumber);
        }
    }

    private PageRequest getDefaultPageRequest(Integer pageNumber) {
        return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
    }

    private void checkField(List<String> allowedFields, String field) {
        if (!allowedFields.contains(field)) {
            throw new ForbiddenFieldException(field);
        }
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

        PageRequest pageRequest = getDefaultPageRequest(pageNumber);
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
