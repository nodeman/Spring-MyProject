package com.teamsoft.spring.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdminRequest {
    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String memo;
}
