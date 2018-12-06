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

 
    /**
     * Este metodo se encarga de modificar la descripcion de una iniciativa 
     * @param id el id de la iniciativa 
     * @param descripcion la nueva descripcion por la que se desea reemplazar la actual descripcion
     * @throws PersistenceException 
     */
    @Override
    public void modificarDescripcion(int id, String descripcion) throws PersistenceException {
            try {
                iniciativaMapper.modificarDescripcion(id,descripcion);
            }
            catch(org.apache.ibatis.exceptions.PersistenceException e) {
                System.out.println(e.getMessage());
                throw new PersistenceException("Error al modificar la descripcion de la iniciativa");
            }	    
    }
    
    /**
     * Este metodo se encarga de modificar las palabras clave de una iniciativa
     * @param id el id de la iniciativa que se desea modificar
     * @param palabrasclave las palabras clave por las que se desea reemplazar las actuales
     * @throws PersistenceException 
     */
    @Override
    public void modificarPalabrasClave(int id, String palabrasclave) throws PersistenceException {
            try {
                iniciativaMapper.modificarPalabrasClave(id,palabrasclave);
            }
            catch(org.apache.ibatis.exceptions.PersistenceException e) {
                System.out.println(e.getMessage());
                throw new PersistenceException("Error al modificar las palabras clave de la iniciativa");
            }	    
    }

    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa 
     * @param iniciativa la iniciativa a la que le desea cambiar el estado
     * @param tipoEstado el nuevo tipo de estado que se desea actualizar
     * @throws PersistenceException 
     */
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
    
    /**
     * Este metodo se encarga de buscar las iniciativas relacionadas de una iniciativa
     * @param iniciativa la iniciativa a la que le desea buscar las iniciativas relacionadas 
     * @return Set<Iniciativa> retorna un conjunto con las iniciativas relacionadas
     * @throws PersistenceException 
     */
     @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws PersistenceException {
        try {
                Set<Iniciativa> iniciativas = new HashSet<Iniciativa>();
                String[] palabras = iniciativa.getPalabrasClave().split(",");
                for (int i=0; i<palabras.length;i++) {
                        for (Iniciativa j :iniciativaMapper.buscarIniciativasRelacionadas(palabras[i].toLowerCase(),iniciativa.getId())) {
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

    /**
     * Este metodo se encarga de consultar todas las iniciativas del banco de iniciativas
     * @return List<Iniciativa> una lista con todas las iniciativas
     * @throws PersistenceException 
     */
    @Override
    public List<Iniciativa> getIniciativas() throws PersistenceException {
        try {
            return iniciativaMapper.getIniciativas();
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }	
    }

    /**
     * consultar una iniciativa por su id
     * @param id el id de la iniciativa que se desea consultar
     * @return Iniciativa la iniciativa consultada
     * @throws PersistenceException 
     */
    @Override
    public Iniciativa consultarIniciativa(int id) throws PersistenceException {
        try {
            return iniciativaMapper.consultarIniciativa(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }
    }
    
    /**
     * Este metodo se encarga de comentar una iniciativa 
     * @param id_user el usuario que realiza el comentario
     * @param id_iniciativa el id de la iniciativa a la que se le realizar el comentario
     * @param comentario una cadena con la informacion del comentario
     * @param fecha la fecha del dia que se realiza el comentario
     */
    @Override
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha) {
        try {
            iniciativaMapper.comentarIniciativas(id_user,id_iniciativa,comentario,fecha);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al buscar iniciativa");
        }
    }

    @Override
    public List<String> getEstadisticas() throws PersistenceException {
        try {
            //System.out.println(iniciativaMapper.getEstadisticas().toString());
            return iniciativaMapper.getEstadisticas();
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            //System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar estadisticas ");
        }
    }
    
    /**
     * Este metodo se encarga retornar las estadisticas por estado
     * @return List<String> una lista con todas las estadisticas
     * @throws PersistenceException 
     */
    @Override
    public List<String> getEstadisticasEstado() throws PersistenceException{
        try {
            //System.out.println(iniciativaMapper.getEstadisticasEstado().toString());
            return iniciativaMapper.getEstadisticasEstado();
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            //System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar estadisticas estado");
        }
    }

    /**
     * Este metodo se encarga de buscar las iniciativas de un proponente 
     * @param id el id del usuario
     * @return List<Iniciativa> una lista con las iniciativas del proponente
     * @throws PersistenceException 
     */
    @Override
    public List<Iniciativa> buscarIniciativaProponente(int id) throws PersistenceException {
        try {
            return iniciativaMapper.buscarIniciativaProponente(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar estadisticas estado");
        }
    }

    /**
     * Este metodo se encarga de registrar un like de un usuario a una iniciativa
     * @param iniciativa_id la iniciativa a la que se le esta dando like 
     * @param usuario_id el usuario que dio like
     * @throws PersistenceException 
     */
    @Override
    public void darLike(int iniciativa_id, int usuario_id) throws PersistenceException {
        try {
            iniciativaMapper.darLike(iniciativa_id,usuario_id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al dar like");
        }    
    }

    /**
     * Este metodo se encarga de consultar todos los likes de una iniciativa
     * @param iniciativa la iniciativa a la que se le desea consultar los likes
     * @return los likes de la iniciativa
     * @throws PersistenceException 
     */
    @Override
    public String consultarLikes(int iniciativa) throws PersistenceException {
        try {
            return iniciativaMapper.consultarLikes(iniciativa);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al dar like");
        }    
    }
    
    /**
     * Este metodo se encarga de consultar si un usuario le dio like a una iniciativa
     * @param iniciativa la iniciativa que se desea consultar
     * @param usuario el usuario
     * @return un booleano indicando si el usuario le dio like o no
     * @throws PersistenceException 
     */
    @Override
    public boolean consultarUsuarioDioLike(int iniciativa, int usuario) throws PersistenceException {
        try {
            if (iniciativaMapper.consultarUsuarioDioLike(iniciativa,usuario).equals("0")) return false;
            else return true;
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar si el usuario le dio like");
        }      
    }

    /**
     * Este metodo se encarga de cancelar un like de un usuario a una iniciativa
     * @param iniciativa_id el id de la iniciativa
     * @param usuario_id el usuario que desea cancelar el like
     * @throws PersistenceException 
     */
    @Override
    public void dislikes(int iniciativa_id, int usuario_id) throws PersistenceException {
        try {
            iniciativaMapper.dislikes(iniciativa_id,usuario_id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al dar dislike");
        }      
    }
}