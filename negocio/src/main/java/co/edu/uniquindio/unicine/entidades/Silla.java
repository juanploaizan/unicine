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
public class Silla implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 2)
    private String fila;

    @Column(nullable = false, length = 2)
    private String columna;

    @Column(nullable = false)
    private String estado;

    //Relaciones
    @ManyToOne
    private DistribucionSillas distribucionSillas;

    @ManyToMany(mappedBy = "sillas")
    private List<Compra> compras;

    @Builder

    public Silla(String fila, String columna, String estado, DistribucionSillas distribucionSillas) {
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.distribucionSillas = distribucionSillas;
    }
}
