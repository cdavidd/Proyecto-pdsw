/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 2133561
 */
public class Iniciativa implements Serializable{

    private int id;
    private String descripcion;
    private String estado;
    private int votos;
    private Date fechaCreacion;
    private Usuario usuario;
    private String area;
    public Iniciativa(){}
    
    
    
}
