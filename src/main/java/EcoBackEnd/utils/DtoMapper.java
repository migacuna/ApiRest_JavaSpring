package EcoBackEnd.utils;

import EcoBackEnd.dto.PersonaDto;
import EcoBackEnd.dto.TipoPersonaDto;
import EcoBackEnd.modelo.Persona;

public class DtoMapper {

    private DtoMapper(){
    }

    //Recibe DTO y User que viene de la vista y lo transformo en Entity
    private static void toEntity(PersonaDto personaDto, Persona persona){
        persona.setIdPersona(personaDto.getIdPersona());
        persona.setRut(personaDto.getRut());
        persona.setRazonSocial(personaDto.getRazonSocial());
        persona.setGiro(personaDto.getGiro());
        persona.setDireccion(personaDto.getDireccion());
        persona.setTelefono(personaDto.getTelefono());
        persona.setCorreo(personaDto.getCorreo());
        persona.setTipoPersona(personaDto.getTipoPersona());
    }

    //Recibo desde la vista un DTO y retorno un Objeto
    public static Persona toEntity(PersonaDto personaDto){
        Persona persona = new Persona();
        toEntity(personaDto, persona);
        return persona;
    }
}
