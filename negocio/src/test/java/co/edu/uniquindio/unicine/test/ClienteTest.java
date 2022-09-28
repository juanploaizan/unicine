package co.edu.uniquindio.unicine.test;

import ch.qos.logback.core.CoreConstants;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3127588409");

        Cliente cliente = new Cliente("1004916493", "Juan Pablo Loaiza Nieto", 20, "direcccion jajaja", "jloaizanieto@gmail.com", telefonos, "url imagen", "204060120Gato");

        Cliente guardado = clienteRepo.save(cliente);

        //Assertions.assertEquals("Juan Pablo Loaiza Nieto", guardado.getNombre_completo());
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminar() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3127588409");
        Cliente cliente = new Cliente("1004916493", "Juan Pablo Loaiza Nieto", 20, "direcccion jajaja", "jloaizanieto@gmail.com", telefonos, "url imagen", "204060120Gato");

        Cliente guardado = clienteRepo.save(cliente);

        clienteRepo.delete(guardado);

        Optional<Cliente> buscado = clienteRepo.findById("1004916493");

        Assertions.assertNull(buscado.orElse(null));
    }

    @Test
    public void actualizar() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3127588409");
        Cliente cliente = new Cliente("1004916493", "Juan Pablo Loaiza Nieto", 20, "direcccion jajaja", "jloaizanieto@gmail.com", telefonos, "url imagen", "204060120Gato");

        Cliente guardado = clienteRepo.save(cliente);

        guardado.setEmail("juanpepe@gmail.com");

        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertEquals("juanpepe@gmail.com", nuevo.getEmail());

    }

    @Test
    public void obtener() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3127588409");
        Cliente cliente = new Cliente("1004916493", "Juan Pablo Loaiza Nieto", 20, "direcccion jajaja", "jloaizanieto@gmail.com", telefonos, "url imagen", "204060120Gato");

        clienteRepo.save(cliente);

        Optional<Cliente> buscado = clienteRepo.findById("1004916493");

        System.out.println( buscado.orElse(null));
    }

    @Test
    public void listar() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("3127588409");
        Cliente cliente = new Cliente("1004916493", "Juan Pablo Loaiza Nieto", 20, "direcccion jajaja", "jloaizanieto@gmail.com", telefonos, "url imagen", "204060120Gato");
        clienteRepo.save(cliente);

        ArrayList<String> telefonos1 = new ArrayList<>();
        telefonos.add("312752222");
        Cliente cliente1 = new Cliente("1004916494", "Pepe", 20, "direcccion jajaja", "jloaizanxxieto@gmail.com", telefonos1, "url imagen", "204060120Gato");
        clienteRepo.save(cliente1);

        List<Cliente> lista = clienteRepo.findAll();

        System.out.println(lista);
    }
}
