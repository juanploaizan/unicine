package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.AdministradorPlataformaRepo;
import org.springframework.stereotype.Service;

@Service
public class AdministradorPlataformaServicioImpl implements AdministradorPlataformaServicio{

    private AdministradorPlataformaRepo administradorPlataformaRepo;

    public AdministradorPlataformaServicioImpl(AdministradorPlataformaRepo administradorPlataformaRepo) {
        this.administradorPlataformaRepo = administradorPlataformaRepo;
    }

    public AdministradorPlataforma login(String cedula, String contrasenia) throws Exception {
        AdministradorPlataforma administradorPlataforma = administradorPlataformaRepo.comprobarAutenticacion(cedula, contrasenia);

        if(administradorPlataforma == null){
            throw new Exception("Los datos ingresados no son válidos");
        }else{
            return administradorPlataforma;
        }
    }

}
