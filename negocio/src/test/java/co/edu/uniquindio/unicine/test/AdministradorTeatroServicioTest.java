package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.servicios.AdministradorTeatroServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorTeatroServicioTest {

    @Autowired
    private AdministradorTeatroServicio administradorTeatroServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdministradorTeatroTest() {
        try {
            AdministradorTeatro administradorTeatro = administradorTeatroServicio.obtenerAdministradorTeatro("1000");
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
            AdministradorTeatro nuevo = administradorTeatroServicio.registrarAdministradorTeatro(administradorTeatro);
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
            administradorTeatro = administradorTeatroServicio.obtenerAdministradorTeatro("1000");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            administradorTeatro.setNombre_completo("Martin Tiringuin");
            AdministradorTeatro nuevo = null;
            nuevo = administradorTeatroServicio.actualizarAdministradorTeatro(administradorTeatro);
            Assertions.assertEquals("Martin Tiringuin", nuevo.getNombre_completo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdministradorTeatroTest() {
        try {
            administradorTeatroServicio.eliminarAdministradorTeatro("1000");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdministradoresTeatroTest() {
        List<AdministradorTeatro> lista = administradorTeatroServicio.listarAdministradoresTeatro();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdministradorPorTeatro() {
        try {
            AdministradorTeatro administradorTeatro = administradorTeatroServicio.obtenerAdministradorPorTeatro(3);
            Assertions.assertNotNull(administradorTeatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
