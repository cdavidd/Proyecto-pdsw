package edu.eci.pdsw.samples.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.sampleprj.dao.*;
import edu.eci.pdsw.samples.entities.Rol;
import java.util.Date;

public class ServiciosBancoImpl implements ServiciosBanco{

	
    @Inject
    private AdministradorDAO administradorDAO;

    @Inject 
    private IniciativaDAO iniciativaDAO;
    
    @Inject
    private ProponenteDAO proponenteDao;
    
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        try {
            administradorDAO.registrarUsuario(u);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+u.getEmail());
        }
    }

    @Override
    public Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuario(correo);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+correo);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuarios();
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios");
        }
    }

    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco{
        try {
            iniciativaDAO.cambiarEstado(iniciativa, tipoEstado);
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al cambiar el estado de la iniciativa");
        }		
    }

    @Override
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
        try {
            return administradorDAO.consultarUsuariosSinRol();
           }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios sin rol");
        }
    }

    @Override
    public void cambiarRol(Usuario usuario, String rol) throws ExcepcionServicesBanco {
        try{
           administradorDAO.cambiarRol(usuario,rol);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al cambiar el Rol a"+usuario.toString());
        }
    }

    @Override
    public void registrarIniciativa(String descripcion, Date fecha, Usuario usuario, String titulo, String area) throws ExcepcionServicesBanco {
        try{
           proponenteDao.registrarIniciativa(descripcion, fecha, usuario, titulo, area);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al registrar iniciativa "+titulo);
        }
    }

	@Override
	public Set<Iniciativa> buscarIniciativa(String palabraClave) throws ExcepcionServicesBanco {
		 try{
			 return iniciativaDAO.buscarIniciativa(palabraClave);
		}catch(PersistenceException ex) {
	            throw new ExcepcionServicesBanco("Error al buscar iniciativa con palabra clave "+ palabraClave );
	        }
	}
}