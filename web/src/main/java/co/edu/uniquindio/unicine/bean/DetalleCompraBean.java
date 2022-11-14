package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class DetalleCompraBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;
    @Value("#{param['compra_id']}")
    private String codigoCompra;

    @Getter @Setter
    private Compra compra;

    @PostConstruct
    public void init() {
        if (codigoCompra != null && !codigoCompra.isEmpty()) {
            try {
                compra = clienteServicio.obtenerCompra(Integer.parseInt(codigoCompra));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
