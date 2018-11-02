package edu.eci.pdsw.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;

public class MyBATISIniciativaDAO implements IniciativaDAO{

	
	@Inject
	IniciativaMapper iniciativaMapper;
	
	@Override
	public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws PersistenceException {
		try {
			iniciativaMapper.cambiarEstado(iniciativa,tipoEstado);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
		    throw new PersistenceException("Error al cambiar el estado de la iniciativa");
		}	
	}	
}