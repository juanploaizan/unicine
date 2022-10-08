package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    @Query("select c from Cliente c where c.email = :email")
    Cliente obtenerPorCorreo(String email);

    @Query("select c from Cliente c where c.cedula = :cedula and c.contrasenia = :contrasenia")
    Cliente comprobarAutenticacion(String cedula, String contrasenia);

    @Query("select c from Cliente c where c.estado = :estado")
    List<Cliente> obtenerClientesPorEstado (String estado, Pageable paginador);

}
