package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Article;
import de.ait.timepad.repositories.ArticlesRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Repository
public class ArticlesRepositoryListImpl implements ArticlesRepository {

    private static List<Article> articles = new ArrayList<>();

    @Override
    public void save(Article article) {
        article.setId((long) (articles.size() + 1));
        articles.add(article);
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public void clear() {
        articles.clear();
    }

    @Override
    public List<Article> findAllByDate(Integer year, Integer month, Integer day) {
        if (year != null && month == null && day == null) {
            return articles.stream().filter(article -> article.getPublishDate().getYear() == year).collect(Collectors.toList());
        } else if (year != null && month != null && day == null) {
            return articles.stream().filter(article ->
                    article.getPublishDate().getYear() == year && article.getPublishDate()
                            .getMonth().getValue() == month).collect(Collectors.toList());
        } else {
            return articles.stream().filter(article -> {
                LocalDate date = LocalDate.of(year, month, day);
                return article.getPublishDate().equals(date);
            }).collect(Collectors.toList());
        }
    }
}
