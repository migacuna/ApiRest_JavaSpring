package EcoBackEnd.modelo;

import EcoBackEnd.dto.TipoProductoDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "TIPOPRODUCTO")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "SQ_TIPOPRODUCTO",initialValue = 1, allocationSize = 1)
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoProducto", updatable = false, nullable = false)
    private Long idTipoProducto;
    private String tipo;

    public TipoProductoDto toDTO(){
        TipoProductoDto tipoProductoDto = new TipoProductoDto();
        tipoProductoDto.setIdTipoProducto(this.idTipoProducto);
        tipoProductoDto.setTipo(this.tipo);
        return tipoProductoDto;
    }

    @OneToMany(targetEntity = Producto.class, cascade = CascadeType.MERGE , mappedBy = "tipoProducto",fetch = FetchType.LAZY)
    private List<Producto> productos;

    @Override
    public String toString() { return "TipoProducto{" + "idTipoProducto=" + idTipoProducto + ", tipo='" + tipo + '\'' + '}';
    }
}
