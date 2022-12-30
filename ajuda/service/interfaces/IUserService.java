package com.example.userservice.service.interfaces;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    Mono<UserResponseDto> createUser(UserRequestDto userRequestDto);
    Flux<UserEntity> findAllUsers();
    Mono<UserResponseDto> findUserById(Integer id);
    Mono<UserResponseDto> findUserByName(String name);
    Mono<UserResponseDto> updateUser(Integer id, UserRequestDto userRequestDto);
    Mono<Void> deleteUser(Integer id);
}
