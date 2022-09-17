package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {

    //Atributos

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(nullable = false, length = 60)
    private String nombre_completo;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false, length = 55)
    private String direccion;

    @Email
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 10, nullable = false, unique = true)
    private String telefono;

    private String imagen_perfil;

    @Column(nullable = false, length = 40)
    private String contrasenia;

    //Relaciones
    @OneToMany(mappedBy = "cliente")
    private List<Cupon> cupones;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @OneToMany(mappedBy = "cliente")
    private List<PQRS> pqrs;
}
