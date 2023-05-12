package EcoBackEnd.servicio;

import EcoBackEnd.modelo.TipoPersona;

import java.util.List;

public interface TipoPersonaServicio {

    List<TipoPersona> findAll();

    TipoPersona findById(Long id);

    void Insert(TipoPersona tipoPersona);

    void update(TipoPersona tipoPersona);

    void delete(TipoPersona tipoPersona);
}
