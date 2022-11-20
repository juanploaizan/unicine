package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String cedula, password;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private String tipoSesion;

    @Getter @Setter
    private Ciudad ciudad;
    @Autowired
    private ClienteServicio clienteServicio;

    @Email
    @Getter @Setter
    private String email;

    @PostConstruct
    public void init() {
        autenticado = false;
    }

    public String iniciarSesionCliente() {

        if (!cedula.isEmpty() && !password.isEmpty()) {
            try {
                cliente = clienteServicio.login(cedula, password);
                tipoSesion = "cliente";
                autenticado = true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificacion", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificacion", "La cedula y la contraseña son obligatorios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    //TODO Editar el cerrar sesion para los admin
    public String cerrarSesion() {
        String tipo = tipoSesion;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        if (tipo.equals("cliente")) {
            autenticado = false;
            return "/index?faces-redirect=true";
        }
        return "/index_admin?faces-redirect=true";
    }

    public void seleccionarCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    //TODO iniciar sesión admin
    public void iniciarSesionAdmin() {}

    public void reestablecerContrasenia(){

        if (email != null && !email.isEmpty()) {
            try {
                clienteServicio.solicitarCambioContrasenia(email);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificación", "Se envió correctamente el correo de recuperación");
                FacesContext.getCurrentInstance().addMessage("recuperacion", fm);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificación", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificación", "El campo del correo es inválido");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
}
