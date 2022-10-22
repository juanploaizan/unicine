package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CompraConfiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = true)
    private Float precio;

    @Column(nullable = false)
    private int unidades;

    //Relaciones
    @ToString.Exclude
    @ManyToOne
    private ProductoConfiteria productoConfiteria;

    @ToString.Exclude
    @ManyToOne
    private Compra compra;

    @Builder
    public CompraConfiteria(Float precio, int unidades, ProductoConfiteria productoConfiteria, Compra compra) {
        this.precio = precio;
        this.unidades = unidades;
        this.productoConfiteria = productoConfiteria;
        this.compra = compra;
    }
}
