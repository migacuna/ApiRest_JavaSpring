package EcoBackEnd.repositorio;

import EcoBackEnd.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombre(String nombre);
}
