package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.*;


public class ServiciosBancoStub implements ServiciosBanco {

    private final Map<String,Usuario> usuarios;
    
    
    public ServiciosBancoStub(){
        usuarios = new HashMap<>();
        //poblar();
    }
    
    /**
     * Este metodo se encarga de registrar un usuario
     * @param u
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        if (!usuarios.containsKey(u.getEmail())){
            usuarios.put(u.getEmail(), u);
        } else {
            throw new ExcepcionServicesBanco("El cliente con correo "+u.getEmail()+" ya esta registrado.");
        }
    }
    
    /**
     * Este metodo se encarga de retornar un usuario mediante su correo
     * @param correo
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco {
    	  Usuario u=null;
          if(usuarios.containsKey(correo)){
              u=usuarios.get(correo);
              return u;
          }
          else {
              throw new ExcepcionServicesBanco("El cliente con correo "+correo+" no esta registrado."); 
          }    
    }
    
   /* private void poblar() {
    	Usuario user1 = new Usuario (1,"pepo","pepo@mail","12345");
    	Usuario user2 = new Usuario (2,"rafael","rafael@mail","asfd");
    	Usuario user3 = new Usuario (3,"carlos","carlos@mail","contra");
    	Usuario user4 = new Usuario (4,"andres","andres@mail","1asfd");
    	Usuario user5 = new Usuario (5,"diego","diego@mail","asf");
    	
    	usuarios.put("pepo@mail", user1);
    	usuarios.put("rafael@mail", user2);
    	usuarios.put("carlos@mail", user3);
    	usuarios.put("andres@mail", user4);
    	usuarios.put("diego@mail", user5);	
    }   */
    
    /**
     * Este metodo se encarga de retornar todos los usuarios
     * @return 
     */
    @Override
    public List<Usuario> consultarUsuarios() {
        return new LinkedList<>(usuarios.values());
    }
    
    /**
     * Este metodo se encarga de cambiar el estado de una iniciativa
     * @param iniciativa
     * @param tipoEstado 
     */
    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) {
        iniciativa.setEstado(tipoEstado);
    }
    
    /**
     * Este metodo se encarga de retornar los usuarios sin rol
     * @return 
     */
    @Override
    public List<Usuario> consultarUsuariosSinRol() {
        List<Usuario> temp= new LinkedList<>(usuarios.values());
        List<Usuario> res= new ArrayList<Usuario>();
        for(Usuario u: temp){
            if(u.getRol()==null){
                res.add(u);
            }
        }
        return res;
    }
    
    /**
     * Este metodo se encarga cambiar el rol de un usuario
     * @param usuario
     * @param rol 
     */
    @Override
    public void cambiarRol(Usuario usuario, String rol) {
    	usuario.setRol(Rol.valueOf(rol));
    }
    /**
     * Este metodo se encarga de registrar una iniciativa
     * @param descripcion
     * @param fecha
     * @param usuario
     * @param titulo
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String titulo) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de retornar iniciativas mediante su palabra clave
     * @param palabraClave
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Set<Iniciativa> buscarIniciativa(String palabraClave) throws ExcepcionServicesBanco {
            return null;		
    }
    
    @Override
    public List<Iniciativa> getIniciativas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo se encarga de retornar una  iniciativa mediante el id
     * @param id
     * @return 
     */
    @Override
    public Iniciativa consultarIniciativa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de comentar una iniciativa 
     * @param usuario_id
     * @param iniciativa_if
     * @param comentarios
     * @param fecha 
     */
    @Override
    public void comentarIniciativas(int usuario_id, int iniciativa_if, String comentarios, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de retornar iniciativas relacionadas 
     * @param iniciativa
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<String[]> getEstadisticas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> getComentarios(int id) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String[]> getEstadisticasEstado() throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de retornar las iniciativas de un proponente
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public List<Iniciativa> buscarIniciativaProponente(int id) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de modificar la descripccion de una iniciativa
     * @param id
     * @param descripcion
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void modificarDescripcion(int id,String descripcion) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de modificar las palabras clave de una iniciativa
     * @param id
     * @param palabrasclave
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void modificarPalabrasClave(int id,String palabrasclave) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de dar like a una iniciativa
     * @param id
     * @param uid
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void likes(int id, int uid) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de retornar la cantidad de likes de una iniciativa
     * @param id
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public String consultarLikes(int id) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de consultar si un usuario dio like a una iniciativa
     * @param iniciativa
     * @param usuario
     * @return
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public boolean consultarUsuarioDioLike(int iniciativa, int usuario) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Este metodo se encarga de quitar el like de un usuario a una iniciativa
     * @param iniciativa_id
     * @param usuario_id
     * @throws ExcepcionServicesBanco 
     */
    @Override
    public void dislikes(int iniciativa_id, int usuario_id) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}