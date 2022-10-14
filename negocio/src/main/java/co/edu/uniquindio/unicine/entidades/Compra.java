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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Float precio_total;

    @Column(nullable = false)
    private LocalDateTime fecha_compra;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private MedioPago medioDePago;

    //Relaciones

    @ToString.Exclude
    @OneToOne
    private Cupon cupon;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @ToString.Exclude
    @ManyToMany
    private List<ProductoConfiteria> productosConfiteria;

    @ToString.Exclude
    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @ManyToOne
    private Funcion funcion;

    @Builder
    public Compra(MedioPago medioDePago, Cupon cupon, List<ProductoConfiteria> productosConfiteria, Cliente cliente, Funcion funcion) {
        this.fecha_compra = LocalDateTime.now();
        this.medioDePago = medioDePago;
        this.cupon = cupon;
        this.productosConfiteria = productosConfiteria;
        this.cliente = cliente;
        this.funcion = funcion;
    }
}
