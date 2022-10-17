package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Teatro;

import java.util.List;

public interface AdministradorTeatroServicio {

    AdministradorTeatro obtenerAdministradorTeatro(String cedulaAdministradorTeatro) throws Exception;

    AdministradorTeatro registrarAdministradorTeatro(AdministradorTeatro administradorTeatro) throws Exception;

    AdministradorTeatro actualizarAdministradorTeatro(AdministradorTeatro administradorTeatro) throws Exception;

    void eliminarAdministradorTeatro(String cedulaAdministradorTeatro) throws Exception;

    List<AdministradorTeatro> listarAdministradoresTeatro();

    AdministradorTeatro obtenerAdministradorPorTeatro(Integer codigoTeatro) throws Exception;
}
