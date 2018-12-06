package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ComentarioDAO {
    
    /**
     * Este metodo se encarga de retornar un usuario segun su id.
     * @param id Es el id del usuario.
     * @return Retorna el usuario.
     * @throws PersistenceException 
     */
     public List<Comentario> getComentarios(int id) throws PersistenceException;
}
