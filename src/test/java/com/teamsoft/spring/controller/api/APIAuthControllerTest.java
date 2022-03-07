package com.teamsoft.spring.controller.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamsoft.spring.dto.AdminRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
class APIAuthControllerTest {

    //@Autowired
    //private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @DisplayName("[API][POST] 관리자 가입 - 정상 입력하면 회원 정보를 추가하고 안내 메시지 리턴")
    @Test
    void signUp() throws Exception{
        // Given
        AdminRequest request = AdminRequest.builder()
                .email("test@test.com")
                .nickname("testNick")
                .password("password")
                .phoneNumber("010-1234-5678")
                .memo("test nemo")
                .build();

        // When & Then
        /*
        mvc.perform(
                post("/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request))
        )
                .andExpect(status().isOk());*/
               // .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));


        System.out.println("signUp");
    }

    @Test
    void login() {
        System.out.println("login");
    }
}