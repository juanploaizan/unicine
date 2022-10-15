package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.dto.HorarioSalaDTO;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    @Autowired
    private PeliculaRepo peliculaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculasPorNombre() {
        List<Pelicula> peliculas = peliculaRepo.buscarPeliculasPorNombre("la");
        Assertions.assertEquals(2, peliculas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculasPorTeatro() {
        List<HorarioSalaDTO> peliculas = peliculaRepo.obtenerPeliculasPorTeatro(5,5);
        Assertions.assertEquals(4, peliculas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculasPorGenero() {
        List<Pelicula> peliculas = peliculaRepo.listarPeliculasPorGenero(Genero.ACCION);
        peliculas.forEach(System.out::println);
        //Assertions.assertEquals(4, peliculas.size());
    }
}
