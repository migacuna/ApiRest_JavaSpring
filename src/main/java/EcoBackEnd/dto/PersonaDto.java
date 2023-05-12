package EcoBackEnd.dto;

import EcoBackEnd.modelo.Persona;
import EcoBackEnd.modelo.TipoPersona;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {

    private Long idPersona;
    private String rut;
    private String razonSocial;
    private String giro;
    private String direccion;
    private Integer telefono;
    private String correo;
    private TipoPersona tipoPersona;
    //private TipoPersonaDto tipoPersonaDto;

}
