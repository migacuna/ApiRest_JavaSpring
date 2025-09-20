package EcoBackEnd.servicio;

import EcoBackEnd.Exeption.ClientNotFoundExeption;
import EcoBackEnd.dto.PersonaDto;
import EcoBackEnd.dto.TipoPersonaDto;
import EcoBackEnd.modelo.Persona;
import EcoBackEnd.modelo.TipoPersona;
import EcoBackEnd.repositorio.PersonaRepositorio;
import EcoBackEnd.repositorio.TipoPersonaRepositorio;
import EcoBackEnd.utils.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaServicioImp implements PersonaServicio{

    //private static final Logger log = (Logger) LoggerFactory.getLogger(PersonaServicioImp.class);
    private static final Logger log = LoggerFactory.getLogger(PersonaServicioImp.class);
    @Autowired
    PersonaRepositorio personaRepositorio;
    TipoPersonaRepositorio tipoPersonaRepositorio;

    @Override
    public List<PersonaDto> findAll() {
        List<PersonaDto> personaDto1 = new ArrayList<>();
        List<TipoPersonaDto> tipoPersonaDtoList = new ArrayList<>();
        try{
            personaDto1 = personaRepositorio.findAll().stream().map(Persona::toDto).collect(Collectors.toList());
            Long id = personaDto1.get(0).getTipoPersona().getIdTipoPersona();
            tipoPersonaDtoList = (List<TipoPersonaDto>) tipoPersonaRepositorio.findById(Math.toIntExact(id)).orElse(new TipoPersona());
        }
        catch (Exception e){
            log.info("No se encontraron registros",findAll(),e);
        }
        return personaDto1;
    }

    @Override
    public PersonaDto findById(Long id) {
        PersonaDto personaDto1 = new PersonaDto();
        try{
            personaDto1 =personaRepositorio.findById(id).orElseThrow(() -> new ClientNotFoundExeption("Cliente no encontrado con ID: " + id)).toDto();

            //return clienteRepository.findById(id)
            //                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con ID: " + id));
        }
        catch (Exception e){
            log.info("Registro no econtrado", e);
        }
        return personaDto1;
    }

    @Override
    public Optional<PersonaDto> findByRut(String rut) {
        return Optional.ofNullable(personaRepositorio.findByRut(rut).orElse(new Persona()).toDto());
    }

    @Override
    public void Insert(PersonaDto personaDto) {
        try{
            personaRepositorio.save(DtoMapper.toEntity(personaDto));
            log.info("Registro guardado");
        }
        catch (Exception e){
            log.info("problemas al ingrear el registro",String.valueOf(personaRepositorio) , e);
        }

        //return null;
    }

    @Override
    public void update(PersonaDto personaDto) {
        //System.out.println(personaDto.getDireccion());
        personaRepositorio.save(DtoMapper.toEntity(personaDto));
    }

    @Override
    public void delete(PersonaDto personaDto) {
        personaRepositorio.delete(DtoMapper.toEntity(personaDto));
    }


}
