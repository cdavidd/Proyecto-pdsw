/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 *
 * @author cdavi_000
 */
public interface ProponenteDAO {
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws PersistenceException;
    
}
