/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;

/**
 *
 * @author 2133561
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String contraseña;
    private Rol rol;
    private ArrayList<Iniciativa> iniciativas;
    private ArrayList<Iniciativa> apoyar;
    
    public Usuario (){
    }
    
}
