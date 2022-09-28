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
public class DistribucionSillas implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Integer cantidad_filas;

    @Column(nullable = false)
    private Integer cantidad_columnas;

    @Column(nullable = false)
    private String numeracion_filas;

    @Column(nullable = false)
    private String numeracion_columnas;

    //Relaciones
    @OneToMany(mappedBy = "distribucionSillas")
    private List<Sala> salas;

    @OneToMany(mappedBy = "distribucionSillas")
    private List<Silla> sillas;

    @Builder
    public DistribucionSillas(Integer cantidad_filas, Integer cantidad_columnas, String numeracion_filas, String numeracion_columnas) {
        this.cantidad_filas = cantidad_filas;
        this.cantidad_columnas = cantidad_columnas;
        this.numeracion_filas = numeracion_filas;
        this.numeracion_columnas = numeracion_columnas;
    }
}
