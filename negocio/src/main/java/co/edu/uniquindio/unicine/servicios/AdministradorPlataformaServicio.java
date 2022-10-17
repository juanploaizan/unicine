package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorPlataformaServicio {

    AdministradorPlataforma login(String cedula, String contrasenia) throws Exception;

}
