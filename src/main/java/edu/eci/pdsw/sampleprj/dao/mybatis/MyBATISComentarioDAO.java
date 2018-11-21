/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ComentarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ComentarioMapper;
import edu.eci.pdsw.samples.entities.Comentario;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 *
 * @author Nicolas
 */
public class MyBATISComentarioDAO implements ComentarioDAO {

     @Inject
     ComentarioMapper comentarioMapper;

    
    @Override
    public List<Comentario> getComentarios(int id) throws PersistenceException {
        try {
                return comentarioMapper.getComentarios(id);
            }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            throw new PersistenceException("Error al consultar comentarios");
        }	
    }
    
}
