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
    
    private final Map<String,Usuario> usuarios;
    
    
    public ServiciosBancoStub(){
        usuarios = new HashMap<>();
        poblar();
    }
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        if (!usuarios.containsKey(u.getEmail())){
            usuarios.put(u.getEmail(), u);
        } else {
            throw new ExcepcionServicesBanco("El cliente con documento "+u.getEmail()+" ya esta registrado.");
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
    
    private void poblar() {
    	Rol admin = new Administrador(1,"administrador");
    	Usuario user1 = new Usuario(1,"pepo","pepo@mail","12345",admin);
    	Usuario user2 = new Usuario(2,"rafael","rafael@mail","asfd",admin);
    	Usuario user3 = new Usuario(3,"carlos","carlos@mail","contra",admin);
    	Usuario user4 = new Usuario(4,"andres","andres@mail","1asfd",admin);
    	Usuario user5 = new Usuario(5,"diego","diego@mail","asf",admin);
    	
    	usuarios.put("pepo@mail", user1);
    	usuarios.put("rafael@mail", user2);
    	usuarios.put("carlos@mail", user3);
    	usuarios.put("andres@mail", user4);
    	usuarios.put("diego@mail", user5);	
    }   
}