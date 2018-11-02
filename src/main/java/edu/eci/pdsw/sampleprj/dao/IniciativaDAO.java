package edu.eci.pdsw.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;

public interface IniciativaDAO {
	
    public void cambiarEstado(Iniciativa iniciativa,TipoEstado tipoEstado ) throws PersistenceException;

}
