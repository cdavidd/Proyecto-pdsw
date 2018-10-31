package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Usuario;

/**
 *
 * @author 2125509
 */
public interface UsuarioMapper {
    
    public Usuario consultarCliente(@Param("email") String email); 
    public void insertarCliente(@Param("usuario")Usuario user );  
}
