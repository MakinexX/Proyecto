package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.PersonaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
	   private PersonaService pService;
	
	
	@GetMapping
	public ArrayList<Persona> getPersonas() {
		return  (ArrayList<Persona>)pService.getPersonas(); 
	}
	
        @GetMapping("/pruba")
	public String  getPersonasM() {
		return  pService.prueba();
	}
	
	 @GetMapping("/getById/{id}")
	    public Optional<Persona> getPersonaById(@PathVariable("id") Long id) {
	       
	        return pService.getById(id);
	        
	    }
            
	 
	 @GetMapping("/getByIdentifiacion/{identificacion}")
	    public Optional<Persona> getPersonaByIdemntificacion(@PathVariable("identificacion") Long identificacion) {
	       
	        return pService. buscarPorIdentificacion(identificacion);
	        
	    }
            @GetMapping("/getByEdad/{edad}")
	    public List<Optional<Persona>> getPersonaById(@PathVariable("edad") int edad) {
	       
	        return pService. buscarPorEdad(edad);
	        
	    }
            
          @GetMapping("/getByIde/{ide}")
          public ResponseEntity<Persona> getByIde(@PathVariable("ide") Long id){
             return pService.getByIde(id);
          }

         @PostMapping
         public Persona post(@RequestBody Persona person){
             return pService.SAveOrUpdate(person);
         }
          @DeleteMapping("/dlete/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        try {
           pService.deletePersona(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    
    
   
    
}
