/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config.modelos;

import java.io.Serializable;

/**
 *
 * @author Bichin
 */
public class JWTResponse implements Serializable{
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    
    public JWTResponse(String response){
        this.jwttoken= response;       
    }
    public String getToken(){
        return this.jwttoken;
    }
}
