package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdministradorPlataformaServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private List<Pelicula> peliculasCartelera;

    @Getter @Setter
    private List<Pelicula> peliculasProximamente;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Autowired
    private AdministradorPlataformaServicio adminServicio;

    @Getter @Setter
    private Ciudad ciudad;

    @Getter @Setter
    private List<String> imagenes;

    @PostConstruct
    public void init() {
        try {
            imagenes = new ArrayList<>();
            imagenes.add("https://images5.alphacoders.com/336/336484.jpg");
            imagenes.add("https://images4.alphacoders.com/909/thumb-1920-909185.jpg");
            imagenes.add("https://images.hdqwalls.com/wallpapers/the-batman-2021-artwork-b8.jpg");

            peliculasCartelera = clienteServicio.listarPeliculasPorEstado("EN_CARTELERA");
            peliculasProximamente = clienteServicio.listarPeliculasPorEstado("PROXIMAMENTE");
            ciudades = adminServicio.listarCiudades();
        } catch (Exception e) {
            e.printStackTrace();
            //FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Peliculas no encontradas", e.getMessage());
            //FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public void elegirCiudad() {
        try {
            if(ciudad != null) {
                peliculasCartelera = clienteServicio.listarPeliculasPorEstadoCiudad("EN_CARTELERA", ciudad.getCodigo());
                peliculasProximamente = clienteServicio.listarPeliculasPorEstadoCiudad("PROXIMAMENTE", ciudad.getCodigo());
            }
        } catch (Exception e) {
            e.printStackTrace();
            //FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Peliculas no encontradas", e.getMessage());
            //FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
}
