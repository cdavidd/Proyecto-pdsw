package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;

import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "registroBean")
@RequestScoped
public class RegistroBean extends BasePageBean{
    private static final long serialVersionUID = 3594009161252782831L;

    
    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value="#{param.email}")
    private String email;
    
    
    private int id;
    private String nombre,contrasena,area;
    private String rol;
    private List<String> tipoRol= Arrays.asList("Administrador", "Publico", "Pmo_Odi", "En_Espera","Proponente");

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public List<String> getTipoRol() {
            return tipoRol;
    }
    public void setTipoRol(List<String> tipoRol) {
            this.tipoRol = tipoRol;
    }
    
    /**
     * Este metodo se encarga de registrar un usuario nuevo.
     * @param nombre Es el nombre del usuario.
     * @param email Es el email del usuario.
     * @param contrasena Es la contraseņa del usuario.
     * @param area  Es el area del usuario.
     */
    public void registrarUsuario(String nombre, String email, String contrasena,String area){
        try{
            servicioBanco.registrarUsuario(new Usuario(nombre,email,contrasena,area));
        }catch(ExcepcionServicesBanco ex){
            System.out.println(ex.getMessage());
        }
    
    }
    
    /**
     * Este metodo se encarga de consultar a un usaurio.
     * @return Retorna un usuario.
     */
    public Usuario consultarUsuario() {
    	try {
            return servicioBanco.consultarUsuario(email);
        } catch (ExcepcionServicesBanco e) {
                return null;
        }
    }
    
    /**
     * Este metodo se encarga de cambiar el rol de un usuario.
     * @throws ExcepcionServicesBanco 
     */
    public void cambiarRol() throws ExcepcionServicesBanco{   
        Usuario usuario=consultarUsuario();
        servicioBanco.cambiarRol(usuario,rol);
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

    public String getRol() {
            return rol;
    }
    public void setRol(String rol) {
            this.rol = rol;
    }
}