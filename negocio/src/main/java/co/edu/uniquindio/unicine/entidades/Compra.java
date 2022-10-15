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
    private Float precioTotal;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

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
    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @ManyToOne
    private Funcion funcion;

    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> comprasConfiteria;

    @Builder

    public Compra(LocalDateTime fechaCompra, MedioPago medioDePago, Cupon cupon, List<Entrada> entradas, Cliente cliente, Funcion funcion, List<CompraConfiteria> comprasConfiteria) {
        this.fechaCompra = fechaCompra;
        this.medioDePago = medioDePago;
        this.cupon = cupon;
        this.entradas = entradas;
        this.cliente = cliente;
        this.funcion = funcion;
        this.comprasConfiteria = comprasConfiteria;
    }
}
