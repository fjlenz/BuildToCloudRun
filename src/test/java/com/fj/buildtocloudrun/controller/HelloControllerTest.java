package com.fj.buildtocloudrun.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void callingHelloAnswersWith400BadRequest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void callingHelloHorstAnswersWith200HelloHorst() throws Exception {
        mockMvc.perform(get("/hello").param("name", "Horst"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", equalToIgnoringCase("Hello Horst")));
    }


}
