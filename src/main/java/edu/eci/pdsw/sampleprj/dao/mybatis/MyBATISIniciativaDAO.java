package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import java.util.Date;

public class MyBATISIniciativaDAO implements IniciativaDAO{

	
    @Inject
    IniciativaMapper iniciativaMapper;

    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws PersistenceException {
            try {
                iniciativaMapper.cambiarEstado(iniciativa.getId(),tipoEstado);
            }
            catch(org.apache.ibatis.exceptions.PersistenceException e) {
                System.out.println(e.getMessage());
                throw new PersistenceException("Error al cambiar el estado de la iniciativa");
            }	
    }

    @Override
    public Set<Iniciativa> buscarIniciativa(String palabraClave) throws PersistenceException {
        try {
                Set<Iniciativa> iniciativas = new HashSet<Iniciativa>();
                String[] palabras = palabraClave.split(",");

                for (int i=0; i<palabras.length;i++) {
                        for (Iniciativa j :iniciativaMapper.buscarIniciativa(palabras[i].toLowerCase())) {
                                iniciativas.add(j);
                        }

                }
                return iniciativas;
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
        	System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }	
    }
    
     @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(String palabraClave) throws PersistenceException {
        try {
                Set<Iniciativa> iniciativas = new HashSet<Iniciativa>();
                String[] palabras = palabraClave.split(",");
                for (int i=0; i<palabras.length;i++) {
                        for (Iniciativa j :iniciativaMapper.buscarIniciativasRelacionadas(palabras[i].toLowerCase())) {
                                iniciativas.add(j);
                        }
                }
                return iniciativas;
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
        	System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativas relacionadas");
        }	
    }	

    @Override
    public List<Iniciativa> getIniciativas() throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativas();
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }	
    }

    @Override
    public Iniciativa consultarIniciativa(int id) throws PersistenceException {
        try {
            return iniciativaMapper.consultarIniciativa(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }
    }
    
    @Override
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha) {
        try {
            iniciativaMapper.comentarIniciativas(id_user,id_iniciativa,comentario,fecha);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }
    }
}