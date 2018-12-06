package edu.eci.pdsw.samples.entities;
import java.io.Serializable;
import java.util.ArrayList;

public  class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String email;
    private String contrasena;
    private String area;
    public Rol rol;
    private ArrayList<Iniciativa> iniciativas;
    private ArrayList<Iniciativa> apoyar;
    private ArrayList<Integer> likes = new ArrayList<Integer>();

    public Usuario(){
    }
    
    /**
     * Este metodo se encarga de la construccion del Usuario pidiendo
     * @param id
     * @param nombre
     * @param email
     * @param contrasena
     * @param rol
     * @param area 
     */
    public Usuario(int id, String nombre, String email, String contrasena, String rol,String area) {
    	this.id = id;
    	this.nombre = nombre;
    	this.email = email; 
    	this.contrasena = contrasena;
    	this.rol = Rol.valueOf(rol);
        this.area = area;
    	this.iniciativas = new ArrayList<Iniciativa>();
    	this.apoyar = new ArrayList<Iniciativa>();
    }
    
    /**
     * Este metodo se encarga de la construccion del Usuario pidiendo
     * @param nombre
     * @param email
     * @param contrasena
     * @param area 
     */
    public Usuario(String nombre, String email, String contrasena,String area) {
    	this.nombre = nombre;
    	this.email = email; 
    	this.contrasena = contrasena;
        this.area = area;
    	this.iniciativas = new ArrayList<Iniciativa>();
    	this.apoyar = new ArrayList<Iniciativa>();
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
                            + rol + ", iniciativas=" + iniciativas + ", apoyar=" + apoyar +  ", area=" + area +"]";
    }

    public Rol getRol() {
            return rol;
    }

    public void setRol(Rol rol) {
            this.rol = rol;
    }
    
     public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public ArrayList<Integer> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Integer> likes) {
        this.likes = likes;
    }
}
