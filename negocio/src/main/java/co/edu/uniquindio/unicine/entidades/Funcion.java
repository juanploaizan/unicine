package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Funcion implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fecha_completa;

    //Relaciones
    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Pelicula pelicula;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion")
    private List<Compra> compras;

    @Builder
    public Funcion(LocalDateTime fecha_completa, Sala sala, Horario horario, Pelicula pelicula) {
        this.fecha_completa = fecha_completa;
        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
}
