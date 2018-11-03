/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 2133561
 */
public class Usuario implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nombre;
    private String email;
    private String contrasena;
    public String rol=null;
    private ArrayList<Iniciativa> iniciativas;
    private ArrayList<Iniciativa> apoyar;
    
    public Usuario(){
    }
    
    public Usuario(int id, String nombre, String email, String contrasena, String rol) {
    	this.id = id;
    	this.nombre = nombre;
    	this.email = email; 
    	this.contrasena = contrasena;
    	this.rol = rol;
    	this.iniciativas = new ArrayList<Iniciativa>();
    	this.apoyar = new ArrayList<Iniciativa>();
    }
    
    public Usuario(int id, String nombre, String email, String contrasena) {
    	this.id = id;
    	this.nombre = nombre;
    	this.email = email; 
    	this.contrasena = contrasena;
    	this.iniciativas = new ArrayList<Iniciativa>();
    	this.apoyar = new ArrayList<Iniciativa>();
    }

    public Usuario(int id, String nombre, String email, String contrasena,String rol, ArrayList<Iniciativa> iniciativas,ArrayList<Iniciativa> apoyar) {
    	this.id = id;
    	this.nombre = nombre;
    	this.email = email; 
    	this.contrasena = contrasena;
    	this.rol = rol;
    	this.iniciativas = iniciativas;
    	this.apoyar = apoyar;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(ArrayList<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public ArrayList<Iniciativa> getApoyar() {
        return apoyar;
    }

    public void setApoyar(ArrayList<Iniciativa> apoyar) {
        this.apoyar = apoyar;
    }
    
    @Override
    public String toString() {
            return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contrasena=" + contrasena + ", rol="
                            + rol + ", iniciativas=" + iniciativas + ", apoyar=" + apoyar + "]";
    }

    public String getRol() {
            return rol;
    }

    public void setRol(String rol) {
            this.rol = rol;
    }
    
}
