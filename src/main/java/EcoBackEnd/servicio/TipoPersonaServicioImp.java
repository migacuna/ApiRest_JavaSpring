package EcoBackEnd.servicio;

import EcoBackEnd.modelo.TipoPersona;
import EcoBackEnd.repositorio.TipoPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TipoPersonaServicioImp implements TipoPersonaServicio {

    @Autowired
    TipoPersonaRepositorio tipoPersonaRepositorio;


    @Override
    public List<TipoPersona> findAll() {
        return tipoPersonaRepositorio.findAll();
    }

    @Override
    public TipoPersona findById(Long id) {
        return tipoPersonaRepositorio.findById(Math.toIntExact(id)).orElse(new TipoPersona());
    }

    @Override
    public void Insert(TipoPersona tipoPersona) {
        tipoPersonaRepositorio.save(tipoPersona);
    }

    @Override
    public void update(TipoPersona tipoPersona) {
        tipoPersonaRepositorio.save(tipoPersona);
    }

    @Override
    public void delete(TipoPersona tipoPersona) {
        tipoPersonaRepositorio.delete(tipoPersona);
    }
}
