package EcoBackEnd;

import EcoBackEnd.modelo.Persona;
import EcoBackEnd.modelo.TipoPersona;
import EcoBackEnd.repositorio.PersonaRepositorio;
import EcoBackEnd.repositorio.TipoPersonaRepositorio;
import EcoBackEnd.servicio.PersonaServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcoBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoBackEndApplication.class, args);

		/*AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonaRepositorio personaDao = acac.getBean(PersonaRepositorio.class);
		TipoPersonaRepositorio tipoPersonaDao = acac.getBean(TipoPersonaRepositorio.class);

		Persona persona = new Persona();
		persona.setId(0L);
		persona.setRut("5555");
		persona.setRazonSocial("manuel salas");
		persona.setGiro("Director");
		persona.setDireccion("dire");
		persona.setTelefono(2222);
		persona.setCorreo("correo");

			TipoPersona tipoPersona = new TipoPersona();
			tipoPersona.setIdTipoPersona(1L);
			tipoPersona.setTipo("Empleado");
			tipoPersonaDao.save(tipoPersona);

		persona.setTipoPersona((TipoPersona) tipoPersonaDao);

		personaDao.save(persona);

		System.out.println("Lista de PERSONAS " + personaDao.findAll());*/

		/*AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonaServicio personaServicio = acac.getBean(PersonaServicio.class);
		System.out.println("Lista Cliente" + personaServicio.findAll());*/

	}

}
