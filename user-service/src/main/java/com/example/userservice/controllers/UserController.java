package com.example.userservice.controllers;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.services.UserService;
import com.example.userservice.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public Flux<UserResponseDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserResponseDto> getUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public Mono<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUsers(userRequestDto);
    }

    @PutMapping("/{id}")
    public Mono<UserResponseDto> updateUserById(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
