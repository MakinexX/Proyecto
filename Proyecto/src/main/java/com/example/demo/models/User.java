package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="usuarios")
@Data
public class User {
private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idpersona")
    private Long idPersona;
    @Id
    @Column(name ="login")
    private String login;
    @Column(name ="password")
    private String pasword;
    @OneToOne
    @MapsId
    @JoinColumn(name = "idpersona",referencedColumnName = "idpersona")
    private Persona persona;
    public User() {
   
    }
 public User( Long idPersona,String login,String pasword,Persona persona) {
    this.idPersona=idPersona;
    this.login=login;
    this.pasword=pasword;
    this.persona=persona;
   
    }       
}
