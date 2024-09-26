package com.example.demo.controller;

import com.example.demo.models.Persona;
import com.example.demo.models.User;
import com.example.demo.models.UserPk;
import com.example.demo.services.PersonaService;
import com.example.demo.services.UserService;
import java.util.List;
import java.util.Optional;
import jdk.jfr.BooleanFlag;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userS;
    @Autowired
    PersonaService pS;
    @GetMapping
    public List<User> getUsers() {
        return userS.getPersonas();
    }

    @PostMapping()
    public void post(@RequestBody User user){
         //System.out.println(user.getId().getPersona().getPnombre()+" userlogin "+user.getPassword());
         
        //Persona persona = user.getId().getPersona();
       // Persona byId = pS.getById(persona.getIdpersona()).get();
         userS.save(user);
        //System.out.println(user.getId().getPersona());
    }
    /*public ResponseEntity<User> post(@RequestBody User u) {
        try {
            return new ResponseEntity(userS.save(u), HttpStatus.OK);
        }catch(HttpStatusCodeException e){
            return ResponseEntity.notFound().build();
        }    
    }
    */
    @PutMapping("/put/{password}")
    public String put(@RequestBody User user, @PathVariable("password") String password){
        if(userS.bbuscarByContrasenia(password).isPresent()){
            return "esta beunbardo";
        }else{
            return "no esta buenardo";
        }
        
    }
    @Autowired
    PersonaService pService;
    @PostMapping("/save/{idPersona}")
    public String postS(@PathVariable( "idPersona") Long idPersona){
          User user= new User();
         try{
              Optional<Persona> byId = pService.getById(idPersona);
              if(byId.isPresent()){
                  user.setId(new UserPk(pService.getById(idPersona).get()));
                 user.setPassword("prueba");
                  userS.save(user);
                  
              }
              return user.toString();
            
         }catch(Exception e){
             return e.getMessage();
         }
         
        
    }
    @DeleteMapping("/delete/{userName}")   
    public void  delete(@PathVariable("userName") String username ){
        
    }
    @GetMapping("/buscar/{userName}")
    public User getByUserName(@PathVariable("userName") String userName){
        return userS.getByUserName(userName);
        
    }
    @PostMapping("/cambiarP/{pass}")
    public void cambiarP(@RequestBody User user,@PathVariable("pass") String password){
         userS.cambiarContraseña(user.getPassword(), password,user.getUsername());
    }
}
