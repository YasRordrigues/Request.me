package com.example.userservice.services;

import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.repositories.IUserRepository;
import com.example.userservice.services.interfaces.IUserService;
import com.example.userservice.utils.UserDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public Flux<UserResponseDto> findAllUsers() {
        return userRepository
                .findAll()
                .map(UserDtoUtil::convertUserEntityToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> createUsers(UserRequestDto user) {
        return userRepository
                .save(UserDtoUtil.convertRequestDtoToEntity(user))
                .map(UserDtoUtil::convertUserEntityToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> findUserById(Integer id) {
        return userRepository
                .findById(id)
                .map(UserDtoUtil::convertUserEntityToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> findUserByName(String name) {
        return userRepository
                .findByName(name)
                .map(UserDtoUtil::convertUserEntityToResponseDto);
    }

    @Override
    public Mono<UserResponseDto> updateUser(Integer id, UserRequestDto user) {
        return userRepository
                .findById(id)
                .flatMap(user1 -> {
                    user1.setName(user.getName());
                    user1.setDescription(user.getDescription());
                    user1.setPix_key(user.getPix_key());
                    return userRepository.save(user1);
                })
                .map(UserDtoUtil::convertUserEntityToResponseDto);
    }

    @Override
    public Mono<Void> deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }
}
