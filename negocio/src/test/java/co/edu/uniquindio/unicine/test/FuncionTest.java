package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.repositorios.FuncionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNombrePeliculaPorID() {
        String nombrePelicula = funcionRepo.obtenerNombrePeliculaPorID(2);
        Assertions.assertEquals("Mandingo", nombrePelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void funcionesSinCompras() {
        List<Funcion> funcionesSinCompras = funcionRepo.funcionesSinCompras(5);
        funcionesSinCompras.forEach(System.out::println);
    }

}
