package com.teamsoft.spring.dto;

import com.teamsoft.spring.constant.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class APIDataResponseTest {

    @DisplayName("문자열 데이터가 주어지면 표준 성공 응답을 생성한다.")
    @Test
    void giveOkData_thenSuccessResponse() {
        // Given
        String data = "test data";

        // When
        APIDataResponse<String> response = APIDataResponse.of(data);
        System.out.println(response);

        // Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);
    }

    @DisplayName("데이터가 없을때 비어있는 표준 성공 응답을 생성한다.")
    @Test
    void myTest() {
        // Given

        // When
        APIDataResponse<String> response = APIDataResponse.empty();

        // Then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", null);
    }


}