package EcoBackEnd.dto;

import EcoBackEnd.modelo.Persona;
import EcoBackEnd.modelo.Producto;
import EcoBackEnd.modelo.VentaCab;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VentaCabDto extends VentaCab {

    private Long idVentaCab;
    private int numeroVenta;
    //private Long idVPersona;
    //private Persona persona;
    private Date fecha;

}
