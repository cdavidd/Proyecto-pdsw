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
    
    private int id,usuario_id,iniciativas_id;
    private String comentario;
    private Date Fecha_publicacion;

    public Comentario(){}
    
    public Comentario(int user, int iniciativa, String comentario, Date fecha){
        this.usuario_id=user;
        this.iniciativas_id=iniciativa;
        this.comentario=comentario;
        this.Fecha_publicacion=fecha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getIniciativas_id() {
        return iniciativas_id;
    }

    public void setIniciativas_id(int iniciativas_id) {
        this.iniciativas_id = iniciativas_id;
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
