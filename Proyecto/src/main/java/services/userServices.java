/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import controller.PersonaController;
import java.util.ArrayList;
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
    @Autowired IUser iuser;
    public ArrayList<User> getusers(){
        return (ArrayList<User>) iuser.findAll();
    }
    public User saveUser (User user)   {
        return iuser.save(user);
    }
    public Optional <User> getById(Long id){
        return this.iuser.findById(id);
    }
    /*public Optional <User> updateByid(User request , Long id){
        Optional<User> user = iuser.findById(id);
        user.
    }*/
}
