/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.config.JTWAuthenticationConfig;
import com.example.config.modelos.JWTRequest;
import com.example.config.modelos.JWTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bichin
 */
@RestController
@CrossOrigin
public class JWTAuthenticationController {
    @Autowired
    JTWAuthenticationConfig jwtAuthenticationConfig;
    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;
    @RequestMapping(
            value = "/authenticate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )       
    
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception{
        System.out.println("***********************************************");
        System.out.println("authenticationRequest.getUsername(): [ "+ authenticationRequest.getUsername()+" ]");
        System.out.println("authenticarionRequest.getPassword(): [ "+ authenticationRequest.getPassword()+" ]");
        System.out.println("***********************************************");
        
        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtAuthenticationConfig.getJWTToken(userDetails.getUsername());
        System.out.println("***********************************************");
        System.out.println("token: [" + token+ " ]");
        System.out.println("***********************************************");
        return ResponseEntity.ok(new JWTResponse(token));
    }
}

