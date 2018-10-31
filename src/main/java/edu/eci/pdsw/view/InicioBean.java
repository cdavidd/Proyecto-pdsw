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
    
    public Usuario consultar(String correo) throws Exception{
        try{
            return servicioBanco.consultarUsuario(correo);
        }catch(ExcepcionServicesBanco ex){
            throw ex;
        }        
    }
    
    public void registrarUsuario(int id, String nombre, String email, String contrasena, Rol rol) throws ExcepcionServicesBanco{
        try{
            servicioBanco.registrarUsuario(new Usuario(id,nombre,email,contrasena,rol));
        }catch(ExcepcionServicesBanco ex){
            throw ex;
        }
    }
    
}