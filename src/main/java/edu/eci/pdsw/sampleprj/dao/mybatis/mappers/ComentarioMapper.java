package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Comentario;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ComentarioMapper {
    
    /**
     * Este metodo se encarga de retornar los comentarios
     * @param id
     * @return 
     */
    public List<Comentario> getComentarios (@Param("Id_Iniciativa")int id);

}