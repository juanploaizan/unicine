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

    @Column(nullable = true)
    private Float precioTotal;

    @Column(nullable = true)
    private LocalDateTime fechaCompra;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    @NonNull
    private MedioPago medioDePago;

    @Column(nullable = false)
    private Integer estado;

    //Relaciones

    @OneToOne(mappedBy = "compra")
    private ClienteCupon clienteCupon;

    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @NonNull
    @ManyToOne
    private Cliente cliente;

    @NonNull
    @ManyToOne
    private Funcion funcion;

    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> comprasConfiteria;

    @Builder
    public Compra(MedioPago medioDePago, ClienteCupon clienteCupon, List<Entrada> entradas, Cliente cliente,
                  Funcion funcion, List<CompraConfiteria> comprasConfiteria) {
        this.fechaCompra = LocalDateTime.now();
        this.medioDePago = medioDePago;
        this.clienteCupon = clienteCupon;
        this.entradas = entradas;
        this.cliente = cliente;
        this.funcion = funcion;
        this.comprasConfiteria = comprasConfiteria;
        this.estado = 0;
    }

    public void actualizarPrecioTotal() {

        float valorEntradas = 0;
        float valorConfiteria = 0;

        valorEntradas = entradas.size() * funcion.getPrecio();

        for (CompraConfiteria compraConfiteria : comprasConfiteria) {
            valorConfiteria += compraConfiteria.getPrecio();
        }

        if (clienteCupon != null) {
            this.precioTotal = (valorEntradas + valorConfiteria) - (((valorEntradas + valorConfiteria)*clienteCupon.getCupon().getDescuento())/100);
        } else {
            this.precioTotal = valorEntradas + valorConfiteria;
        }


    }
}
