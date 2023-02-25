package com.study.studyjavaspringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.studyjavaspringboot.model.LoginParamModel;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
 * ログインAPIコントローラのテスト
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    void testPostLoginSuccess() throws Exception {
        LoginParamModel loginParam = new LoginParamModel();
        loginParam.setUsername("testuser1");
        loginParam.setPassword("password1");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginParam);
    
        mockMvc.perform(post("/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.username", is("testuser1")));
    }
}
