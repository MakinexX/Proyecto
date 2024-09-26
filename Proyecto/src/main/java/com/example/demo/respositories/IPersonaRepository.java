package com.example.demo.respositories;

import java.util.Optional;
import com.example.demo.models.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>, CrudRepository<Persona, Long>{

    @Query(value = "SELECT * FROM personas u where u.edad = ?1", nativeQuery = true)
    public List<Optional<Persona>>getByEdad(int edad);

    @Query(value = "SELECT * FROM personas u where u.papellido = ?1", nativeQuery = true)
    public List<Optional<Persona>> getByPapellido(String apellido);

    @Query(value = "SELECT * FROM personas u where u.pnombre = ?1", nativeQuery = true)
    public List<Optional<Persona>> getByPnombre(String nombre);
    
    public Optional<Persona> getByIdentificacion(Long indentificacion);
}
