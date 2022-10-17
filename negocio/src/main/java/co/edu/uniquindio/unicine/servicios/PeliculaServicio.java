package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;

import java.util.List;

public interface PeliculaServicio {

    Pelicula obtenerPelicula(Integer codigo) throws Exception;

    Pelicula registrarPelicula(Pelicula pelicula) throws Exception;

    Pelicula actualizarPelicula(Pelicula pelicula) throws Exception;

    void eliminarPelicula(Integer codigo) throws Exception;

    List<Pelicula> listarPeliculas();

    List<Pelicula> listarPeliculasPorGenero(Genero genero);

    List<Pelicula> listarPeliculasPorEdadApropiada(Integer edadApropiada);

    List<Pelicula> listarPeliculasPorDirector(String nombreDirector);

    List<Pelicula> listarPeliculasPorEstudio(String nombreEstudio);
}
