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
import org.springframework.stereotype.Service;

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
        return Optional.of(pRepository.getById(id));
    }

    public Optional<Persona> getByEdad(int edad) {
        return pRepository.getByEdad(edad);
    }

    public Optional<Persona> getByApellido(String apellido) {
        return pRepository.getByPapellido(apellido);
    }

    public Optional<Persona> getByPnombre(String nombre) {
        return pRepository.getByPnombre(nombre);

    }

    public boolean deletePersona(Persona Per) {
        try {
            pRepository.delete(Per);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public boolean SAveOrUpdate(Persona per) {
        try {
            pRepository.save(per);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
