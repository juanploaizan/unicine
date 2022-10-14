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
    private Integer duracionMinutos;

    @Column(nullable = false)
    private Integer edadApropiada;

    @Column(nullable = false, length = 65)
    private String nombreDirector;

    @Column(nullable = false, length = 65)
    private String nombreEstudio;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private List<Reparto> reparto;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false, unique = true)
    private String trailer;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private List<Genero> genero;

    @Column(nullable = false, length = 40)
    private String estadoPelicula;

    //Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    @Builder
    public Pelicula(String nombre, String sinopsis, Integer duracion_minutos, Integer edad_apropiada,
                    String nombre_director, String nombre_estudio, List<Reparto> reparto,
                    String imagen, String trailer, List<Genero> genero, String estadoPelicula) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.duracionMinutos = duracion_minutos;
        this.edadApropiada = edad_apropiada;
        this.nombreDirector = nombre_director;
        this.nombreEstudio = nombre_estudio;
        this.reparto = reparto;
        this.imagen = imagen;
        this.trailer = trailer;
        this.genero = genero;
        this.estadoPelicula = estadoPelicula;
    }
}
