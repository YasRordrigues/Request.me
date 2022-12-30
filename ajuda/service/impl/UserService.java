package com.example.userservice.service.impl;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.repository.IUserRepository;
import com.example.userservice.service.interfaces.IUserService;
import com.example.userservice.util.UserDtoUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Mono<UserResponseDto> createUser(UserRequestDto userRequestDto) {

        UserEntity user = UserDtoUtil.convertRequestDtoToUserEntity(userRequestDto);
        return userRepository
                .save(user)
                .map(userEntity -> UserResponseDto.builder()
                        .name(userRequestDto.getName())
                        .description(userRequestDto.getDescription())
                        .pixKey(userRequestDto.getPixKey())
                        .role(userRequestDto.getRole())
                        .build());
    }

    @Override
    public Flux<UserEntity> findAllUsers() {
        return userRepository
                .findAll();
//                .switchIfEmpty(Flux.empty())
//                .map(UserDtoUtil::convertToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> findUserById(Integer id) {
        return userRepository
                .findById(id)
                .map(UserDtoUtil::convertToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> findUserByName(String name) {
        return userRepository
                .findByName(name)
                .map(UserDtoUtil::convertToResponseDto);
    }

    @Transactional
    @Override
    public Mono<UserResponseDto> updateUser(Integer id, UserRequestDto userRequestDto) {
         return userRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("Not found entity with id: "+id)))
                .then(userRepository.save(UserDtoUtil.convertRequestDtoToUserEntity(userRequestDto)))
                .map(UserDtoUtil::convertToResponseDto);
    }

    @Override
    public Mono<Void> deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }
}
