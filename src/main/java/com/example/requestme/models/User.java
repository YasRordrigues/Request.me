package com.example.requestme.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String pixKey;

    public User(String name, String email, String password, String pixKey) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.pixKey= pixKey;
    }
}
