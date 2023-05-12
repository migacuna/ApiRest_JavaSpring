package EcoBackEnd.servicio;

import EcoBackEnd.dto.PersonaDto;
import EcoBackEnd.modelo.Persona;
import EcoBackEnd.repositorio.PersonaRepositorio;
import EcoBackEnd.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServicioImp implements PersonaServicio{

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public List<PersonaDto> findAll() {
        return personaRepositorio.findAll().stream().map(Persona::toDto).collect(Collectors.toList());
    }

    @Override
    public PersonaDto findById(Long id) {
        return personaRepositorio.findById(id).orElse(new Persona()).toDto();
    }

    @Override
    public Optional<PersonaDto> findByRut(String rut) {
        return Optional.ofNullable(personaRepositorio.findByRut(rut).orElse(new Persona()).toDto());
    }

    @Override
    public void Insert(PersonaDto personaDto) {
        personaRepositorio.save(DtoMapper.toEntity(personaDto));
        //return null;
    }

    @Override
    public void update(PersonaDto personaDto) {
        System.out.println(personaDto.getDireccion());
        personaRepositorio.save(DtoMapper.toEntity(personaDto));
    }

    @Override
    public void delete(PersonaDto personaDto) {
        personaRepositorio.delete(DtoMapper.toEntity(personaDto));
    }


}
