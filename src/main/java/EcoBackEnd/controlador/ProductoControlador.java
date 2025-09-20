package EcoBackEnd.controlador;

import EcoBackEnd.dto.ProductoDto;
import EcoBackEnd.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/productos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoControlador {

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductoDto>> getAllProducts(){
        return ResponseEntity.ok(productoServicio.findAll());
    }

    @GetMapping("/busca/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductoDto> buscaNombre(@PathVariable String nombre){
        return productoServicio.findByNombre(nombre);
    }

    @PostMapping("/registra-productos")
    @ResponseStatus(HttpStatus.CREATED)
    public void creaProducto(@RequestBody ProductoDto productoDto){
        productoServicio.insert(productoDto);
    }

    @PutMapping("/modifica-productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void modificaProducto(@PathVariable Long id,@RequestBody ProductoDto productoDto){
        ProductoDto productoDto1 = productoServicio.findById(id);
        productoDto1.setNombre(productoDto.getNombre());
        productoDto1.setDescripcion(productoDto.getDescripcion());
        productoDto1.setPrecio(productoDto.getPrecio());
        productoDto1.setTipoProducto(productoDto.getTipoProducto());
        productoServicio.update(productoDto1);
    }

    @DeleteMapping("/elimina-productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminaProducto(@PathVariable Long id){
        ProductoDto productoDto1 = productoServicio.findById(id);
        productoServicio.delete(productoDto1);
    }

}
