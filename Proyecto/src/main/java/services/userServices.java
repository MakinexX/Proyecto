/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import controller.PersonaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import respositories.IUser;

/**
 *
 * @author Bichin
 */
public class userServices {
    @Autowired
   IUser iuser ;
    public List<User> getUsuarios (){
        return iuser.findAll();
    }
    
    public Optional<User> getUsuario(Long id){
        return iuser.findById(id);
    }
    public void SaveUpdate (User usuario){
        iuser.save(usuario);
    }
    public void delete(Long id){
        iuser.deleteById(id);
    }
     public void cambiarPassword(Long idpersona, String nuevoPassword) {
        Optional<User> usuarioOpt = iuser.findById(idpersona);
        if (usuarioOpt.isPresent()) {
            User usuario = usuarioOpt.get();
            usuario.setPasword(nuevoPassword);
            iuser.save(usuario);
        }
    }
}
