package com.example.requestme.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Long Id;

    private String name;

    private  String email;

    private String password;

    private String pixKey;

}
