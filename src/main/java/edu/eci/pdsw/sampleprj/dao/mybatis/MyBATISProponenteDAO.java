/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ProponenteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 *
 * @author cdavi_000
 */
public class MyBATISProponenteDAO implements ProponenteDAO{
    
    @Inject
    IniciativaMapper iniciativaMapper;
  
    /**
     * Este metodo se encarga de registrar una iniciativa
     * @param descripcion la descripcion de la iniciativa 
     * @param fecha la fecha de la iniciativa
     * @param usuario el usuario que desea registar la iniciativa
     * @param palabraclave las palabarasclave de la nueva iniciativa
     * @throws PersistenceException 
     */
    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabraclave) throws PersistenceException {
        try{
            iniciativaMapper.registrarIniciativa(descripcion, fecha, usuario, palabraclave);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
        	System.out.println(e.getMessage());
            throw new PersistenceException("Error al registrar iniciativa ");
        }
    }   
}