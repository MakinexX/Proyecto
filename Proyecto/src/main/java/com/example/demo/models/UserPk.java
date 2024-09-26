
package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

 @ToString
@Embeddable
public class UserPk {

    @Column(name = "Login",unique = true ,updatable = false)
    private String login;

    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Persona persona;

    public UserPk(Persona persona, String login) {
        this.persona = persona;
        this.login = login;
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public UserPk(Persona persona){
        this.persona= persona;
        this.login= setLogin(persona);
        
    }
    
    
   
    private String setLogin(Persona p){
         String pnom= persona.getPnombre();
         String ape= persona.getPapellido();
          Long ide= persona.getIdpersona();
        if(pnom!=null & ape!=null & persona.getIdpersona()!= null){
            return pnom+ape+ide;
        }
        return "LoginMaquio";
    }
    
    public UserPk() {
    }

}
