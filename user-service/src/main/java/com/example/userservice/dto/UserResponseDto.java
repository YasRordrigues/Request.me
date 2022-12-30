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
    private Integer id;
    private String name;
    private String pix_key;
    private Roles role;
}
