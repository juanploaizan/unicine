package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dto.HorarioSalaDTO;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where p.estadoPelicula = 'EN_CARTELERA' and lower(p.nombre) like concat('%',:nombreABuscar,'%') " +
            "or p.estadoPelicula = 'PROXIMAMENTE' and lower(p.nombre) like concat(concat('%',:nombreABuscar ),'%')")
    List<Pelicula> buscarPeliculasPorNombre(String nombreABuscar);

    @Query("select new co.edu.uniquindio.unicine.dto.HorarioSalaDTO(f.horario, f.sala) from Pelicula p join p.funciones f where p.codigo = :codigoPelicula and f.sala.teatro.codigo = :codigoTeatro")
    List<HorarioSalaDTO> obtenerPeliculasPorTeatro(Integer codigoPelicula, Integer codigoTeatro);

    @Query("select p from Pelicula p join p.generos g where g = :genero order by p.nombre asc")
    List<Pelicula> listarPeliculasPorGenero(Genero genero);

<<<<<<< HEAD
    @Query("select p from Pelicula p where p.edadApropiada = :edadApropiada")
    List<Pelicula> listarPeliculasPorEdadApropiada(Integer edadApropiada);

    @Query("select p from Pelicula p where p.nombreDirector = :nombreDirector")
    List<Pelicula> listarPeliculasPorDirector(String nombreDirector);

    @Query("select p from Pelicula p where p.nombreEstudio = :nombreEstudio")
    List<Pelicula> listarPeliculasPorEstudio(String nombreEstudio);


=======
>>>>>>> origin/main
}
