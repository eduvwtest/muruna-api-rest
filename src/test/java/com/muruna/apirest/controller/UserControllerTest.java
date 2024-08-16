package com.muruna.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muruna.apirest.model.User;
import com.muruna.apirest.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnValidNewUser() throws Exception {
        User user = populateValidNewUser();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldReturnDuplicatedUser() throws Exception {
        User user = populateValidNewUser();

        // User 1 time
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)));

        // User 2 time
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    private User populateValidNewUser() {
        User user = new User();
        user.setName("Juan Rodriguez");
        user.setEmail("juan.rodriguez@dominio.cl");
        user.setPassword("Juan$Rodriguez");
        return user;
    }

    @Test
    void shouldReturnInvalidUserByEmail() throws Exception {
        User user = populateInvalidNewUserByEmail();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private User populateInvalidNewUserByEmail() {
        User user = new User();
        user.setName("Juan Rodriguez");
        user.setEmail("juan.rodriguez@");
        user.setPassword("Juan$Rodriguez");
        return user;
    }

    @Test
    void shouldReturnInvalidUserByPassword() throws Exception {
        User user = populateInvalidNewUserByPassword();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private User populateInvalidNewUserByPassword() {
        User user = new User();
        user.setName("Juan Rodriguez");
        user.setEmail("juan.rodriguez@");
        user.setPassword("aa");
        return user;
    }
}
