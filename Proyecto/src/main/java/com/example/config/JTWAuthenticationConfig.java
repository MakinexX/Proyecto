/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;

import com.example.config.modelos.Constans;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author Bichin
 */
@Configuration 

public class JTWAuthenticationConfig {
    
    public String getJWTToken(String username){
        
        List<GrantedAuthority> grantedAuthority = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");        
        String token = Jwts
                .builder()
                .setId("PPOOI_JWT")
                .setSubject(username)
                .claim("authorities", grantedAuthority.stream().map(GrantedAuthority:: getAuthority)
                        .collect(Collectors.toList())).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+ Constans.TOKEN_EXPIRATION_TIME))
                        .signWith(Constans.getSigningKey(Constans.SUPER_SECRET_KEY), SignatureAlgorithm.HS512).compact();
        
        return "Bearer" + token;
                
    }
}
