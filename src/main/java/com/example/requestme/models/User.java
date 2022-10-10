package com.example.requestme.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;
}
