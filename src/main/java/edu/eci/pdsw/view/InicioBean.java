package edu.eci.pdsw.view;
import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
        System.out.println(servicioBanco.getClass().getName());
		try {
			user = servicioBanco.consultarUsuario(email);
			if (user.getRol().equals(Rol.Administrador)) return "homeAdmi";
	    	
	    	else if (user.getRol().equals(Rol.Proponente)) return "homeP";		
			
			else if (user.getRol().equals(Rol.Pmo_Odi))  return null;
			
			else if (user.getRol().equals(Rol.Publico)) return null;
			
			else {
				System.out.println("entra");
				return null;
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