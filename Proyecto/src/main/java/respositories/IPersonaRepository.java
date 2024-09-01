package respositories;

import java.util.Optional;
import models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT * FROM usuarios u where u.edad = ?1", nativeQuery = true)
    public Optional<Persona> getByEdad(int edad);

    @Query(value = "SELECT * FROM usuarios u where u.papellido = ?1", nativeQuery = true)
    public Optional<Persona> getByPapellido(String apellido);

    @Query(value = "SELECT * FROM usuarios u where u.pnombre = ?1", nativeQuery = true)
    public Optional<Persona> getByPnombre(String nombre);
}
