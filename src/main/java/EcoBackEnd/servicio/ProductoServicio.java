package EcoBackEnd.servicio;

import EcoBackEnd.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {

    List<ProductoDto> findAll();
    ProductoDto findById(Long id);
    Optional<ProductoDto> findByNombre(String nombre);
    void insert(ProductoDto productoDto);
    void update(ProductoDto productoDto);
    void delete(ProductoDto productoDto);

}


