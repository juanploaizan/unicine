package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorTeatroRepo extends JpaRepository<AdministradorTeatro, String> {

    @Query("select at from AdministradorTeatro at where at.email = :correo")
    AdministradorTeatro obtenerPorCorreo(String correo);

    @Query("select AdministradorTeatro from Teatro t where t.codigo = :codigo")
    AdministradorTeatro obtenerPorTeatro(Integer codigo);
}
