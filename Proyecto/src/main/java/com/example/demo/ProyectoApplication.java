package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication (exclude ={UserDetailsServiceAutoConfiguration.class})
public class ProyectoApplication {
//bnbbbbbbb
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
        
}
