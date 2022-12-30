package com.example.userservice.services.interfaces;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    Flux<UserResponseDto> findAllUsers();
    Mono<UserResponseDto> createUsers(UserRequestDto user);
    Mono<UserResponseDto> findUserById(Integer id);
    Mono<UserResponseDto> findUserByName(String name);
    Mono<UserResponseDto> updateUser(Integer id, UserRequestDto user);
    Mono<Void> deleteUser(Integer id);
}
