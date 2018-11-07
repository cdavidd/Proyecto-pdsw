package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Administrador;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "registroBean")
@SessionScoped
public class RegistroBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosBanco servicioBanco;
    
    private int id;
    private String nombre,email,contrasena;
    
    public void registrarUsuario(int id, String nombre, String email, String contrasena){
        try{
            servicioBanco.registrarUsuario(new Administrador(id,nombre,email,contrasena));
        }catch(ExcepcionServicesBanco ex){
            System.out.println(ex.getMessage());
        }
    
    }
    public int getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public void setId(int ID){
        this.id=ID;
    }
    
    public void setNombre(String name){
        this.nombre=name;
    }
    
    public void setEmail(String mail){
        this.email=mail;
    }
    
    public void setContrasena(String pass){
        this.contrasena=pass;
    }
}