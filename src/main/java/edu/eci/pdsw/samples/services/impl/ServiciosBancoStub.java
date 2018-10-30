/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

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
    }
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarUsuario(int id) throws ExcepcionServicesBanco {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
