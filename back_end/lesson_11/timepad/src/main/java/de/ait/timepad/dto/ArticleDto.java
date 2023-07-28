package de.ait.timepad.dto;

import de.ait.timepad.models.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Статья о каком-либо пользователе")
public class ArticleDto {

    @Schema(description = "Идентификатор статьи", example = "1")
    private Long id;

    @Schema(description = "Текст статьи", example = "Текст о каком-либо пользователе...")
    private String text;

    @Schema(description = "Пользователь, которому посвящена статья")
    private UserInArticleDto about;

    @Schema(description = "Дата публикации в формате YYYY-MM-DD", example = "2022-02-02")
    private String publishDate;

    public static ArticleDto from(Article article) {
        ArticleDto result = ArticleDto.builder()
                .id(article.getId())
                .text(article.getText())
                .build();

        if (article.getAbout() != null) {
            result.setAbout(UserInArticleDto.from(article.getAbout()));
        }

        if (article.getPublishDate() != null) {
            result.setPublishDate(article.getPublishDate().toString());
        }

        return result;
    }

    public static List<ArticleDto> from(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
