/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Objects;
import lombok.Data;

/**
 *
 * @author Bichin
 */
@Data
public class UserId{
private int idPersona;
    private String login;
   
    public UserId() {
   
    }
 public UserId(int idPersona,String login) {
    this.idPersona=idPersona;
    this.login=login;
   
    }
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     UserId that = (UserId) o;
     return idPersona == that.idPersona && Objects.equals(login, that.login);
 }

 @Override
 public int hashCode() {
     return Objects.hash(idPersona, login);
 }

}