package sys.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.dao.UsuarioDAO;
import sys.impl.UsuarioDAOImpl;
import sys.modelo.Usuarios;

@ManagedBean
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private Usuarios usuario;
    private String nombreUsuario;
    private String password;

    public LoginBean() {
        this.usuario= new Usuarios();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";

        UsuarioDAO datos = new UsuarioDAOImpl();
        this.usuario = datos.login(usuario);

        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombreUsuario());
            ruta = "/InstitutoRelsb/faces/Views/Bienvenido.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Usuario o Password Incorrectos");
            usuario = new Usuarios();
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
    }

    public String logout() {
        this.nombreUsuario = null;
        this.password = null;

        HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate();
        return "/Login";
    }
}
