package edu.eci.pdsw.sampleprj.dao;

import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.*;
import java.util.List;

public interface IniciativaDAO {
	
    public void cambiarEstado(Iniciativa iniciativa,TipoEstado tipoEstado ) throws PersistenceException;
    
    public Set<Iniciativa> buscarIniciativa(String palabraClave)throws PersistenceException;
    
    public List<Iniciativa> getIniciativas() throws PersistenceException;

    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
}
