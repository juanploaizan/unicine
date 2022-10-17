package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cupon;

import java.util.List;

public interface CuponServicio {

    Cupon obtenerCupon(Integer codigo) throws Exception;

    Cupon registrarCupon(Cupon cupon) throws Exception;

    Cupon actualizarCupon(Cupon cupon) throws Exception;

    void eliminarCupon(Cupon cupon) throws Exception;

    List<Cupon> listarCupones();

    List<Cupon> listarCuponesPorDescuento(Float descuento);
}
