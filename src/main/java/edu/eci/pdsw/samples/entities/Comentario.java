package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Comentario implements Serializable {
    
    private int id;
    private Usuario usuario;
    private Iniciativa iniciativa;
    private String comentario;
    private Date Fecha_publicacion;

    public Comentario(){}
    
    /**
     * Este metodo se encarga de la construccion del comentario
     * @param user
     * @param iniciativa
     * @param comentario
     * @param fecha 
     */
    public Comentario(Usuario user, Iniciativa iniciativa, String comentario, Date fecha){
        this.usuario=user;
        this.iniciativa=iniciativa;
        this.comentario=comentario;
        this.Fecha_publicacion=fecha;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario user) {
        this.usuario = user;
    }

    public Iniciativa getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_publicacion() {
        return Fecha_publicacion;
    }

    public void setFecha_publicacion(Date Fecha_publicacion) {
        this.Fecha_publicacion = Fecha_publicacion;
    }
    
}
