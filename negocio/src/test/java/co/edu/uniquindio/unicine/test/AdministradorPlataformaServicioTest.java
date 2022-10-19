package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorPlataformaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorPlataformaServicioTest {

    @Autowired
    private AdministradorPlataformaServicio administradorPlataformaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdministradorTeatroTest() {
        try {
            AdministradorTeatro administradorTeatro = administradorPlataformaServicio.obtenerAdministradorTeatro("1000");
            Assertions.assertNotNull(administradorTeatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarAdministradorTeatroTest() {
        AdministradorTeatro administradorTeatro = AdministradorTeatro.builder().nombre_completo("Sebastian Burgos")
                .telefono("3012392831").email("sebasb@gmail.com").cedula("1005090418").contrasenia("123123").imagen_perfil("urlasd").build();

        try {
            AdministradorTeatro nuevo = administradorPlataformaServicio.registrarAdministradorTeatro(administradorTeatro);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdministradorTeatroTest() {
        AdministradorTeatro administradorTeatro = null;

        try {
            administradorTeatro = administradorPlataformaServicio.obtenerAdministradorTeatro("1000");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            administradorTeatro.setNombre_completo("Martin Tiringuin");
            AdministradorTeatro nuevo = null;
            nuevo = administradorPlataformaServicio.actualizarAdministradorTeatro(administradorTeatro);
            Assertions.assertEquals("Martin Tiringuin", nuevo.getNombre_completo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdministradorTeatroTest() {
        try {
            administradorPlataformaServicio.eliminarAdministradorTeatro("1000");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdministradoresTeatroTest() {
        List<AdministradorTeatro> lista = administradorPlataformaServicio.listarAdministradoresTeatro();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdministradorPorTeatro() {
        try {
            AdministradorTeatro administradorTeatro = administradorPlataformaServicio.obtenerAdministradorPorTeatro(3);
            Assertions.assertNotNull(administradorTeatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPelicula() {
        try {
            Pelicula pelicula = administradorPlataformaServicio.obtenerPelicula(1);
            Assertions.assertNotNull(pelicula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarPelicula() {
        Pelicula pelicula = Pelicula.builder().nombre("Harry Potter y El Prisionero de Askaban")
                .estadoPelicula("EN_CARTELERA").duracion_minutos(180).edad_apropiada(12)
                .nombre_director("Jk Rowling").nombre_estudio("Warner").sinopsis("Un batman pero mago")
                .imagen("urlimagen").trailer("urltrailer").build();
        pelicula.setCodigo(10);

        try {
            Pelicula nueva = administradorPlataformaServicio.registrarPelicula(pelicula);
            Assertions.assertNotNull(nueva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPelicula() {
        Pelicula pelicula = null;

        try {
            pelicula = administradorPlataformaServicio.obtenerPelicula(1);
            pelicula.setNombre("Efecto Mariposa");
            Pelicula nueva = null;
            nueva = administradorPlataformaServicio.actualizarPelicula(pelicula);
            Assertions.assertEquals("Efecto Mariposa", pelicula.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
