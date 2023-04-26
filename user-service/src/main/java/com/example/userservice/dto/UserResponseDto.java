package com.example.userservice.dto;

import com.example.userservice.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {
    private String username;
    private String password;
    private String email;
    private String pix_key;
    private String description;
    private Roles role;
}
