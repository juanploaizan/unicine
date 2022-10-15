package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    @Query("select f.pelicula.nombre from Funcion f where f.codigo = :codigoFuncion")
    String obtenerNombrePeliculaPorID(Integer codigoFuncion);

    @Query("select f from Funcion f join f.sala.teatro t where t.codigo = :codigoTeatro and f.compras is empty")
    List<Funcion> funcionesSinCompras(Integer codigoTeatro);
}
