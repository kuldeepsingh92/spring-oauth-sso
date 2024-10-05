package com.springoauth.SpringOAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                // Enable authentication for all urls
                .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                // Enable oauth2 login
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

}
