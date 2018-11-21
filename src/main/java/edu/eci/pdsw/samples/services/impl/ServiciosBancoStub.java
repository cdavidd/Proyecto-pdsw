/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.*;


/**
 *
 * @author 2125509
 */
public class ServiciosBancoStub implements ServiciosBanco {

    
    private final Map<String,Usuario> usuarios;
    
    
    public ServiciosBancoStub(){
        usuarios = new HashMap<>();
        //poblar();
    }
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        if (!usuarios.containsKey(u.getEmail())){
            usuarios.put(u.getEmail(), u);
        } else {
            throw new ExcepcionServicesBanco("El cliente con correo "+u.getEmail()+" ya esta registrado.");
        }
    }

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

    @Override
    public List<Usuario> consultarUsuarios() {
        return new LinkedList<>(usuarios.values());
    }

    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) {
        iniciativa.setEstado(tipoEstado);
    }

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

    @Override
    public void cambiarRol(Usuario usuario, String rol) {
    	usuario.setRol(Rol.valueOf(rol));
    }
    
    

    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String titulo) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<Iniciativa> buscarIniciativa(String palabraClave) throws ExcepcionServicesBanco {
            return null;		
    }
    
    @Override
    public List<Iniciativa> getIniciativas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iniciativa consultarIniciativa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void comentarIniciativas(int usuario_id, int iniciativa_if, String comentarios, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(String palabraClave) throws ExcepcionServicesBanco {
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
}