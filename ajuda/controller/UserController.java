package com.example.userservice.controller;

import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.service.interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;

@RestController
@Slf4j
@RequestMapping(value = "user-service")
public class UserController {

    @Autowired
    private IUserService userService;
//    @GetMapping
//    public Mono<String> helloWorld() {
//        return Mono.just("Hello World");
//    }

    @GetMapping
    public Flux<UserEntity> getAll() {
        return userService.findAllUsers();
    }
//    @GetMapping
//    public Mono<String> helloWorld() {
//        return Mono.just("Hello World");
//    }
}