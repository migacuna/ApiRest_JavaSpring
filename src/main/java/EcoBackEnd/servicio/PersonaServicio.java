package EcoBackEnd.servicio;

import EcoBackEnd.dto.PersonaDto;

import java.util.List;
import java.util.Optional;


public interface PersonaServicio {

    List<PersonaDto> findAll();

    PersonaDto findById(Long id);

    Optional <PersonaDto> findByRut(String rut);

    void Insert(PersonaDto personaDto);

    void update(PersonaDto personaDto);

    void delete(PersonaDto personaDto);


}
