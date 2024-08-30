package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Persona;
import respositories.IPersona;
import services.personaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	personaService pService;
	
	@GetMapping("{id}")
	public Persona getPersona(@RequestParam Long id ) {
		return pService.getPersonaById(id);
		
	}
	
	@PostMapping
	void postPersona(Persona p){
		pService.setPersona(p);
	}
	
	
	
	

}
