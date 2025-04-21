package com.itacademy.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class BatalhaConfig {
    @Bean
    public Set<Object> set() {
        return new HashSet<>();
    }
}
