package com.example.userservice.entities;

import com.example.userservice.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UserEntity {
    @Id
    private Long user_id;

    private String name;
    private String pixKey;
    private String description;
    @Enumerated(EnumType.STRING)
    private Roles userRole;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
