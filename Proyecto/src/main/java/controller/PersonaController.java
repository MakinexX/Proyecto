package controller;

import java.util.ArrayList;
import java.util.Optional;
import models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.PersonaService;

@RestController
@RequestMapping
public class PersonaController {
    @Autowired
	   PersonaService pService;
	
	
	@GetMapping
	public ArrayList<Persona> getPersonas() {
		return  (ArrayList<Persona>)pService.getPersonas(); 
	}
	
	 @GetMapping("/{id}")
	    public Optional<Persona> getPersonaById(@PathVariable("id") Long id) {
	       
	        return pService.getById(id);
	        
	    }
	 
	 @GetMapping("/{edad}")
	    public Optional<Persona> getPersonaById(@PathVariable("edad") int edad) {
	       
	        return pService.getByEdad(edad);
	        
	    }
    
}
