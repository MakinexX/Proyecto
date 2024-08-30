package services;

import java.util.List;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Persona;
import respositories.IPersonaRepository;
@Service
public class personaService {
     	IPersonaRepository  repositoryPersona;
     	@Autowired
     	public List<Persona> getPersonas() {
			return (List<Persona>) repositoryPersona.findAll();

		}
     	
     	@Autowired
     	public Persona getPersonaById(Long id) {
     		return (Persona)repositoryPersona.getById(id);
     	}
     	@Autowired
     	public void setPersona(Persona person) {
     		repositoryPersona.save(person);
     	}
     	@Autowired
     	public boolean delete(Persona person) {
     		boolean borrado=true;
     		try {
     			repositoryPersona.delete(person);
     		}catch (IllegalArgumentException e) {
				borrado=false;
			}catch (OptimisticEntityLockException e) {
				borrado=false;
			}
     		return borrado;
     	}
}
