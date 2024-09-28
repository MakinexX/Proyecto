/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config.modelos;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Bichin
 */
@Data
public class JWTRequest implements Serializable{
    private static final long serialVersionUID= 1L;
    
    private String Username;
    private String Password;
    
    public JWTRequest(){        
    }

    public JWTRequest(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }        
}
