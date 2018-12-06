package edu.eci.pdsw.sampleprj.dao;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.*;

public interface AdministradorDAO{
    
    /**
     * Este metodo se encarga de consultar usuarios.
     * @return Retorna una lista de usuarios.
     * @throws PersistenceException 
     */
    public List<Usuario> consultarUsuarios() throws PersistenceException;
    
    /**
     * Este metodo se encarga de consultar usuarios sin rol.
     * @return Retorna una lista de usuarios sin rol.
     * @throws PersistenceException 
     */
    public List<Usuario> consultarUsuariosSinRol() throws PersistenceException;
    
    /**
     * Este metodo se encarga de registrar un nuevo usuario.
     * @param u Es el usuario a registrar.
     * @throws PersistenceException 
     */
    public void registrarUsuario(Usuario u) throws PersistenceException;
    
    /**
     * Este metodo se encarga de Consultar un usuario por su correo.
     * @param correo Es el correo del usuario.
     * @return Retorna el usuario.
     * @throws PersistenceException 
     */
    public Usuario consultarUsuario(String correo) throws PersistenceException;
    
    /**
     * Este metodo se encarga de cambiarle el rol a un usuario.
     * @param usuario Es el usuario a cambiar el rol.
     * @param rol El nuevo rol.
     * @throws PersistenceException 
     */
    public void cambiarRol(Usuario usuario, String rol) throws PersistenceException;
}
