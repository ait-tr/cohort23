package de.ait.timepad.controllers;

import de.ait.timepad.controllers.api.ArticlesApi;
import de.ait.timepad.dto.ArticleDto;
import de.ait.timepad.dto.ArticlesDto;
import de.ait.timepad.dto.NewArticleDto;
import de.ait.timepad.services.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class ArticlesController implements ArticlesApi {

    private final ArticlesService articlesService;

    @Override
    public ArticleDto addArticle(NewArticleDto newArticle) {
        return articlesService.addArticle(newArticle);
    }

    @Override
    public ArticlesDto getArticles(Integer year, Integer month, Integer day) {
        return articlesService.getArticles(year, month, day);
    }
}
