package EcoBackEnd.dto;

import EcoBackEnd.modelo.Producto;
import EcoBackEnd.modelo.VentaDetalle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDetalleDto extends VentaDetalle {

    private Long idVentaDetalle;
    //private Producto producto;
    private int cantidad;
    private float subTotal;
    private double iva;
    private double total;
}
