package EcoBackEnd.dto;

import EcoBackEnd.modelo.Producto;
import EcoBackEnd.modelo.TipoProducto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto extends Producto {

    private Long idProducto;
    private String nombre;
    private String descripcion;
    private int stock;
    private int precio;
    private TipoProducto tipoProducto;
}
