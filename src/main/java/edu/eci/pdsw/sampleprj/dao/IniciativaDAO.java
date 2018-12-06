package edu.eci.pdsw.sampleprj.dao;

import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.*;
import java.util.Date;
import java.util.List;

public interface IniciativaDAO {
	
    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa.
     * @param iniciativa Es la iniciativa a cambiar.
     * @param tipoEstado Es el nuevo estado.
     * @throws PersistenceException 
     */
    public void cambiarEstado(Iniciativa iniciativa,TipoEstado tipoEstado ) throws PersistenceException;
    
    /**
     * Este metodo se encarga de buscar iniciativas por palabras clave. 
     * @param palabraClave Son las palabras clave.
     * @return Retorna una lista con las iniciativas.
     * @throws PersistenceException 
     */
    public Set<Iniciativa> buscarIniciativa(String palabraClave)throws PersistenceException;
    
    public List<Iniciativa> getIniciativas() throws PersistenceException;

    /**
     * Este metodo se encarga de buscar una iniciatvia por su id.
     * @param id Es el id de la iniciativa.
     * @return Retorna la iniciativa.
     * @throws PersistenceException 
     */
    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
    
    /**
     * Este metodo se encarga de comentar la iniciativa.
     * @param id_user Es el usuario que la comento.
     * @param id_iniciativa Es la iniciativa que se comento.
     * @param comentario Es el comentario.
     * @param fecha Es la fecha de creacion del comentario.
     */
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha);
    
    /**
     * Este metodo se encarga de buscar inicaitiavas relacionadas a otras.
     * @param iniciativa Es la iniciativa principal.
     * @return Retorna una lista de iniciativas.
     * @throws PersistenceException 
     */
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws PersistenceException;

    public List<String> getEstadisticas() throws PersistenceException;

    public List<String> getEstadisticasEstado() throws PersistenceException;

    /**
     * Este metodo se encarga de buscar iniciativas creadas por un proponente.
     * @param id Es el id del proponente.
     * @return Retorna una lista con las iniciativas.
     * @throws PersistenceException 
     */
    public List<Iniciativa> buscarIniciativaProponente(int id) throws PersistenceException;
    
    /**
     * Este metodo se encarga de modificar la descripcion de una iniciativa.
     * @param id Es el id de la iniciativa.
     * @param descripcion Es la nueva descripcion.
     * @throws PersistenceException 
     */
    public void modificarDescripcion(int id, String descripcion) throws PersistenceException;
    
    /**
     * Este metodo se encarga de modificar las plabras clave de una iniciativa.
     * @param id Es el id de la iniciativa.
     * @param palabrasclave Son las nuevas palabras clave.
     * @throws PersistenceException 
     */
    public void modificarPalabrasClave(int id, String palabrasclave) throws PersistenceException;
    
    /**
     * Este metodo se encarga de registrar el like.
     * @param iniciativa_id Es la iniciativa a la cual se le dio like.
     * @param usuario_id Es el usuario que le dio like.
     * @throws PersistenceException 
     */
    public void darLike(int iniciativa_id, int usuario_id) throws PersistenceException;
    
    /**
     * Este metodo se encarga de registrar el dislike.
     * @param iniciativa_id Es la iniciativa a la cual se le dio dislike.
     * @param usuario_id Es el usuario que le dio dislike.
     * @throws PersistenceException 
     */
    public void dislikes(int iniciativa_id, int usuario_id) throws PersistenceException;
    
    /**
     * Este metodo se encarga de consultar los likes de una iniciativa.
     * @param iniciativa Es la inciativa a consultar.
     * @return retorna un el numero de likes de la iniciativa.
     * @throws PersistenceException 
     */
    public String consultarLikes(int iniciativa) throws PersistenceException;
    
    /**
     * Este metodo se encarga de consultar que usuario le dio like a una iniciativa.
     * @param iniciativa Es la iniciativa a consultar.
     * @param usuario Es el usuario del cual se quieren saber si dio like.
     * @return Retorna un boolenao.
     * @throws PersistenceException 
     */
    public boolean consultarUsuarioDioLike(int iniciativa, int usuario) throws PersistenceException;
}
