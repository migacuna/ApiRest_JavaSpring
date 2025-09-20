package EcoBackEnd.utils;

import EcoBackEnd.dto.PersonaDto;
import EcoBackEnd.dto.ProductoDto;
import EcoBackEnd.modelo.Persona;
import EcoBackEnd.modelo.Producto;

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

    private static void toEntity(ProductoDto productoDto, Producto producto){
        producto.setIdProducto(productoDto.getIdProducto());
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setTipoProducto(productoDto.getTipoProducto());
    }

    public static Producto toEntity(ProductoDto productoDto){
        Producto producto = new Producto();
        toEntity(productoDto, producto);
        return producto;
    }
}
