package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Administrador_plataforma implements Serializable {

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

}
