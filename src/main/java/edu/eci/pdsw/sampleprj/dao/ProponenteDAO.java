package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ProponenteDAO {
    
    /**
     * Este metodo se encarga de registrar una iniciativa.
     * @param descripcion Es la descripcion de la iniciativa.
     * @param fecha Es la fecha de creacion.
     * @param usuario Es el usuario que la creo.
     * @param palabrasclave Son las palabras clave.
     * @throws PersistenceException 
     */
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws PersistenceException;
    
}
