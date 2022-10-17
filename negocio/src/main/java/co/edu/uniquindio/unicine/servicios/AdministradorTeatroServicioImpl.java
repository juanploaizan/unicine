package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorTeatroServicioImpl implements AdministradorTeatroServicio{

    private AdministradorTeatroRepo administradorTeatroRepo;

    public AdministradorTeatroServicioImpl(AdministradorTeatroRepo administradorTeatroRepo) {
        this.administradorTeatroRepo = administradorTeatroRepo;
    }

    @Override
    public AdministradorTeatro obtenerAdministradorTeatro(String cedulaAdministradorTeatro) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(cedulaAdministradorTeatro);

        if (!guardado.isPresent()) {
            throw new Exception("El administrador de teatro no existe.");
        } else {
            return guardado.get();
        }
    }

    @Override
    public AdministradorTeatro registrarAdministradorTeatro(AdministradorTeatro administradorTeatro) throws Exception {
        boolean correoExiste = verificarExistenciaCorreo(administradorTeatro.getEmail());

        if (correoExiste) {
            throw new Exception("El correo ingresado ya está siendo usado por otro usuario.");
        } else {
            return administradorTeatroRepo.save(administradorTeatro);
        }
    }

    private boolean verificarExistenciaCorreo(String correo) throws Exception{
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.obtenerPorCorreo(correo);
        return !(administradorTeatro == null);
    }

    @Override
    public AdministradorTeatro actualizarAdministradorTeatro(AdministradorTeatro administradorTeatro) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(administradorTeatro.getCedula());

        if (!guardado.isPresent()) {
            throw new Exception("El administrador de teatro no existe.");
        } else {
            return administradorTeatroRepo.save(administradorTeatro);
        }
    }

    @Override
    public void eliminarAdministradorTeatro(String cedulaAdministradorTeatro) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(cedulaAdministradorTeatro);

        if (!guardado.isPresent()) {
            throw new Exception("El administrador de teatro no existe.");
        } else {
            administradorTeatroRepo.delete(guardado.get());
        }
    }

    @Override
    public List<AdministradorTeatro> listarAdministradoresTeatro() {
        return administradorTeatroRepo.findAll();
    }

    @Override
    public AdministradorTeatro obtenerAdministradorPorTeatro(Integer codigoTeatro) {
        return administradorTeatroRepo.obtenerPorTeatro(codigoTeatro);
    }
}
