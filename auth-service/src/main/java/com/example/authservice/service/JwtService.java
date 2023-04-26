package com.example.authservice.service;

import com.example.authservice.dto.AuthDto;
import com.example.authservice.dto.LoginDto;
import com.example.authservice.dto.UserDto;
import com.example.authservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public Mono<AuthDto> login(LoginDto loginDto) {
        return userService.getUserByUsername(loginDto.getUsername())
                .flatMap(user -> {
                    System.out.println(user);
                    System.out.println(loginDto);
                    if (Objects.equals(loginDto.getPassword(), user.getPassword())) {
                        String token = jwtUtils.generateJwtToken(user);
                        String refreshToken = jwtUtils.generateRefreshToken();

                        AuthDto authDto = new AuthDto();
                        authDto.setToken(token);
                        authDto.setRefreshToken(refreshToken);
                        authDto.setUser(user);

                        return Mono.just(authDto);
                    } else {
                        return Mono.error(new RuntimeException("Invalid password"));
                    }
                });
    }




    public Mono<UserDto> signup(UserDto userDto) {
        return userService.getUserByUsername(userDto.getUsername())
                .flatMap(existingUser -> Mono.<UserDto>error(new RuntimeException("Username already exists")))
                .switchIfEmpty(Mono.defer(() -> userService.createUser(userDto)));
    }

    public Flux<UserDto> getUsers() {
        return userService.getAllUsers();
    }
}
