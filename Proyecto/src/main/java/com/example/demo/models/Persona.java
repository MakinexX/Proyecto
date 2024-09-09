package com.example.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")
@Getter @Setter
@ToString
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idpersona")
    private Long idpersona;
    @Column(name ="identificacion")
    private Long identificacion;
    @Column(name ="pnombre")
    private String pnombre;
    @Column(name ="papellido")
    private String papellido;
    @Column(name ="sapellido")
    private String sapellido;
    @Column(name ="fechanacimiento")
    private String fechanacimiento;
    @Column(name ="email")
    private Character email;
    @Column(name ="edad")
    private Integer edad;
    @Column(name ="edadclinica")
    private Integer edadclinica;
    
    @OneToOne(mappedBy = "personas", cascade = CascadeType.ALL)
    private User user;
    
    public Persona() {
    }
    
    public Persona(Long identificacion, String pnombre, String papellido, String fechanacimiento, Character email, Integer edad, Integer edadclinica) {
        this.identificacion = identificacion;
        this.pnombre = pnombre;
        this.papellido = papellido;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.edad = edad;
        this.edadclinica = edadclinica;
    }        
}