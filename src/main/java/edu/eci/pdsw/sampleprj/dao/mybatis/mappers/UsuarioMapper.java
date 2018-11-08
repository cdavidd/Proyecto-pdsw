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
    public void registrarIniciativa(@Param("descripcion")String descripcion,@Param("fecha") Date fecha,@Param("usuario") int usuario,@Param("titulo") String titulo,@Param("area") String area);
    public Usuario consultarUsuario(@Param("email") String email); 
    public void insertarUsuario(@Param("usuario") Usuario user );
    public List<Usuario> consultarUsuarios();
    public List<Usuario> consultarUsuariosSinRol();
    public void cambiarRol(@Param("usuario") Usuario usuario,@Param("rol")Rol rol);
}