package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import java.util.List;


public interface ClienteServicio {

    Cliente obtenerCliente(String cedula) throws Exception;

    Cliente login(String cedula, String contrasenia) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(String cedulaCliente) throws Exception;

    List<Cliente> listarClientes() ;

    List<Compra> listarHistorialCompras(String cedulaCliente) throws Exception;

    Compra realizarCompra(Compra compra) throws Exception;

    boolean redimirCupon(Integer codigoCupon) throws Exception;

}
