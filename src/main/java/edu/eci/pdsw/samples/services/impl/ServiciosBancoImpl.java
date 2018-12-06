package edu.eci.pdsw.samples.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.sampleprj.dao.*;
import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Rol;
import java.util.ArrayList;
import java.util.Date;

public class ServiciosBancoImpl implements ServiciosBanco{

    @Inject
    private AdministradorDAO administradorDAO;

    @Inject 
    private IniciativaDAO iniciativaDAO;
    
    @Inject
    private ProponenteDAO proponenteDao;
    
    @Inject
    private ComentarioDAO comentarioDAO;
    
    /**
     * Este metodo se encarga de registrar un usuario 
     * @param u
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        try {
            administradorDAO.registrarUsuario(u);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+u.getEmail());
        }
    }
    
    /**
     * Este metodo se encarga de retornar un usuario mediante la consulta de su correo
     * @param correo
     * @return Usuario
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuario(correo);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+correo);
        }
    }
    
    /**
     * Este metodo se encarga de retornar todos los usuarios
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuarios();
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios");
        }
    }
    
    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa
     * @param iniciativa
     * @param tipoEstado
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco{
        try {
            iniciativaDAO.cambiarEstado(iniciativa, tipoEstado);
        }
        catch(PersistenceException ex) {
           System.out.println(ex.getMessage());
           throw new ExcepcionServicesBanco("Error al cambiar el estado de la iniciativa");
        }		
    }
    
    /**
     * Este metodo se encarga de retornar los usuarios que esten sin rol
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
        try {
            return administradorDAO.consultarUsuariosSinRol();
           }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios sin rol");
        }
    }
    
    /**
     * Este metodo se encarga de cambiar el rol de un usuario
     * @param usuario
     * @param rol
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void cambiarRol(Usuario usuario, String rol) throws ExcepcionServicesBanco {
        try{
           administradorDAO.cambiarRol(usuario,rol);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al cambiar el Rol a"+usuario.toString());
        }
    }
    
    /**
     * Este metodo se encarga de registrar una iniciativa
     * @param descripcion
     * @param fecha
     * @param usuario
     * @param palabrasclave
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws ExcepcionServicesBanco {
        try{
           proponenteDao.registrarIniciativa(descripcion, fecha, usuario, palabrasclave);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al registrar iniciativa ");
        }
    }
    
    /**
     * Este metodo se encarga de retornar iniciativas mediante la busqueda de la palabra clave
     * @param palabraClave
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Set<Iniciativa> buscarIniciativa(String palabraClave) throws ExcepcionServicesBanco {
        try{
            return iniciativaDAO.buscarIniciativa(palabraClave);
        }catch(PersistenceException ex) {
        	System.out.println(ex.getMessage());
            throw new ExcepcionServicesBanco("Error al buscar iniciativa con palabra clave "+ palabraClave );
        }
    }
    
    /**
     * Este metodo se encarga de retornar iniciativas relacionadas
     * @param iniciativa
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws ExcepcionServicesBanco {
        try{
            return iniciativaDAO.buscarIniciativasRelacionadas(iniciativa);
        }catch(PersistenceException ex) {
        	System.out.println(ex.getMessage());
            throw new ExcepcionServicesBanco("Error al buscar iniciativa relacionadas con palabra clave "+ iniciativa.getPalabrasClave() );
        }    
    }
    
    @Override
    public List<Iniciativa> getIniciativas() {
        try{
            return iniciativaDAO.getIniciativas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Este metodo se encarga de retornar una iniciativa mediante su id
     * @param id
     * @return 
     */
    @Override
    public Iniciativa consultarIniciativa(int id) {
        try{
            return iniciativaDAO.consultarIniciativa(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Este metodo se encarga de insertar un comentario a una iniciativa
     * @param id_user
     * @param id_iniciativa
     * @param comentario
     * @param fecha 
     */
    @Override
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha) {
        try{
            iniciativaDAO.comentarIniciativas(id_user,id_iniciativa,comentario,fecha);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<String[]> getEstadisticas() throws ExcepcionServicesBanco  {
        try {
            List<String[]> temp = new ArrayList<String[]>();
            for (String s : iniciativaDAO.getEstadisticas()){
                String[] te = new String[2];
                te=s.split(" ");
                temp.add(te);
            }
            return temp;
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar las estadisticas por area");
        }
        
    }

    @Override
    public List<Comentario> getComentarios(int id) throws ExcepcionServicesBanco {
        try {
            return comentarioDAO.getComentarios(id);
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los comentarios");
        }
    }

    @Override
    public List<String[]> getEstadisticasEstado() throws ExcepcionServicesBanco {
        try {
            List<String[]> temp = new ArrayList<String[]>();
            for (String s : iniciativaDAO.getEstadisticasEstado()){
                String[] te = new String[2];
                te=s.split(" ");
                temp.add(te);
            }
            return temp;
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar las estadisticas por estado");
        }
    }
    
    /**
     * Este metodo se encarga de retornar todas las iniciativas hechas por un proponente
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public List<Iniciativa> buscarIniciativaProponente(int id) throws ExcepcionServicesBanco {
        try {
            return iniciativaDAO.buscarIniciativaProponente(id);
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar Iniciativas del proponente");
        }
    }
    
    /**
     * Este metodo se encarga de modificar la descripciion de una iniciativa
     * @param id
     * @param descripcion
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void modificarDescripcion(int id, String descripcion) throws ExcepcionServicesBanco {
        try {
            if (!consultarIniciativa(id).getEstado().toString().equals(TipoEstado.En_Espera_Revision.toString())){
                throw new ExcepcionServicesBanco("Solo se pueden modificar iniciativas que este en espera de revision");
            }
            iniciativaDAO.modificarDescripcion(id,descripcion);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al modificar la descripcion de la iniciativa");        
        }
    }
    
    /**
     * Este metodo se encarga de modificar las palabras clave de una iniciativa
     * @param id
     * @param palabrasclave
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void modificarPalabrasClave(int id,String palabrasclave) throws ExcepcionServicesBanco {
        try {
            if (!consultarIniciativa(id).getEstado().toString().equals(TipoEstado.En_Espera_Revision.toString())){
                throw new ExcepcionServicesBanco("Solo se pueden modificar iniciativas que este en espera de revision");
            }
            iniciativaDAO.modificarPalabrasClave(id,palabrasclave);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al modificar las palabras clave de la iniciativa");        
        }    
    }
    
    /**
     * Este metodo se encarga de dar un like a una iniciativa
     * @param iniciativa_id
     * @param usuario_id
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void likes(int iniciativa_id,int usuario_id) throws ExcepcionServicesBanco {
        try {
            iniciativaDAO.darLike(iniciativa_id,usuario_id);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al dar like");        
        }       
    }
    
    /**
     * Este metodo se encarga de consutar los likes de una iniciativa
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public String consultarLikes(int id) throws ExcepcionServicesBanco {
         try {
            return iniciativaDAO.consultarLikes(id);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al consultar los likes");        
        }     
    }
    
    /**
     * Este metodo se encarga de consultar si un usuario ya le dio like a una iniciativa
     * @param iniciativa
     * @param usuario
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public boolean consultarUsuarioDioLike(int iniciativa, int usuario) throws ExcepcionServicesBanco {
        try {
            return iniciativaDAO.consultarUsuarioDioLike(iniciativa,usuario);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al consultar si el usuario de dio like");        
        }   
    }
    
    /**
     * Este metodo se encarga de quitar el like que le dio un usuario a una iniciativa
     * @param iniciativa_id
     * @param usuario_id
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void dislikes(int iniciativa_id, int usuario_id) throws ExcepcionServicesBanco {
        try {
            iniciativaDAO.dislikes(iniciativa_id,usuario_id);
        }
        catch(PersistenceException ex){
           throw new ExcepcionServicesBanco("Error al dar dislike");        
        }      
    }
}