package edu.eci.pdsw.view;
import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;

import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@SuppressWarnings("deprecation")
@ManagedBean(name = "inicioBean")
@SessionScoped
public class InicioBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;

    
    @Inject
    ServiciosBanco servicioBanco;
    
    private String contrasena;
    private String email;
    private Usuario usuario;
    private String message;
    private boolean conIncorrecta;
    
    public Usuario consultar(String correo,String contrasena){
        try{
            this.setUsuario(servicioBanco.consultarUsuario(correo));
            if (!usuario.getContrasena().equals(contrasena)) setUsuario(null);
            return servicioBanco.consultarUsuario(correo);
        }
        catch(ExcepcionServicesBanco ex){
            //System.out.println(ex.getMessage());
            return null;
        }
        catch(Exception e){
            setUsuario(null);
            return null;
        }
    }

    public void reiniciar(){
        setContrasena("");
        setEmail("");
        setUsuario(null);
    }

    public String getContrasena(){
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String mail){
        this.email=mail;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String irHome(){
        if (usuario == null){
            FacesContext context = FacesContext.getCurrentInstance();                
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error de auntenticacion","Usuario o Contrasena incorrectos"));            
            return "inicioSesion";
        }
        else return "home";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isConIncorrecta() {
        return conIncorrecta;
    }

    public void setConIncorrecta(boolean conIncorrecta) {
        this.conIncorrecta = conIncorrecta;
    }
    
}