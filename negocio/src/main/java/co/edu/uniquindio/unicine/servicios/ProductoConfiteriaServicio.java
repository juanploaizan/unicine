package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.ProductoConfiteria;

import java.util.List;

public interface ProductoConfiteriaServicio {

    ProductoConfiteria obtenerProductoConfiteria(Integer codigo) throws Exception;

    ProductoConfiteria registrarProductoConfiteria(ProductoConfiteria productoConfiteria) throws Exception;

    ProductoConfiteria actualizarProductoConfiteria(ProductoConfiteria productoConfiteria) throws Exception;

    void eliminarProductoConfiteria(Integer codigo) throws Exception;

    List<ProductoConfiteria> listarProductosConfiteria();

    List<ProductoConfiteria> listarProductosConfiteriaPorRangoPrecio(Integer precioMinimo, Integer precioMaximo);

}
