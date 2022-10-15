package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Integer criterio;

    @Column(nullable = false)
    private Float descuento;

    @Column(nullable = false)
    private String concepto;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    //Relaciones
    @ToString.Exclude
    @OneToOne(mappedBy = "cupon")
    private Compra compra;

    @ToString.Exclude
    @OneToMany(mappedBy = "cupon")
    private List<ClienteCupon> clienteCupones;

    @Builder
    public Cupon(Integer criterio, Float descuento, String concepto, LocalDate fecha_vencimiento) {
        this.criterio = criterio;
        this.descuento = descuento;
        this.concepto = concepto;
        this.estado = "CREADO";
        this.fechaVencimiento = fecha_vencimiento;
    }
}
