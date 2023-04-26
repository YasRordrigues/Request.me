package com.example.authservice.service;
import org.springframework.http.HttpStatus;
import com.example.authservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final WebClient webClient;
    public Mono<UserDto> getUserByUsername(String username) {
        return webClient.get()
                .uri("/user-service/username/" + username)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

    public Mono<UserDto> createUser(UserDto userDto) {
        return webClient.post()
                .uri("/user-service")
                .body(BodyInserters.fromValue(userDto))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new RuntimeException("Error creating user")))
                .bodyToMono(UserDto.class);
    }

    public Flux<UserDto> getAllUsers() {
        return webClient.get()
                .uri("/user-service")
                .retrieve()
                .bodyToFlux(UserDto.class);
    }
}
