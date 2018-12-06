package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ServiciosBanco {
    
    /**
     * Este metodo se encarga de registrar un Usuario
     * @param u
     * @throws ExcepcionServicesBanco 
     */
    public abstract void registrarUsuario(Usuario u) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar un usuario mediante la consulta de su correo
     * @param correo
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public abstract Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar todos los usuarios
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa
     * @param iniciativa
     * @param tipoEstado
     * @throws ExcepcionServicesBanco 
     */
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar los usuarios que esten sin rol
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de cambiar el rol de un usuario
     * @param usuario
     * @param rol
     * @throws ExcepcionServicesBanco 
     */
    public void cambiarRol(Usuario usuario, String rol) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de registrar una iniciativa
     * @param descripcion
     * @param fecha
     * @param usuario
     * @param palabrasclave
     * @throws ExcepcionServicesBanco 
     */
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar iniciativas mediante la busqueda de la palabra clave
     * @param palabraClave
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public abstract Set<Iniciativa> buscarIniciativa(String palabraClave)throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar iniciativas relacionadas
     * @param iniciativa
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public abstract Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa)throws ExcepcionServicesBanco;

    public List<Iniciativa> getIniciativas();
    
    /**
     * Este metodo se encarga de retornar una iniciativa mediante su id
     * @param id
     * @return 
     */
    public Iniciativa consultarIniciativa(int id);
    
    /**
     * Este metodo se encarga de insertar un comentario a una iniciativa
     * @param usuario_id
     * @param iniciativa_if
     * @param comentarios
     * @param fecha 
     */
    public void comentarIniciativas(int usuario_id, int iniciativa_if, String comentarios, Date fecha);
    
    public List<String[]> getEstadisticas() throws ExcepcionServicesBanco;
    
    public List<Comentario> getComentarios(int id) throws ExcepcionServicesBanco;
    
    public List <String[]> getEstadisticasEstado() throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de retornar todas las iniciativas hechas por un proponente
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public List<Iniciativa> buscarIniciativaProponente (int id) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de modificar la descripciion de una iniciativa
     * @param ind
     * @param desripcion
     * @throws ExcepcionServicesBanco 
     */
    public void modificarDescripcion(int ind, String desripcion) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de modificar las palabras clave de una iniciativa
     * @param id
     * @param palabrasClave
     * @throws ExcepcionServicesBanco 
     */
    public void modificarPalabrasClave(int id,String palabrasClave) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de dar un like a una iniciativa
     * @param iniciativa_id
     * @param usuario_id
     * @throws ExcepcionServicesBanco 
     */
    public void likes(int iniciativa_id,int usuario_id) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de consutar los likes de una iniciativa
     * @param iniciativa_id
     * @param usuario_id
     * @throws ExcepcionServicesBanco 
     */
    public void dislikes(int iniciativa_id,int usuario_id) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de consultar si un usuario ya le dio like a una iniciativa
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public String consultarLikes(int id) throws ExcepcionServicesBanco;
    
    /**
     * Este metodo se encarga de quitar el like que le dio un usuario a una iniciativa
     * @param iniciativa
     * @param usuario
     * @return
     * @throws ExcepcionServicesBanco 
     */
    public boolean consultarUsuarioDioLike(int iniciativa,int usuario) throws ExcepcionServicesBanco;
    
    
}
