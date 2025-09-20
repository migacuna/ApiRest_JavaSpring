package EcoBackEnd.modelo;

import EcoBackEnd.dto.VentaDetalleDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name="VentaDetalle")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "SQ-VENTADETALLE",initialValue = 1, allocationSize = 1)
@Builder
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVentaDetalle", unique = true, updatable = false,nullable = false)
    private Long idVentaDetalle;
    //private Producto producto;
    private int cantidad;
    private float subTotal;
    private double iva;
    private double total;
    //private Producto producto;

    public VentaDetalleDto toDto(){
        VentaDetalleDto ventadetalleDto = new VentaDetalleDto();
        //ventadetalleDto.setProducto(this.producto.toDto());
        ventadetalleDto.setCantidad(this.cantidad);
        ventadetalleDto.setSubTotal(this.subTotal);
        ventadetalleDto.setIva(this.iva);
        ventadetalleDto.setTotal(this.total);
        return ventadetalleDto;
    }

    public void sacarSubTotal(){
        Producto prod = new Producto();
        this.subTotal = prod.getPrecio() + this.cantidad;
    }

    public void descontarStock(){
        Producto prod = new Producto();
        int stockTemp = prod.getStock();
        int restaStock = stockTemp - this.cantidad;
        prod.setStock(restaStock);
    }

    public void sacarSubtotal(){
        Producto prod = new Producto();
        this.subTotal = prod.getPrecio() + this.cantidad;
    }

    public void sacarIva(){
        this.iva = this.subTotal * 0.19;
    }

    public void sacarTotal(){
        this.total = this.subTotal + this.iva;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VentaCab_id",referencedColumnName = "idVentaCab")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VentaCab ventaCab;

    @ManyToOne(targetEntity = Producto.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id",referencedColumnName = "idProducto")
    private Producto producto;
}

