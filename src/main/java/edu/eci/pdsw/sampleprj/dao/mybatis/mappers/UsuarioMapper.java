/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;
import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author cdavi_000
 */
public interface UsuarioMapper {
    /**
     * Este metodo se encarga de retornar un usuario mediante su email
     * @param email
     * @return 
     */
    public Usuario consultarUsuario(@Param("email") String email); 
    
    /**
     * Este metodo se encarga de insertar un usuario
     * @param user 
     */
    public void insertarUsuario(@Param("usuario") Usuario user );
    
    /**
     * Este metodo se encarga de retornar todos los usuarios
     * @return 
     */
    public List<Usuario> consultarUsuarios();
    
    /**
     * Este metodo se encarga de de retornar todos los usuarios sin rol
     * @return 
     */
    public List<Usuario> consultarUsuariosSinRol();
    
    /**
     * Este metodo se encarga de cambiar el rol a un usuario
     * @param usuario
     * @param rol 
     */
    public void cambiarRol(@Param("usuario") Usuario usuario,@Param("rol")Rol rol);
}