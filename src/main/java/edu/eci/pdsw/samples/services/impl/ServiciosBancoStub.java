/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.Administrador;
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
    
    private void poblar() {
    	Usuario user1 = new Administrador (1,"pepo","pepo@mail","12345");
    	Usuario user2 = new Administrador (2,"rafael","rafael@mail","asfd");
    	Usuario user3 = new Administrador (3,"carlos","carlos@mail","contra");
    	Usuario user4 = new Administrador (4,"andres","andres@mail","1asfd");
    	Usuario user5 = new Administrador (5,"diego","diego@mail","asf");
    	
    	usuarios.put("pepo@mail", user1);
    	usuarios.put("rafael@mail", user2);
    	usuarios.put("carlos@mail", user3);
    	usuarios.put("andres@mail", user4);
    	usuarios.put("diego@mail", user5);	
    }   
}