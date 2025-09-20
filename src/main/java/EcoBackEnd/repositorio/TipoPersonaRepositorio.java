package EcoBackEnd.repositorio;

import EcoBackEnd.modelo.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPersonaRepositorio extends JpaRepository<TipoPersona, Integer> {

    Optional<TipoPersona> findById(Long id);
}
