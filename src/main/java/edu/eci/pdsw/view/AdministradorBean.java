/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author 2133561
 */
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
    
    
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
    	return servicioBanco.consultarUsuariosSinRol();	
    }
    
    
    public List<Usuario> getUsuarios() throws ExcepcionServicesBanco{
        return servicioBanco.consultarUsuarios();
    }
    
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
    
    
    public Iniciativa consultarIniciativa(){
        return servicioBanco.consultarIniciativa(id);
    }


    
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
    
    public void cambiarRol (Usuario usuario, String rol) throws ExcepcionServicesBanco{
        servicioBanco.cambiarRol(usuario,rol);
    }
    
    public Set<Iniciativa> buscarIniciativas(String palabraClave) throws ExcepcionServicesBanco{
    	return servicioBanco.buscarIniciativa(palabraClave);
    	
    }
    
    public void comentarIniciativas(int usuario_id){
        servicioBanco.comentarIniciativas(usuario_id,id,comentario,java.sql.Date.valueOf(LocalDate.now()));
    }
    
    public void modificarDescripcion() throws ExcepcionServicesBanco{
        servicioBanco.modificarDescripcion(id, descripcion);
    }
    
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
}