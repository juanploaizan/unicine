package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.servicios.AdministradorPlataformaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AdministradorPlataformaServicioTest {

    @Autowired
    private AdministradorPlataformaServicio administradorPlataformaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion(){

    }
}
