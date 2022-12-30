package com.example.userservice.repository;

import com.example.userservice.entities.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
    Mono<UserEntity> findByName(String name);
}
