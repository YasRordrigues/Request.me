package com.example.authservice.controller;

import com.example.authservice.dto.AuthDto;
import com.example.authservice.dto.LoginDto;
import com.example.authservice.dto.UserDto;
import com.example.authservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {
    private final JwtService jwtService;

    @GetMapping("hello")
    public Mono<String> hello() {
        return Mono.just("Hello World!");
    }
    @GetMapping("/secure/hello")
    public Mono<String> secureHello() {
        return Mono.just("Hello Secure World!");
    }

    @PostMapping("login")
    public Mono<AuthDto> login(@RequestBody LoginDto loginDto) {
        return jwtService.login(loginDto);
    }

    @PostMapping
    public Mono<UserDto> signup(@RequestBody UserDto userDto) {
        return jwtService.signup(userDto);
    }

    @GetMapping
    public Flux<UserDto> getUsername() {
        return jwtService.getUsers();
    }

}