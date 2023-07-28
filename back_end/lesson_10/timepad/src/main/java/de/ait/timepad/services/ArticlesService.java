package de.ait.timepad.services;

import de.ait.timepad.dto.ArticleDto;
import de.ait.timepad.dto.ArticlesDto;
import de.ait.timepad.dto.NewArticleDto;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface ArticlesService {
    ArticleDto addArticle(NewArticleDto newArticle);

    ArticlesDto getArticles(Integer year, Integer month, Integer day);
}
