package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sala implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Integer numero_sala;

    @Column(nullable = false)
    private String tipo_sala;

    //Relaciones
    @ManyToOne
    private Teatro teatro;

    @ManyToOne
    private TipoSala tipoSala;

    @ManyToOne
    private DistribucionSillas distribucionSillas;

    @OneToOne(mappedBy = "sala")
    private Funcion funcion;

}
