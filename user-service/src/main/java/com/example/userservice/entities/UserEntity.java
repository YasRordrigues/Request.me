package com.example.userservice.entities;
import com.example.userservice.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(value = "users", schema = "users")
public class UserEntity {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String pix_key;
    private String description;
    private String role;
}
