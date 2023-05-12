package EcoBackEnd.repositorio;

import EcoBackEnd.modelo.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPersonaRepositorio extends JpaRepository<TipoPersona, Integer> {
}
