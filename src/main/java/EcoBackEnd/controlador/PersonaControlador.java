package EcoBackEnd.controlador;

import EcoBackEnd.dto.PersonaDto;
import EcoBackEnd.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/personas")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaControlador {

    @Autowired
    PersonaServicio  personaServicio;
    //PersonaRepositorio personaRepositorio;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PersonaDto>> getAllUsers(){
        return ResponseEntity.ok(personaServicio.findAll());
    }

    @PostMapping("/registrar-personas")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarPersona(@RequestBody PersonaDto personaDto){
        personaServicio.Insert(personaDto);
    }

    @GetMapping("/busca/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonaDto obtnerPersonaXId(@PathVariable Long id){

        return personaServicio.findById(id);
    }

    @GetMapping("/busca-rut-personas/{rut}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PersonaDto> obtenerPersonaXRut(@PathVariable String rut){
        return personaServicio.findByRut(rut);
    }

    @PutMapping("/actualiza-personas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void actualizaPersona(@PathVariable Long id, @RequestBody PersonaDto personaDto){
        //System.out.println(personaDto.getDireccion());
        PersonaDto personaDto1 = personaServicio.findById(id);
        personaDto1.setRazonSocial(personaDto.getRazonSocial());
        personaDto1.setGiro(personaDto.getGiro());
        personaDto1.setDireccion(personaDto.getDireccion());
        personaDto1.setTelefono(personaDto.getTelefono());
        personaDto1.setCorreo(personaDto.getCorreo());
        personaDto1.setTipoPersona(personaDto.getTipoPersona());
        //System.out.println(personaDto1.toString());
        personaServicio.update(personaDto1);
    }

    @DeleteMapping("/elimina-personas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminaPersona(@PathVariable Long id){
        PersonaDto personaDto1 = personaServicio.findById(id);
        personaServicio.delete(personaDto1);
    }

    /*@ResponseStatus(value = HttpStatus.OK)

    public List<Persona> findAll(){
         return personaServicio.findAll().stream().map(persona -> {
             return Persona.builder()
                    .rut(persona.getRut())
                    .razonSocial(persona.getRazonSocial())
                    .giro(persona.getGiro())
                    .direccion(persona.getDireccion())
                    .telefono(persona.getTelefono())
                    .correo(persona.getCorreo())
                    .tipoPersona(persona.getTipoPersona())
                    .build();
         }).collect(Collectors.toList());
    }*/
    /*public ModelAndView personas(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("persona", personaServicio.findAll());
        return modelAndView;
        }*/

}
