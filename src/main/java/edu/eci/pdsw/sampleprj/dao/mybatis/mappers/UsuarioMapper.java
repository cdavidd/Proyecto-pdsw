package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;

/**
 *
 * @author 2125509
 */
public interface UsuarioMapper {
    
    public Usuario consultarUsuario(@Param("email") String email); 
    public void insertarUsuario(@Param("usuario") Usuario user );
	public List<Usuario> consultarUsuarios();
	public List<Usuario> consultarUsuariosSinRol();
}
