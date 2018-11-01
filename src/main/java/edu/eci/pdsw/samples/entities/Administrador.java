package edu.eci.pdsw.samples.entities;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable{

    
    public Administrador(){
    }
    
    public Administrador(int id, String nombre, String email, String contrasena) {
            super(id,nombre,email,contrasena);
    }

    public String getRol() {
        return "Administrado";
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
	
}
