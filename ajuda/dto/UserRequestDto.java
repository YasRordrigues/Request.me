package com.example.userservice.dto;

import com.example.userservice.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

    //    @NotBlank(message = "Name is a required field")
    private String name;

    //    @NotBlank(message = "Name is a required field")
    private String pixKey;

    //    @Nullable
    private String description;

    private Roles role;

}
