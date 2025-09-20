package EcoBackEnd.modelo;

import EcoBackEnd.dto.PersonaDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*@Entity
@Table(name="PERSONA", indexes = {
        @Index(name="idPersona_idx", columnList="IDPERSONA"),
        @Index(name="rut_idx", columnList="RUT"),
        @Index(name="razonSocial_idx", columnList="RAZONSOCIAL"),
        @Index(name="giro_idx", columnList="GIRO"),
        @Index(name="direccion_idx", columnList="DIRECCION"),
        @Index(name="telefono_idx", columnList="TELEFONO"),
        @Index(name="correo_idx", columnList="CORREO"),
        })*/

@Table(name="persona")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name="SQ_PERSONA", initialValue=1, allocationSize=1)
@Builder
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona", updatable = false, nullable = false, unique = true)
    private Long idPersona;
    private String rut;
    private String razonSocial;
    private String giro;
    private String direccion;
    private Integer telefono;
    private String correo;
    //private TipoPersona tipoPersona;

    public PersonaDto toDto(){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setIdPersona(this.idPersona);
        personaDto.setRut(this.rut);
        personaDto.setRazonSocial(this.razonSocial);
        personaDto.setGiro(this.giro);
        personaDto.setDireccion(this.direccion);
        personaDto.setTelefono(this.telefono);
        personaDto.setCorreo(this.correo);
        personaDto.setTipoPersona(this.tipoPersona);
        return personaDto;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTipoPersona", referencedColumnName = "idTipoPersona")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoPersona tipoPersona;

    @OneToOne
    private VentaCab ventaCabs;

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", rut =" + rut + ", razonSocial=" + razonSocial + ", giro=" + giro + ", correo=" + correo + ", telefono=" + telefono + ",direccion=" + direccion + "]";
    }

}

