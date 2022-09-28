package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
    private String concepto;

    @Column(length = 50)
    private String estado;

    @Column(nullable = false)
    private LocalDate fecha_vencimiento;

    //Relaciones
    @OneToOne
    private Compra compra;

    @ManyToOne
    private Cliente cliente;

    @Builder
    public Cupon(Integer criterio, String concepto, String estado, LocalDate fecha_vencimiento, Cliente cliente) {
        this.criterio = criterio;
        this.concepto = concepto;
        this.estado = estado;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cliente = cliente;
    }
}
