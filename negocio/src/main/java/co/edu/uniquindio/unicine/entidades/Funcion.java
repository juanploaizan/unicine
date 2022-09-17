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
    @OneToOne
    private Sala sala;

    @OneToOne
    private Horario horario;

    @OneToMany(mappedBy = "funcion")
    private List<Entrada> entradas;

    @ManyToOne
    private Pelicula pelicula;
}
