package edu.eci.pdsw.samples.services.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;

public class ServiciosBancoImpl implements ServiciosBanco{

	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject 
	private IniciativaDAO iniciativaDAO;
	
	@Override
	public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
		try {
			   usuarioDAO.registrarUsuario(u);
		   }
		   catch(PersistenceException ex) {
	           throw new ExcepcionServicesBanco("Error al consultar el usuario "+u.getEmail());
		   }
	}

	@Override
	public Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco {
		try {
			  return usuarioDAO.consultarUsuario(correo);
		   }
		   catch(PersistenceException ex) {
	           throw new ExcepcionServicesBanco("Error al consultar el usuario "+correo);
		   }
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco {
		try {
			  return usuarioDAO.consultarUsuarios();
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
			  return usuarioDAO.consultarUsuariosSinRol();
		   }
		   catch(PersistenceException ex) {
	           throw new ExcepcionServicesBanco("Error al consultar los usuarios sin rol");
		   }
	}
}