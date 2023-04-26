package com.example.userservice.repositories;

import com.example.userservice.entities.UserEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends R2dbcRepository<UserEntity, Integer> {

    Mono<UserEntity> findByUsername(String username);
}
