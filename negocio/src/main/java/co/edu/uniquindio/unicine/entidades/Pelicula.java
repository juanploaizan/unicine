package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pelicula implements Serializable {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 65)
    private String nombre;

    @Column(nullable = false)
    private String sinopsis;

    @Column(nullable = false)
    private Integer duracion_minutos;

    @Column(nullable = false)
    private Integer edad_apropiada;

    @Column(nullable = false, length = 65)
    private String nombre_director;

    @Column(nullable = false, length = 65)
    private String nombre_estudio;

    @ElementCollection
    @Column(nullable = false, length = 40)
    private List<String> reparto;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false, unique = true)
    private String trailer;

    @ElementCollection
    @Column(nullable = false, length = 30)
    private List<String> genero;

    @Column(nullable = false, length = 40)
    private String estado_pelicula;

    //Relaciones
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;
}
