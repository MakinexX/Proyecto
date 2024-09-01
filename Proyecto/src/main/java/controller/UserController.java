package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private userServices usuarioService;
     
    @GetMapping
    public List<User> getAll(){
        return usuarioService.getUsuarios();
    }
    @PostMapping
    public void saveUpdate(@RequestBody User usuario){
         usuarioService.SaveUpdate(usuario);
    }
     @DeleteMapping("/{UsuarioId}")
    public void delete (@PathVariable("UsuarioId") Long  usuarioId){
         usuarioService.delete(usuarioId);
    }
    
}
