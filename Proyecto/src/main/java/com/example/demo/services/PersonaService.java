/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.respositories.IPersonaRepository;
import java.net.http.HttpResponse;
import java.util.List;
import static javax.swing.text.html.HTML.Tag.P;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

/**
 *
 * @author Bichin
 */
@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository pRepository;
    
    

    public ArrayList<Persona> getPersonas() {
        return (ArrayList<Persona>) pRepository.findAll();
    }

    public Optional<Persona> getById(Long id) {
        return  pRepository.findById(id);
    }
    public ResponseEntity<Persona> getByIde(Long id){
        Persona person = new Persona();
         new ResponseEntity(HttpStatus.OK);
        try{
            Persona p =pRepository.findById(id).get();
            new ResponseEntity(p,HttpStatus.OK);
        }catch(HttpStatusCodeException e){
            new ResponseEntity(person,e.getStatusCode());
            
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
        
    }

    

    public boolean deletePersona(Persona Per) {
        try {
            pRepository.delete(Per);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public Persona SAveOrUpdate(Persona per) {
    
        return pRepository.save(per);
    }
    public void deletePersona(Long id) {
        pRepository.deleteById(id);
    }
    public void findById(Long id){
        pRepository.findById(id);
    }
   public  Optional<Persona> buscarPorIdentificacion(Long identificacion) {
        return pRepository.getByIdentificacion(identificacion);
    }
   
   public String prueba (){
        return "probamdo";
        
   }

    public List<Optional<Persona> > buscarPorEdad(Integer edad) {
        return pRepository.getByEdad(edad);
    }

    public List<Optional<Persona> > buscarPorPnombre(String pnombre) {
        return pRepository.getByPnombre(pnombre);
    }

    public List<Optional<Persona> > buscarPorPapellido(String papellido) {
        return pRepository.getByPapellido(papellido);
    }
    
    
}
