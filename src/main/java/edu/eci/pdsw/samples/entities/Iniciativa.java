package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Iniciativa implements Serializable{

    private int id;
    private String descripcion; //
    private TipoEstado estado;
    private int votos;
    private Date fechaCreacion; //
    private Usuario usuario; //
    private String palabrasClave;
    private ArrayList<Comentario> comentarios;
    
    public Iniciativa(){}
    
    /**
     * Este metodo se encarga de la constrccion de la iniciativa pidiendo como parametro tambien el Usuario
     * @param descripcion
     * @param fecha
     * @param usuario
     * @param palabrasClave 
     */
    public Iniciativa(String descripcion, Date fecha, Usuario usuario, String palabrasClave){
        this.descripcion= descripcion;
        this.fechaCreacion= fecha;
        this.usuario=usuario;
        this.setPalabrasClave(palabrasClave);
    }
    
    /**
     * Este metodo se encarga de la construccion de la iniciativa sin tener en cuenta el Usuario
     * @param descripcion
     * @param fecha
     * @param palabrasClave 
     */
    public Iniciativa(String descripcion, Date fecha, String palabrasClave){
        this.descripcion= descripcion;
        this.fechaCreacion= fecha;
        this.setPalabrasClave(palabrasClave);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Iniciativa{" + "id=" + id + ", palabrasclave=" + palabrasClave  + ", usuario=" + usuario + '}';
    }
	public String getPalabrasClave() {
		return palabrasClave;
	}
	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
    
    
    
}
