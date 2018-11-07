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
    private List<Usuario> usuarios;
    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value="#{param.id}")
    
    private int id;
    private String estado;
    private List<String> tipoEstado= Arrays.asList("En_Espera_Revision", "En_revision", "Proyecto", "Solucionado");

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
        return servicioBanco.getIniciativas();
    }
    
    public Iniciativa consultarIniciativa(){
        return servicioBanco.consultarIniciativa(id);
    }


    public void algo(Rol rol) {
    	System.out.println(rol);
    	
    }
    
    public void cambiarEstado() throws ExcepcionServicesBanco{   
        //System.out.println(id);
        System.out.println(estado);
        //Iniciativa iniciativa=consultarIniciativa();
        //System.out.println(iniciativa.toString());
        
        //String ej= tipoEstado.toLowerCase();
       // servicioBanco.cambiarEstado(iniciativa,tipoEstado);
        /*if (ej.equals("en_espera_revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.En_Espera_Revision);
        }else if (ej.equals("en_revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.En_revision);
        }else if (ej.equals("proyecto")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.Proyecto);
        }else if (ej.equals("solucionado")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.Solucionado);
        }*/
    }
    
    public void cambiarRol (Usuario usuario, String rol) throws ExcepcionServicesBanco{
        servicioBanco.cambiarRol(usuario,rol);
    }
    
    public Set<Iniciativa> buscarIniciativas(String palabraClave) throws ExcepcionServicesBanco{
    	return servicioBanco.buscarIniciativa(palabraClave);
    	
    }




    public void setUsuarios(List<Usuario> usuarios) {
            this.usuarios = usuarios;
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
    
    
    
}