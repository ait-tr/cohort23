package de.ait.timepad.controllers;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.ArticlesRepository;
import de.ait.timepad.repositories.UsersRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ArticlesController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class ArticlesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @BeforeEach
    public void setUp() {
        articlesRepository.clear();
        usersRepository.clear();
    }

    @Nested
    @DisplayName("POST /api/articles is works: ")
    class AddArticleTest {

        @Test
        public void add_article_for_exist_user() throws Exception {
            usersRepository.save(User.builder().email("test@mail.com")
                    .articles(new ArrayList<>())
                    .state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(post("/api/articles")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"text\": \"Test Article\",\n" +
                                    "  \"aboutUserId\": 1,\n" +
                                    "  \"publishDate\": \"2022-02-02\"\n" +
                                    "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.text", is("Test Article")))
                    .andExpect(jsonPath("$.publishDate", is("2022-02-02")))
                    .andExpect(jsonPath("$.about.id", is(1)))
                    .andExpect(jsonPath("$.about.email", is("test@mail.com")));

        }

        @Test
        public void add_article_for_not_exist_user() throws Exception {
            mockMvc.perform(post("/api/articles")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"text\": \"Test Article\",\n" +
                                    "  \"aboutUserId\": 1\n" +
                                    "}"))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}