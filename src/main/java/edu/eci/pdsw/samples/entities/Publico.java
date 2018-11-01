/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;

/**
 *
 * @author 2133561
 */
public class Publico extends Usuario implements Serializable{
    
    public Publico(){}
    public Publico(int id, String nombre, String email, String contrasena) {
        super(id,nombre,email,contrasena);
        setRol("Publico");
    }
}
