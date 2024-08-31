package controller;

import java.util.ArrayList;
import java.util.Optional;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.userServices;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private userServices useServices;
    @GetMapping
    public ArrayList<User> getUsers(){
     return this.useServices.getusers();
     }
    @PostMapping
    public User saveUser(@RequestBody User user){
        return this.useServices.saveUser(user);
    }
    @GetMapping (path ="/{id}")
    public Optional <User> getUserById(@PathVariable Long id){
        return this.useServices.getById(id);
    }
    
}
