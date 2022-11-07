package com.example.requestme.dtos;

import com.example.requestme.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getUser_id())
                .username(user.getUsername())
                .build();
    }

}
