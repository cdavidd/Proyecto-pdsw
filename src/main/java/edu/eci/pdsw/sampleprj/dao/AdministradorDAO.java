package edu.eci.pdsw.sampleprj.dao;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.*;

public interface AdministradorDAO{
    
    public List<Usuario> consultarUsuarios() throws PersistenceException;
    public List<Usuario> consultarUsuariosSinRol() throws PersistenceException;
    public void registrarUsuario(Usuario u) throws PersistenceException;
    public Usuario consultarUsuario(String correo) throws PersistenceException;
    public void cambiarRol(Usuario usuario, String rol) throws PersistenceException;
}
