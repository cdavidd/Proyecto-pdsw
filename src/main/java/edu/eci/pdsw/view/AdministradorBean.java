package edu.eci.pdsw.view;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.time.LocalDate;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name = "administradorBean")
@RequestScoped
public class AdministradorBean extends BasePageBean{
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value="#{param.id}")
    private int id;
    
    private String estado,comentario,descripcion,palabrasClave;
    private List<String> tipoEstado= Arrays.asList("En Espera Revision", "En revision", "Proyecto", "Solucionado");
    private List<Iniciativa> iniciativas = new ArrayList<Iniciativa>();
    
    /**
     * Este metodo se encarga de consultar todos los usuarios sin Rol.
     * @return UsuariosSinRol Retorna una lista con los usuarios sin rol.
     */
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
    	return servicioBanco.consultarUsuariosSinRol();	
    }
    
    public List<Usuario> getUsuarios() throws ExcepcionServicesBanco{
        return servicioBanco.consultarUsuarios();
    }
    
    /**
     * Este metodo se encarga de retornar las iniciativas.
     * @return Iniciativas Retorna las iniciativas actuales.
     */
    public List<Iniciativa> getIniciativas() throws ExcepcionServicesBanco{
          try{
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa){
                super.nuevaIniciativa=false;
                temp.addAll(servicioBanco.getIniciativas());
                iniciativas= temp;
           }
           return iniciativas;   
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    
    /**
     * Este metodo se encarga de consultar las iniciativas.
     * @return Iniciativa Retorna la iniciativa actual.
     */
    public Iniciativa consultarIniciativa(){
        return servicioBanco.consultarIniciativa(id);
    }

    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa.
     */
    public void cambiarEstado() throws ExcepcionServicesBanco{   
        Iniciativa iniciativa=consultarIniciativa();
        if (estado.equals("En Espera Revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.valueOf("En_Espera_Revision"));
        }else if (estado.equals("En revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.valueOf("En_revision"));
        }else{
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.valueOf(estado));
        }
        
    }
    
    /**
     * Este metodo se encarga de cambiar el rol de un usuario.
     * @param usuario Es el usuario a cambiar el rol.
     * @param rol Nuevo rol.
     * @throws ExcepcionServicesBanco. 
     */
    public void cambiarRol (Usuario usuario, String rol) throws ExcepcionServicesBanco{
        servicioBanco.cambiarRol(usuario,rol);
    }
    
    /**
     * Este metodo se encarga de buscar las iniciativas por palabras clave.
     * @param palabraClave Son las palabras clave de las iniciativas.
     * @return Retorna una lista con las iniciativas.
     * @throws ExcepcionServicesBanco 
     */
    public Set<Iniciativa> buscarIniciativas(String palabraClave) throws ExcepcionServicesBanco{
    	return servicioBanco.buscarIniciativa(palabraClave);
    	
    }
    /**
     * Este metodo se encarga de comentar una iniciativa.
     * @param usuario_id Es el usuario que la comentó.
     */
    public void comentarIniciativas(int usuario_id){
        servicioBanco.comentarIniciativas(usuario_id,id,comentario,java.sql.Date.valueOf(LocalDate.now()));
    }
    
    /**
     * Este metodo se encarga de modificar la descripcion.
     * @throws ExcepcionServicesBanco 
     */
    public void modificarDescripcion() throws ExcepcionServicesBanco{
        servicioBanco.modificarDescripcion(id, descripcion);
    }
    
    /**
     * Este metodo se encarga de modificar las palabras clave.
     * @throws ExcepcionServicesBanco 
     */
    public void modificarPalabrasClave() throws ExcepcionServicesBanco{
        servicioBanco.modificarPalabrasClave(id, palabrasClave);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasclave) {
        this.palabrasClave = palabrasclave;
    }
    
     public ServiciosBanco getServicioBanco() {
        return servicioBanco;
    }

    public void setServicioBanco(ServiciosBanco servicioBanco) {
        this.servicioBanco = servicioBanco;
    }

    public List<String> getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(List<String> tipoEstado) {
        this.tipoEstado = tipoEstado;
    }
}