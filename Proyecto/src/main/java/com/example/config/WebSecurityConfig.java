/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import com.example.config.modelos.Constans;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/**
 *
 * @author Bichin
 */ 
@EnableWebSecurity
@Configuration
class WebSecurityConfig {
    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;
    
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .csrf((csrf)-> csrf.disable()).authorizeHttpRequests(authz -> authz
                        .requestMatchers(Constans.LOGIN_URL).permitAll().requestMatchers(HttpMethod.OPTIONS,"/**")
                        .permitAll().anyRequest().authenticated()).addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
