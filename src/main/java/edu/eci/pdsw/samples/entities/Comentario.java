/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Nicolas
 */
public class Comentario implements Serializable {
    
    private int id;
    private Usuario usuario;
    private Iniciativa iniciativa;
    private String comentario;
    private Date Fecha_publicacion;

    public Comentario(){}
    
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
