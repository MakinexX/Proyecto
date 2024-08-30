package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    private Integer idpersona;
    private Long identificacion;
    private String pnombre;
    private String papellido;
    private String fechanacimiento;
    private Character email;
    private Integer edad;
    private Integer edadclinica;
}
