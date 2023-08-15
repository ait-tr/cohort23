package de.ait.timepad.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UpdateUserDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("UsersController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class UsersIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /api/users is works: ")
    class AddUserTests {

        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void add_user() throws Exception {
            String body = objectMapper.writeValueAsString(NewUserDto.builder()
                    .password("hello007ABBA!")
                    .email("sidikov.marsel@gmail.com").build());

            mockMvc.perform(post("/api/users")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.email", is("sidikov.marsel@gmail.com")))
                    .andExpect(jsonPath("$.role", is("USER")))
                    .andExpect(jsonPath("$.state", is("NOT_CONFIRMED")));
        }
    }

    @Nested
    @DisplayName("GET /api/users is works: ")
    class GetAllUsersTests {

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void get_all_users() throws Exception {
            mockMvc.perform(get("/api/users").param("page", "0"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));
        }

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void get_all_users_with_sorting_pagination_and_filtering() throws Exception {
            mockMvc.perform(get("/api/users")
                            .param("page", "0")
                            .param("orderBy", "role")
                            .param("desc", "true")
                            .param("filterBy", "state")
                            .param("filterValue", "CONFIRMED"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(1)));
        }
    }

    @Nested
    @DisplayName("DELETE /api/users/{userId} method is works: ")
    class DeleteUserTests {

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void delete_exist_user() throws Exception {
            mockMvc.perform(delete("/api/users/2"))
                    .andExpect(status().isOk());
        }

        @Test
        void delete_not_exist_user() throws Exception {
            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("PUT /api/users/{userId} method is works: ")
    class UpdateUserTests {

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void update_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(UpdateUserDto.builder()
                    .newRole("MANAGER")
                    .newState("CONFIRMED").build());

            mockMvc.perform(put("/api/users/1")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.state", is("CONFIRMED")))
                    .andExpect(jsonPath("$.role", is("MANAGER")));
        }

        @Test
        void update_not_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(UpdateUserDto.builder()
                    .newRole("MANAGER")
                    .newState("CONFIRMED").build());

            mockMvc.perform(put("/api/users/1")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isNotFound());
        }

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void update_user_as_admin() throws Exception {

            String body = objectMapper.writeValueAsString(UpdateUserDto.builder()
                    .newRole("ADMIN")
                    .newState("CONFIRMED").build());

            mockMvc.perform(put("/api/users/1")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isForbidden());
        }
    }

    @Nested
    @DisplayName("GET /api/users/{userId} method is works: ")
    class GetUserTests {

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void get_exist_user() throws Exception {

            mockMvc.perform(get("/api/users/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.state", is("NOT_CONFIRMED")))
                    .andExpect(jsonPath("$.role", is("USER")));
        }

        @Test
        void get_not_exist_user() throws Exception {
            mockMvc.perform(get("/api/users/1"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("GET /api/users/{userId}/articles")
    class GetArticlesOfUserTest {

        @Test
        @Sql(scripts = "/sql/data_for_users.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        void get_articles_for_exist_user() throws Exception {
            mockMvc.perform(get("/api/users/1/articles"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.count", is(2)))
                    .andExpect(jsonPath("$.articles[0].id", is(1)))
                    .andExpect(jsonPath("$.articles[1].id", is(2)));
        }

        @Test
        void get_articles_for_not_exist_user() throws Exception {
            mockMvc.perform(get("/api/users/1/articles"))
                    .andExpect(status().isNotFound());
        }
    }
}