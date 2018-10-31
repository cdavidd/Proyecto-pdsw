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
    	iniciativas = new ArrayList<Iniciativa>();
    	apoyar = new ArrayList<Iniciativa>();
    }
    
    public Usuario(int id, String nombre, String email, String contraseña, Rol rol) {
    	this.id = id;
    	this.nombre = nombre;
    	this.email = email; 
    	this.contraseña = contraseña;
    	this.rol = rol;
    	iniciativas = new ArrayList<Iniciativa>();
    	apoyar = new ArrayList<Iniciativa>();
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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
    
}
