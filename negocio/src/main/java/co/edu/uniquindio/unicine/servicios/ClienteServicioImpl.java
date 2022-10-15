package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente obtenerCliente(String cedula) throws Exception {
        Optional<Cliente> guardado = clienteRepo.findById(cedula);

        if (!guardado.isPresent()) {
            throw new Exception("El cliente no existe.");
        } else {
            return guardado.get();
        }
    }

    @Override
    public Cliente login(String cedula, String contrasenia) throws Exception {
        Cliente cliente = clienteRepo.comprobarAutenticacion(cedula, contrasenia);

        if (cliente == null) {
            throw new Exception("Los datos ingresados no son válidos.");
        } else {
            return cliente;
        }
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        boolean correoExiste = verificarExistenciaCorreo(cliente.getEmail());

        if (correoExiste) {
            throw new Exception("El correo ingresado ya está siendo usado por otro usuario.");
        } else {
            return clienteRepo.save(cliente);
        }
    }

    private boolean verificarExistenciaCorreo(String correo) throws Exception{
        Cliente cliente = clienteRepo.obtenerPorCorreo(correo);
        return !(cliente == null);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{
        Optional<Cliente> guardado = clienteRepo.findById(cliente.getCedula());

        if (!guardado.isPresent()) {
            throw new Exception("El cliente no existe.");
        } else {
            return clienteRepo.save(cliente);
        }
    }

    @Override
    public void eliminarCliente(String cedulaCliente) throws Exception{

        Optional<Cliente> guardado = clienteRepo.findById(cedulaCliente);

        if (!guardado.isPresent()) {
            throw new Exception("El cliente no existe.");
        } else {
            clienteRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    //TODO
    @Override
    public List<Compra> listarHistorialCompras(String cedulaCliente) throws Exception{
        return null;
    }

    //TODO
    @Override
    public Compra realizarCompra(Compra compra) throws Exception{
        return null;
    }

    @Override
    public boolean redimirCupon(Integer codigoCupon) throws Exception{
        return false;
    }
}
