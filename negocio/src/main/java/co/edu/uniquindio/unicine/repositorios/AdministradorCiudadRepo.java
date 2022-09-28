package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.AdministradorCiudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorCiudadRepo extends JpaRepository<AdministradorCiudad, String> {
}
