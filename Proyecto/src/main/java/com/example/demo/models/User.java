package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.ToString;
@Data
@ToString
@Entity
@Table(name = "usuarios")
public class User {

    @EmbeddedId
    private UserPk id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "apikey")
    private String apiKey;
 
    public User() {

    }

    public User(String password, String apiKey) {
        this.password = password;
        this.apiKey = apiKey;
    }

    public UserPk getId() {
        return id;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setId(UserPk id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public User(UserPk id, String password, String apiKey) {
        this.id = id;
        this.password = password;
        this.apiKey = apiKey;
    }

    public User(Persona persona,String password) {
        this.id.setPersona(persona);
        this.id.setLogin(crearLogin(persona));
        this.password=password; 
    }
    private String crearLogin(Persona persona){
        return persona.getPnombre()+persona.getIdentificacion().toString();           
    }

}
