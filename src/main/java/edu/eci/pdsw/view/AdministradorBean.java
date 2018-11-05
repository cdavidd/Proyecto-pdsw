/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.*;
import javax.faces.bean.ManagedBean;
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
    
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
    	return servicioBanco.consultarUsuariosSinRol();	
    }
    
    
    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco{
        return servicioBanco.consultarUsuarios();
    }
    
    public void cambiarEstado(Iniciativa iniciativa, String tipoEstado) throws ExcepcionServicesBanco{     
        String ej= tipoEstado.toLowerCase();
        if (ej.equals("en_espera_revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.En_Espera_Revision);
        }else if (ej.equals("en_revision")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.En_revision);
        }else if (ej.equals("proyecto")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.Proyecto);
        }else if (ej.equals("solucionado")){
            servicioBanco.cambiarEstado(iniciativa,TipoEstado.Solucionado);
        }
    }
    
    public void cambiarRol (Usuario usuario, String rol) throws ExcepcionServicesBanco{
        servicioBanco.cambiarRol(usuario,rol);
    }
}