package com.teamsoft.spring.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*@AutoConfigureMockMvc
@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //기본값
class BaseControllerTest {

    //@Autowired
    private MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본페이지 요청")
    @Test
    void testRoot() throws Exception {
        // Given

        // When
        ResultActions result = mvc.perform(get("/"));

        // Then
        result
            .andExpect(status().isOk())
            //.andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
            //.andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
            .andExpect(content().string(containsString("index.html test")))
            .andExpect(view().name("index"));
            //.andDo(print());

    }
}*/


//슬라이스 테스트
//@WebMvcTest //모든컨트롤러 테스트
@WebMvcTest(BaseController.class)
class BaseControllerTest {

    //@Autowired
    private MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본페이지 요청")
    @Test
    void testRoot() throws Exception {
        // Given

        // When
        ResultActions result = mvc.perform(get("/"));

        // Then
        result
                .andExpect(status().isOk())
                //.andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                //.andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("index.html test")))
                .andExpect(view().name("index"));
                //.andDo(print());

    }
}