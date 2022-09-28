package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
}
