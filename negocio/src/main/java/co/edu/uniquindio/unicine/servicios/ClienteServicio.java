package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;


public interface ClienteServicio {

    Cliente obtenerCliente(String cedula) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente login(String cedula, String contrasenia) throws Exception;

    List<Pelicula> buscarPelicula(String nombrePelicula) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(String cedulaCliente) throws Exception;

    List<Cliente> listarClientes() ;

    List<Compra> listarHistorialCompras(String cedulaCliente) throws Exception;

    Compra iniciarCompra(Cliente cliente, Funcion funcion) throws Exception;

    Compra asignarEntrada(Compra compra, List<Entrada> entradas) throws Exception;

    Compra asignarComprasConfiteria(Compra compra, List<CompraConfiteria> comprasConfiteria) throws Exception;

    Compra asignarPago(Compra compra, MedioPago medioPago, ClienteCupon clienteCupon) throws Exception;

    Compra realizarCompra(Compra compra) throws Exception;

    void cancelarCompra(Integer idCompra) throws Exception;

    void solicitarCambioContrasenia(String email) throws Exception;

    PQRS realizarPqrs(PQRS solicitudPqrs) throws Exception;
}
