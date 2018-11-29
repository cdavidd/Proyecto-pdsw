/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 2125509
 */
public interface ServiciosBanco {
    
    public abstract void registrarUsuario(Usuario u) throws ExcepcionServicesBanco;
    
    public abstract Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco;

    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco;

    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco;

    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco;

    public void cambiarRol(Usuario usuario, String rol) throws ExcepcionServicesBanco;
    
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws ExcepcionServicesBanco;
    
    public abstract Set<Iniciativa> buscarIniciativa(String palabraClave)throws ExcepcionServicesBanco;

    public abstract Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa)throws ExcepcionServicesBanco;

    public List<Iniciativa> getIniciativas();
        
    public Iniciativa consultarIniciativa(int id);
    
    public void comentarIniciativas(int usuario_id, int iniciativa_if, String comentarios, Date fecha);

    public List<String[]> getEstadisticas() throws ExcepcionServicesBanco;
    
    public List<Comentario> getComentarios(int id) throws ExcepcionServicesBanco;
    
    public List <String[]> getEstadisticasEstado() throws ExcepcionServicesBanco;
    
    public List<Iniciativa> buscarIniciativaProponente (int id) throws ExcepcionServicesBanco;
    
    public void modificarDescripcion(int ind, String desripcion) throws ExcepcionServicesBanco;
    
    public void modificarPalabrasClave(int id,String palabrasClave) throws ExcepcionServicesBanco;
    
    public void likes(int iniciativa_id,int usuario_id) throws ExcepcionServicesBanco;
    
    public String consultarLikes(int id) throws ExcepcionServicesBanco;
}
