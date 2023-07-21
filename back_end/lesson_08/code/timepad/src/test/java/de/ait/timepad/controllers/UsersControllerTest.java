package de.ait.timepad.controllers;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        usersRepository.clear();
    }

    @Test
    void addUser() throws Exception {
        mockMvc.perform(post("/api/users")
                .header("Content-Type", "application/json")
                .content("{\n" +
                        "  \"email\": \"sidikov.marsel@gmail.com\",\n" +
                        "  \"password\": \"qwerty007\"\n" +
                        "}"))
//                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.email", is("sidikov.marsel@gmail.com")))
                .andExpect(jsonPath("$.role", is("USER")))
                .andExpect(jsonPath("$.state", is("NOT_CONFIRMED")));
    }

    @Test
    void getAllUsers() throws Exception {
        usersRepository.save(User.builder().id(3L).state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());
        usersRepository.save(User.builder().id(4L).state(User.State.NOT_CONFIRMED).role(User.Role.USER).build());

        mockMvc.perform(get("/api/users"))
                .andExpect(jsonPath("$.count", is(2)));
    }
}