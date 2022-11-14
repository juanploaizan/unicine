package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorPlataformaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetallePeliculaBean implements Serializable {

    @Getter @Setter
    @Value("#{param['pelicula_id']}")
    private String peliculaCodigo;

    @Getter @Setter
    private Pelicula pelicula;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Funcion> funciones;

    @Getter @Setter
    private Ciudad ciudad;
    @Autowired
    private AdministradorPlataformaServicio adminServicio;

    @Getter @Setter
    private List<LocalDate> fechas;

    @PostConstruct
    public void init() {

        ciudades = adminServicio.listarCiudades();
        funciones = new ArrayList<>();

        try {
            if (peliculaCodigo != null && !peliculaCodigo.isEmpty()) {
                pelicula = adminServicio.obtenerPelicula(Integer.parseInt(peliculaCodigo));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getGenerosPelicula() {
        if (pelicula != null) {
            String generos = pelicula.getGeneros().toString();
            generos = generos.replace('[', ' ');
            generos = generos.replace(']', ' ');
            generos = generos.replace('_', ' ');
            return generos;
        }
        return "";
    }

    public void actualizarFunciones() {
        try {
            funciones = adminServicio.obtenerFuncionesPorCiudadPelicula(pelicula.getCodigo(), ciudad.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
