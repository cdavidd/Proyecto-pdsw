/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ProponenteDAO;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;

/**
 *
 * @author cdavi_000
 */
public class MyBATISProponenteDAO implements ProponenteDAO{
    
    @Inject
    UsuarioMapper proponenteMapper;
    
    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String titulo, String area) throws PersistenceException {
        try{
            proponenteMapper.registrarIniciativa(descripcion, fecha, usuario, titulo, area);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
        	System.out.println(e.getMessage());
            throw new PersistenceException("Error al registrar iniciativa "+titulo);
        }
    }
    
}
