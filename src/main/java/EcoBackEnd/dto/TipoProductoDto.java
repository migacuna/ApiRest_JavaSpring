package EcoBackEnd.dto;

import EcoBackEnd.modelo.TipoProducto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoProductoDto extends TipoProducto {

    private Long idTipoProducto;
    private String tipo;
}
