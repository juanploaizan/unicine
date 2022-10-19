package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorPlataformaServicioImpl implements AdministradorPlataformaServicio{

    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final PeliculaRepo peliculaRepo;
    private final CuponRepo cuponRepo;
    private final ProductoConfiteriaRepo productoConfiteriaRepo;
    private final CiudadRepo ciudadRepo;
    private AdministradorPlataformaRepo administradorPlataformaRepo;

    public AdministradorPlataformaServicioImpl(AdministradorTeatroRepo administradorTeatroRepo, PeliculaRepo peliculaRepo, CuponRepo cuponRepo, ProductoConfiteriaRepo productoConfiteriaRepo, CiudadRepo ciudadRepo) {
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.peliculaRepo = peliculaRepo;
        this.cuponRepo = cuponRepo;
        this.productoConfiteriaRepo = productoConfiteriaRepo;
        this.ciudadRepo = ciudadRepo;
    }

    public AdministradorPlataforma login(String cedula, String contrasenia) throws Exception {
        AdministradorPlataforma administradorPlataforma = administradorPlataformaRepo.comprobarAutenticacion(cedula, contrasenia);

        if(administradorPlataforma == null){
            throw new Exception("Los datos ingresados no son válidos");
        }else{
            return administradorPlataforma;
        }
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
        boolean correoExiste = verificarExistenciaAdministradorTeatroCorreo(administradorTeatro.getEmail());
        Optional<AdministradorTeatro> administradorTeatroVerificadoCedula = administradorTeatroRepo.findById(administradorTeatro.getCedula());

        if (correoExiste) {
            throw new Exception("El correo ingresado ya está siendo usado por otro usuario.");
        }
        if (administradorTeatroVerificadoCedula.isPresent()) {
            throw new Exception("Ya hay un administrador de teatro registrado con la cedula ingresada.");
        }

        return administradorTeatroRepo.save(administradorTeatro);
    }

    private boolean verificarExistenciaAdministradorTeatroCorreo(String correo) throws Exception{
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
    public AdministradorTeatro obtenerAdministradorPorTeatro(Integer codigoTeatro) throws Exception {
        return administradorTeatroRepo.obtenerPorTeatro(codigoTeatro);
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws Exception {
        Optional<Pelicula> guardada = peliculaRepo.findById(codigo);

        if (!guardada.isPresent()) {
            throw new Exception("La pelicula no existe.");
        } else {
            return guardada.get();
        }
    }

    @Override
    public Pelicula registrarPelicula(Pelicula pelicula) throws Exception {
        Optional<Pelicula> peliculaExiste = peliculaRepo.findById(pelicula.getCodigo());

        if (peliculaExiste.isPresent()) {
            throw new Exception("El codigo ingresado ya está siendo usado para otra pelicula.");
        } else {
            return peliculaRepo.save(pelicula);
        }
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        Optional<Pelicula> guardada = peliculaRepo.findById(pelicula.getCodigo());

        if (!guardada.isPresent()) {
            throw new Exception("La pelicula no existe.");
        } else {
            return peliculaRepo.save(pelicula);
        }
    }

    @Override
    public void eliminarPelicula(Integer codigo) throws Exception {

    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculasPorGenero(Genero genero) {
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculasPorEdadApropiada(Integer edadApropiada) {
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculasPorDirector(String nombreDirector) {
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculasPorEstudio(String nombreEstudio) {
        return null;
    }

    @Override
    public Cupon obtenerCupon(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Cupon registrarCupon(Cupon cupon) throws Exception {
        return null;
    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {
        return null;
    }

    @Override
    public void eliminarCupon(Cupon cupon) throws Exception {

    }

    @Override
    public List<Cupon> listarCupones() {
        return null;
    }

    @Override
    public List<Cupon> listarCuponesPorDescuento(Float descuento) {
        return null;
    }

    @Override
    public ProductoConfiteria obtenerProductoConfiteria(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public ProductoConfiteria registrarProductoConfiteria(ProductoConfiteria productoConfiteria) throws Exception {
        return null;
    }

    @Override
    public ProductoConfiteria actualizarProductoConfiteria(ProductoConfiteria productoConfiteria) throws Exception {
        return null;
    }

    @Override
    public void eliminarProductoConfiteria(Integer codigo) throws Exception {

    }

    @Override
    public List<ProductoConfiteria> listarProductosConfiteria() {
        return null;
    }

    @Override
    public List<ProductoConfiteria> listarProductosConfiteriaPorRangoPrecio(Integer precioMinimo, Integer precioMaximo) {
        return null;
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Ciudad registrarCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public void eliminarCiudad(Integer codigo) throws Exception {

    }

    @Override
    public List<Ciudad> listarCiudades() {
        return null;
    }

}
