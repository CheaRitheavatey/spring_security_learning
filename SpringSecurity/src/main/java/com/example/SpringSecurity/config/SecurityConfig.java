package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // it mean dont go with the default flow go with the flow that i write here
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // csrf = cross site request forgery
        return http.csrf(customizer -> customizer.disable()) // disable = to turn of the protection
            .authorizeHttpRequests(request -> request.anyRequest()
            .authenticated())

//        http.formLogin(Customizer.withDefaults()); // for web login form
            .httpBasic(Customizer.withDefaults()) // for postman or for basic

        // make http stateless
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return new InMemoryUserDetailsManager()
    }
}
