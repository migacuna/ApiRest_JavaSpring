package EcoBackEnd.modelo;

import EcoBackEnd.dto.TipoPersonaDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/*@Entity
@Table(name="TIPOPERSONA", indexes = {
        @Index(name="idTipoPersona_idx", columnList="IDTIPOPERSONA"),
        @Index(name="tipo_idx", columnList="TIPO"),
        @Index(name="idPersona_idx", columnList = "IDPERSONA"),

})*/

@Table(name="TIPOPERSONA")
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SQ_TIPOPERSONA", initialValue=1, allocationSize=1)
public class TipoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTipoPersona", updatable = false, nullable = false)
    private Long idTipoPersona;
    private String tipo;

    public TipoPersonaDto toDTO(){
        TipoPersonaDto tipoPersonaDto = new TipoPersonaDto();
        tipoPersonaDto.setIdTipoPersona(this.idTipoPersona);
        tipoPersonaDto.setTipo(this.tipo);
        return tipoPersonaDto;
    }

    @OneToMany(targetEntity = Persona.class, cascade = CascadeType.MERGE, mappedBy = "tipoPersona", fetch = FetchType.LAZY)
    private List<Persona> persona;

    @Override
    public String toString() {
        return "TipoPersona [idTipoPersona=" + idTipoPersona + ", tipo=" + tipo + "]";
    }
}


