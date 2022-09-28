package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AdministradorCiudad implements Serializable {

    //Atributos
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(nullable = false, length = 60)
    private String nombre_completo;

    @Column(nullable = false, unique = true, length = 10)
    private String telefono;

    @Email
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    private String imagen_perfil;

    @Column(nullable = false, length = 40)
    private String contrasenia;

    //Relaciones
    @OneToOne
    private Ciudad ciudad;

    @Builder
    public AdministradorCiudad(String cedula, String nombre_completo, String telefono, String email,
                               String imagen_perfil, String contrasenia, Ciudad ciudad) {
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.email = email;
        this.imagen_perfil = imagen_perfil;
        this.contrasenia = contrasenia;
        this.ciudad = ciudad;
    }
}
