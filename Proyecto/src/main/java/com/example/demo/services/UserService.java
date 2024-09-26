
package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.models.UserPk;
import com.example.demo.respositories.IPersonaRepository;
import com.example.demo.respositories.IuserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
    @Autowired
    IuserRepository userR;
    @Autowired
    IPersonaRepository p;
    
      public ArrayList<User> getPersonas() {
        return (ArrayList<User>) userR.findAll();
    }
      public Optional<User> getById(UserPk id) {
        return userR.findById(id);
    }
      
    public User save(User user){
        //User user= new User(new UserPk(p.findById(1L).get(), "login"), "paword", "apikey");
         return userR.save(user);
    }  
     public boolean delete(UserPk user){
         boolean ok= false;
         if(getById(user).isPresent()){
            userR.delete(getById(user).get());
            ok = true;
            
         }
         return ok;
         
     }
     public void delete(String userName){
        Optional<User> optional = userR.getByUsername(userName);
         if(optional.isPresent()){
             userR.delete(optional.get());
             
         }
     }
     public User getByUserName(String userName){
         return userR.getByUsername(userName).get();
     }
     public Optional<User> bbuscarByContrasenia(String password){
         return userR.getByPassword(password);
     }
     public void cambiarContraseña(String oldPassword,String newPassword,String userName){
          userR.alterPassword( oldPassword, newPassword,userName);
     }
     //hbhhhhhhhhhhhh
     
    
      
    
  
}
