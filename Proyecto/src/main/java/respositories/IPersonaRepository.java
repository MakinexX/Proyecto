package respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
