/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.Administrador;
import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 2125509
 */
public class ServiciosBancoStub implements ServiciosBanco {
    
    private final Map<Integer,Usuario> usuarios;
    
    
    public ServiciosBancoStub(){
        usuarios = new HashMap<>();
        poblar();
    }
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
    	 if (!usuarios.containsKey(u.getId())) {
             usuarios.put(u.getId(), u);
         } else {
             throw new ExcepcionServicesBanco("El cliente con documento "+u+" ya esta registrado.");
  }
    }

    @Override
    public Usuario consultarUsuario(int id) throws ExcepcionServicesBanco {
    	  Usuario u=null;
          if(usuarios.containsKey(id)){
              u=usuarios.get(id);
              return u;
          }
          else {
              throw new ExcepcionServicesBanco("El cliente con documento "+u+" no esta registrado."); 
          }
         
    }
    
    private void poblar() {
    	Rol admin = new Administrador(1,"administrador");
    	Usuario user1 = new Usuario(1,"pepo","pepo@mail","12345",admin);
    	Usuario user2 = new Usuario(2,"rafael","rafael@mail","asfd",admin);
    	Usuario user3 = new Usuario(3,"carlos","carlos@mail","contra",admin);
    	Usuario user4 = new Usuario(4,"andres","andres@mail","1asfd",admin);
    	Usuario user5 = new Usuario(5,"diego","diego@mail","asf",admin);
    	
    	usuarios.put(1, user1);
    	usuarios.put(2, user2);
    	usuarios.put(3, user3);
    	usuarios.put(4, user4);
    	usuarios.put(5, user5);	
    }   
}