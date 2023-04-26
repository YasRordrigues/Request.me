package com.example.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String USERS_SERVICE_URL = "http://localhost:8083";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(USERS_SERVICE_URL)
                .build();
    }
}

