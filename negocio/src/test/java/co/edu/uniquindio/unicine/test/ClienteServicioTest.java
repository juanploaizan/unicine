package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest() {
        Cliente cliente = Cliente.builder().nombre_completo("Juanito").contrasenia("1234").email("jloaizanieto@gmail.com")
                .cedula("1004916493").edad(20).direccion("Casa 1").imagen_perfil("url_imagen").build();

        try {
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest() {

        Cliente cliente = null;
        try {
            cliente = clienteServicio.obtenerCliente("1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            cliente.setNombreCompleto("Nombre largo de prueba");
            Cliente nuevo = clienteServicio.actualizarCliente(cliente);
            Assertions.assertEquals("Nombre largo de prueba", nuevo.getNombreCompleto());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest() {
        try {
            clienteServicio.eliminarCliente("1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest() {
        List<Cliente> lista = clienteServicio.listarClientes();
        lista.forEach(System.out::println);
    }

}