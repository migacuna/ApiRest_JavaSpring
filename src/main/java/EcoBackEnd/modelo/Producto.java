package EcoBackEnd.modelo;

import EcoBackEnd.dto.ProductoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "Producto")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "SQ_PRODUCTO", initialValue = 1, allocationSize = 1)
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto", updatable = false, nullable = false, unique = true)
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private int stock;
    private int precio;

    public void aumentarStock()
    {
        VentaDetalle ventaDetalle1 = new VentaDetalle();
        this.stock = this.stock + ventaDetalle1.getCantidad();
    }

    public ProductoDto toDto(){
        ProductoDto productoDto = new ProductoDto();
        productoDto.setIdProducto(this.idProducto);
        productoDto.setNombre(this.nombre);
        productoDto.setDescripcion(this.descripcion);
        productoDto.setStock(this.stock);
        productoDto.setPrecio(this.precio);
        productoDto.setTipoProducto(this.tipoProducto.toDTO());
        return productoDto;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTipoProducto",referencedColumnName = "idTipoProducto")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoProducto tipoProducto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<VentaDetalle> ventaDetalle;
}




