package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    @Builder
    public Sala(Integer numero_sala, String tipo_sala, Teatro teatro, TipoSala tipoSala, DistribucionSillas distribucionSillas) {
        this.numero_sala = numero_sala;
        this.tipo_sala = tipo_sala;
        this.teatro = teatro;
        this.tipoSala = tipoSala;
        this.distribucionSillas = distribucionSillas;
    }
}
