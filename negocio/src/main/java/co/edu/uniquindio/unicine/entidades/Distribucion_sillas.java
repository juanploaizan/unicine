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
public class Distribucion_sillas implements Serializable {

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


}
