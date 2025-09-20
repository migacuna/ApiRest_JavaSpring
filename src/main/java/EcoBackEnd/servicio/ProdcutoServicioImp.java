package EcoBackEnd.servicio;

import EcoBackEnd.Exeption.ClientNotFoundExeption;
import EcoBackEnd.dto.ProductoDto;
import EcoBackEnd.modelo.Producto;
import EcoBackEnd.repositorio.ProductoRepositorio;
import EcoBackEnd.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static EcoBackEnd.utils.DtoMapper.*;

@Service
public class ProdcutoServicioImp implements ProductoServicio{

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<ProductoDto> findAll() {
        return productoRepositorio.findAll().stream().map(Producto::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductoDto findById(Long id) {
        return productoRepositorio.findById(id).orElse(new Producto()).toDto();
    }

    @Override
    public Optional<ProductoDto> findByNombre(String nombre) {
        return Optional.ofNullable(productoRepositorio.findByNombre(nombre).orElseThrow(() -> new ClientNotFoundExeption("Prducto no encontrado con ID: " + nombre)).toDto());
    }

    @Override
    public void insert(ProductoDto productoDto) {
        productoRepositorio.save(toEntity(productoDto));
    }

    @Override
    public void update(ProductoDto productoDto) {
        productoRepositorio.save(toEntity(productoDto));
    }

    @Override
    public void delete(ProductoDto productoDto) {

    }
}
