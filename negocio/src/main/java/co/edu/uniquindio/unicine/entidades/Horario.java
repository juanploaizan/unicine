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
public class Horario implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 9)
    private String dia;

    @Column(nullable = false, length = 8)
    private String hora;

    //Relaciones
    @OneToMany(mappedBy = "horario")
    private List<Funcion> funciones;

    @Builder

    public Horario(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }
}
