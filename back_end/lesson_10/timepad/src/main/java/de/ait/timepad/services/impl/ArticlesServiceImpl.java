package de.ait.timepad.services.impl;

import de.ait.timepad.dto.ArticleDto;
import de.ait.timepad.dto.ArticlesDto;
import de.ait.timepad.dto.NewArticleDto;
import de.ait.timepad.exceptions.IncorrectUserIdException;
import de.ait.timepad.models.Article;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.ArticlesRepository;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.timepad.dto.ArticleDto.from;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class ArticlesServiceImpl implements ArticlesService {

    private final UsersRepository usersRepository;

    private final ArticlesRepository articlesRepository;

    @Override
    public ArticleDto addArticle(NewArticleDto newArticle) {
        User user = usersRepository.findById(newArticle.getAboutUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newArticle.getAboutUserId() + "> is not correct"));

        Article article = Article.builder()
                .text(newArticle.getText())
                .about(user)
                .publishDate(LocalDate.parse(newArticle.getPublishDate()))
                .build();

        user.getArticles().add(article);

        articlesRepository.save(article);

        return from(article);
    }

    @Override
    public ArticlesDto getArticles(Integer year, Integer month, Integer day) {
        if (isCorrect(year, month, day)) {
            List<Article> articles = articlesRepository.findAllByDate(year, month, day);
            return ArticlesDto.builder()
                    .articles(from(articles))
                    .count(articles.size())
                    .build();
        } else throw new IllegalArgumentException("Неверный формат даты");
    }

    private boolean isCorrect(Integer year, Integer month, Integer day) {
        return year == null && month == null && day == null ||
                year != null && month == null && day == null ||
                year != null && month != null && day == null ||
                year != null && month != null && day != null;
    }
}
