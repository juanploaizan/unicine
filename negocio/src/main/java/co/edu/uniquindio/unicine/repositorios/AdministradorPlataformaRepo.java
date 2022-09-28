package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.AdministradorPlataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorPlataformaRepo extends JpaRepository<AdministradorPlataforma, String> {
}
