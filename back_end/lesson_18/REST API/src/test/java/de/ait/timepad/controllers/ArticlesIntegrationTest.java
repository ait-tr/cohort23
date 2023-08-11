package de.ait.timepad.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.timepad.dto.NewArticleDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ArticlesController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class ArticlesIntegrationTest {

    private static final NewArticleDto NEW_ARTICLE = NewArticleDto.builder()
            .text("Test Article")
                    .aboutUserId(1L)
                    .publishDate("2022-02-02")
                    .build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /api/articles is works: ")
    class AddArticleTest {

        @Test
        @Sql(scripts = "/sql/data_for_articles.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void add_article_for_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(NEW_ARTICLE);

            mockMvc.perform(post("/api/articles")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.text", is("Test Article")))
                    .andExpect(jsonPath("$.publishDate", is("2022-02-02")))
                    .andExpect(jsonPath("$.about.id", is(1)))
                    .andExpect(jsonPath("$.about.email", is("test@mail.com")));
        }

        @Test
        public void add_article_for_not_exist_user() throws Exception {
            String body = objectMapper.writeValueAsString(NEW_ARTICLE);

            mockMvc.perform(post("/api/articles")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}