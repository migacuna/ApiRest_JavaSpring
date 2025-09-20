package EcoBackEnd.modelo;

import EcoBackEnd.dto.VentaCabDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name="VentaCab")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name="SQ-VENTA",initialValue = 1,allocationSize = 1)
@Builder
public class VentaCab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVentaCab",unique = true, updatable = false,nullable = false)
    private Long idVentaCab;
    private int numeroVenta;
    //private Long idVPersona;
    //private Persona persona;
    private Date fecha;

    public VentaCabDto todto(){
        VentaCabDto ventaCabDtoDto = new VentaCabDto();
        ventaCabDtoDto.setIdVentaCab(this.idVentaCab);
        ventaCabDtoDto.setNumeroVenta(this.numeroVenta);
        //ventaCabDtoDto.setIdVPersona(this.idVPersona);
        //ventaCabDtoDto.setPersona(this.persona.toDto());
        ventaCabDtoDto.setFecha(this.fecha);
        return ventaCabDtoDto;
    }

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_id", referencedColumnName = "idPersona")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Persona personas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaCab")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<VentaDetalle> ventaDetalle;

}



