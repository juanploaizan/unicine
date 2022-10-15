package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ClienteCupon implements Serializable {

    @Id
    @ManyToOne
    private Cliente cliente;

    @Id
    @ManyToOne
    private Cupon cupon;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false, length = 25)
    private String estado;


    @Builder
    public ClienteCupon(Cliente cliente, Cupon cupon, LocalDate fechaVencimiento) {
        this.cliente = cliente;
        this.cupon = cupon;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = "ACTIVO";
    }
}
