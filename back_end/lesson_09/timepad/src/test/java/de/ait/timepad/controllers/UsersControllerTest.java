package de.ait.timepad.controllers;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("UsersController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        usersRepository.clear();
    }

    @Nested
    @DisplayName("POST /api/users is works: ")
    class AddUserTests {
        @Test
        void add_user() throws Exception {
            mockMvc.perform(post("/api/users")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                                    "  \"password\": \"qwerty007\"\n" +
                                    "}"))
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
        void get_all_users() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(get("/api/users"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));
        }
    }

    @Nested
    @DisplayName("DELETE /api/users/userId method is works: ")
    class DeleteUserTests {

        @Test
        void delete_exist_user() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isOk());
        }

        @Test
        void delete_not_exist_user() throws Exception {
            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("PUT /api/users/userId method is works: ")
    class UpdateUserTests {

        @Test
        void update_exist_user() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

            mockMvc.perform(put("/api/users/1")
                    .header("Content-Type", "application/json")
                    .content("{\n" +
                            "  \"newRole\" : \"MANAGER\",\n" +
                            "  \"newState\" : \"BANNED\"\n" +
                            "}\n"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.state", is("BANNED")))
                    .andExpect(jsonPath("$.role", is("MANAGER")));
        }

        @Test
        void update_not_exist_user() throws Exception {

            mockMvc.perform(put("/api/users/1")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newRole\" : \"MANAGER\",\n" +
                                    "  \"newState\" : \"BANNED\"\n" +
                                    "}\n"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void update_user_as_admin() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());
            mockMvc.perform(put("/api/users/1")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"newRole\" : \"ADMIN\",\n" +
                                    "  \"newState\" : \"BANNED\"\n" +
                                    "}\n"))
                    .andExpect(status().isForbidden());
        }
    }

    @Nested
    @DisplayName("GET /api/users/userId method is works: ")
    class GetUserTests {
        @Test
        void get_exist_user() throws Exception {
            usersRepository.save(User.builder().state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

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
}