package com.example.documentFlow.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${token.signing.key}")
    private String key;

    @Bean
    public String jwtSigningKey() {
        return key;
    }
}
