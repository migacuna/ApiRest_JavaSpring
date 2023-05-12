package EcoBackEnd.dto;

import EcoBackEnd.modelo.TipoPersona;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPersonaDto extends TipoPersona {

    private Long idTipoPersona;
    private String tipo;
}
