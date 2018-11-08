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

    
    
    public Usuario consultar(String correo){
        try{
        	this.setUsuario(servicioBanco.consultarUsuario(correo));
            return servicioBanco.consultarUsuario(correo);
        }catch(ExcepcionServicesBanco ex){
            System.out.println(ex.getMessage());
            return null;
        }        	
    }
    
    
    public String irHome(String email) {
    	Usuario user;
        FacesMessage message = null;
        boolean loggedIn = false;
        try {
                user = servicioBanco.consultarUsuario(email);
                System.out.println(user.getContrasena().equals(contrasena));
                if(!user.getContrasena().equals(contrasena)){
                     loggedIn = false;
                     message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
                    return null;
                }else{
                    loggedIn = true;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getNombre());
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
                    switch (user.getRol()) {
                        case Administrador:
                            return "homeAdmi";
                        case Proponente:
                            return "homeP";
                        case Pmo_Odi:
                            return null;
                        case Publico:
                            return null;
                        default:
                            return null;
                    }
                    
                }
                
        } 
        catch (ExcepcionServicesBanco e) {
                e.printStackTrace();
                return null;
        }
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
}