package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrador extends Usuario implements Serializable{

    
    public Administrador(){
    }
    
    public Administrador(int id, String nombre, String email, String contrasena) {
            super(id,nombre,email,contrasena);
            setRol("Administrador");
    }

}
