package de.ait.timepad.controllers.api;

import de.ait.timepad.dto.ArticleDto;
import de.ait.timepad.dto.ArticlesDto;
import de.ait.timepad.dto.NewArticleDto;
import de.ait.timepad.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Tags(value = {
        @Tag(name = "Articles")
})
@RequestMapping("/api/articles")
public interface ArticlesApi {

    @Operation(summary = "Создание статьи о пользователе", description = "Доступно только всем пользователям")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Пользователь с указанным ID отсутствует в системе",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Добавленная статья",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ArticleDto addArticle(@RequestBody NewArticleDto newArticle);

    @Operation(summary = "Получение всех статей", description = "Доступно только всем пользователям")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список статей",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticlesDto.class))
                    })
    })
    @GetMapping
    ArticlesDto getArticles(@Parameter(description = "Год", example = "2022") @RequestParam(value = "year", required = false) Integer year,
                            @Parameter(description = "Месяц", example = "2") @RequestParam(value = "month", required = false) Integer month,
                            @Parameter(description = "День", example = "2") @RequestParam(value = "day", required = false) Integer day);
}
