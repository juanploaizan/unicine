package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQRSRepo extends JpaRepository<PQRS, Integer> {
}
