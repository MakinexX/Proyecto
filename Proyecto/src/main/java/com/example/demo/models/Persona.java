package com.example.demo.models;

import java.time.Duration;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.time.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")

public class Persona {

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", identificacion=" + identificacion + ", pnombre=" + pnombre + ", papellido=" + papellido + ", sapellido=" + sapellido + ", fechanacimiento=" + fechanacimiento + ", email=" + email + ", edad=" + edad + ", edadclinica=" + edadclinica + '}';
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = calcularEdad();
    }

    public Integer getEdadclinica() {
        return edadclinica;
    }

    public void setEdadclinica(Integer edadclinica) {
        this.edadclinica = edadclinica;
    }
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
    private LocalDate fechanacimiento;
    @Column(name ="email")
    private String email;
    @Column(name ="edad")
    private Integer edad;
    @Column(name ="edadclinica")
    private Integer edadclinica;
    
   
    
    public Persona() {
    }
    private Integer calcularEdad(){
        if(this.fechanacimiento!=null){
             Period period = Period.between(this.fechanacimiento, LocalDate.now());
             return period.getYears();
        }else return null;
        
    }
    public Persona(Long identificacion, String pnombre, String papellido, LocalDate fechanacimiento, String email, Integer edad, Integer edadclinica) {
        this.identificacion = identificacion;
        this.pnombre = pnombre;
        this.papellido = papellido;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.edad = edad;
        this.edadclinica = edadclinica;
    }   
    
}