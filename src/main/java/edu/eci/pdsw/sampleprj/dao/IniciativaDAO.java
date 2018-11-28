package edu.eci.pdsw.sampleprj.dao;

import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import java.util.List;

public interface IniciativaDAO {
	
    public void cambiarEstado(Iniciativa iniciativa,TipoEstado tipoEstado ) throws PersistenceException;
    
    public Set<Iniciativa> buscarIniciativa(String palabraClave)throws PersistenceException;
    
    public List<Iniciativa> getIniciativas() throws PersistenceException;

    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
    
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha);
    
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws PersistenceException;

    public List<String> getEstadisticas() throws PersistenceException;

    public List<String> getEstadisticasEstado() throws PersistenceException;

    public List<Iniciativa> buscarIniciativaProponente(int id) throws PersistenceException;
    
    public void modificarDescripcion(int id, String descripcion) throws PersistenceException;
    
    public void modificarPalabrasClave(int id, String palabrasclave) throws PersistenceException;

}
