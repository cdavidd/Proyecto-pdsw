package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.*;
import edu.eci.pdsw.sampleprj.dao.AdministradorDAO;
import edu.eci.pdsw.samples.entities.Rol;

public class MyBATISAdministradorDAO implements AdministradorDAO{

    @Inject 
    private UsuarioMapper usuarioMapper;

    /**
     * Este metodo se encarga de consultar los usuarios
     * @return List<Usuario> Retorna una lista con todos los usuarios.
     * @throws PersistenceException 
     */
    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
        try {
            return usuarioMapper.consultarUsuarios();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los clientes");
        }
    }

    /**
     * Este metodo se encarga de consultar los usuarios que no tienen un rol asignado
     * @return List<Usuario> retorna una lista con todos los usuarios que no tienen rol
     * @throws PersistenceException 
     */
    @Override
    public List<Usuario> consultarUsuariosSinRol() throws PersistenceException {
        try {
                return usuarioMapper.consultarUsuariosSinRol();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los clientes sin rol");
        }
    }
    
    /**
    * Este metodo se encarga de registrar un usuario en la base de datos 
     * @param u el usuario que se desea registrar
     * @throws PersistenceException 
     */
    @Override
    public void registrarUsuario(Usuario u) throws PersistenceException {
        try {
                usuarioMapper.insertarUsuario(u);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
        	System.out.println(e.getMessage());
            throw new PersistenceException("Error al registar el cliente");
        }
    }

    /**
     * Este metodo se encarga de consultar un usuario 
     * @param correo el correo del usuario que se desea consultar 
     * @return Usuario retorna el usuario que se desea consultar
     * @throws PersistenceException 
     */
    @Override
    public Usuario consultarUsuario(String correo) throws PersistenceException {
        try {
                return usuarioMapper.consultarUsuario(correo);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
                System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar el cliente");
        }
    }

    /**
     * Este metodo se encarga de cambiar el rol de un usuario
     * @param usuario el usuario al que se desea cambiar el rol
     * @param rol el rol por el que se desea cambiar el rol actual 
     * @throws PersistenceException 
     */
    @Override
    public void cambiarRol(Usuario usuario, String rol) throws PersistenceException {
        try{
            usuarioMapper.cambiarRol(usuario,Rol.valueOf(rol));
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar el cliente");
        }
    }
}