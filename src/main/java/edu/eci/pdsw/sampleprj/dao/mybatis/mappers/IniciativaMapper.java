package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import java.util.Date;

public interface IniciativaMapper {
    
    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa 
     * @param id
     * @param tipoEstado 
     */
    public void cambiarEstado(@Param("id")int id, @Param("estado")TipoEstado tipoEstado);
    
    /**
     * Este metodo se encarga de retornar iniciativas mediante la palabra clave
     * @param palabraClave
     * @return 
     */
    public List<Iniciativa> buscarIniciativa(@Param("palabra")String palabraClave);
    
    /**
     * Este metodo se encarga de retornar iniciativas relacionadas
     * @param palabraClave
     * @param id
     * @return 
     */
    public List<Iniciativa> buscarIniciativasRelacionadas(@Param("palabra")String palabraClave,@Param("id")int id);
    
    public List<Iniciativa> getIniciativas();

    /**
     * Este metodo se encarga de consultar una iniciativa mediante el id
     * @param id
     * @return 
     */
    public Iniciativa consultarIniciativa(@Param("id")int id);
    
    /**
     * Este metodo se encarga de registrar iniciativa
     * @param descripcion
     * @param fecha
     * @param usuario
     * @param palabrasclave 
     */
    public void registrarIniciativa(@Param("descripcion")String descripcion,@Param("fecha") Date fecha,@Param("usuario") int usuario,@Param("palabrasclave") String palabrasclave);
    
    /**
     * Este metodo se encarga de comentar una iniciativa
     * @param usuario_id
     * @param iniciativa_id
     * @param comentario
     * @param fecha_publicacion 
     */
    public void comentarIniciativas(@Param("usuario_id")int usuario_id,@Param("iniciativa_id")int iniciativa_id,@Param("comentario")String comentario,@Param("fecha_publicacion")Date fecha_publicacion);

    public List<String> getEstadisticas();

    public List<String> getEstadisticasEstado();
    
    /**
     * Este metodo se encarga de de retornar iniciativas del proponente mediante el id del proponente
     * @param id
     * @return 
     */
    public List<Iniciativa> buscarIniciativaProponente(@Param("id") int id);
    
    /**
     * Este metodo se encarga de modificar las palabras clave de una iniciativa
     * @param id
     * @param descripcion 
     */
    public void modificarPalabrasClave(@Param("id")int id, @Param("palabrasclave") String descripcion);   
    
    /**
     * Este metodo se encarga de modificar la descripcion de una iniciativa
     * @param id
     * @param descripcion 
     */
    public void modificarDescripcion(@Param("id")int id, @Param("descripcion") String descripcion);   
    
    /**
     * Este metodo se encarga de dar like a una iniciativa
     * @param iniciativa_id
     * @param usuario_id 
     */
    public void darLike(@Param("id_iniciativa")int iniciativa_id, @Param("id_usuario") int usuario_id);
    
    /**
     * Este metodo se encarga de consultar los likes de una iniciativa
     * @param iniciativa
     * @return 
     */
    public String consultarLikes(@Param("iniciativa") int iniciativa);
    
    /**
     * Este metodo se encarga de consultar so un usuario le dio like a una iniciativa
     * @param iniciativa
     * @param usuario
     * @return 
     */
    public String consultarUsuarioDioLike(@Param("iniciativa") int iniciativa, @Param("usuario") int usuario);
    
    /**
     * Este metodo se encarga de quitar el like de una iniciativa
     * @param iniciativa_id
     * @param usuario_id 
     */
    public void dislikes(@Param("iniciativa")int iniciativa_id,@Param("usuario") int usuario_id);
}