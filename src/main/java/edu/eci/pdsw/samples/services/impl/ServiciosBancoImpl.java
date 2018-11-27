package edu.eci.pdsw.samples.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.sampleprj.dao.*;
import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.Rol;
import java.util.ArrayList;
import java.util.Date;

public class ServiciosBancoImpl implements ServiciosBanco{


	
    @Inject
    private AdministradorDAO administradorDAO;

    @Inject 
    private IniciativaDAO iniciativaDAO;
    
    @Inject
    private ProponenteDAO proponenteDao;
    
    @Inject
    private ComentarioDAO comentarioDAO;
    
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionServicesBanco {
        try {
            administradorDAO.registrarUsuario(u);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+u.getEmail());
        }
    }

    @Override
    public Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuario(correo);
        }catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar el usuario "+correo);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco {
        try {
            return administradorDAO.consultarUsuarios();
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios");
        }
    }

    @Override
    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco{
        try {
            iniciativaDAO.cambiarEstado(iniciativa, tipoEstado);
        }
        catch(PersistenceException ex) {
           System.out.println(ex.getMessage());
           throw new ExcepcionServicesBanco("Error al cambiar el estado de la iniciativa");
        }		
    }

    @Override
    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco{
        try {
            return administradorDAO.consultarUsuariosSinRol();
           }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los usuarios sin rol");
        }
    }

    @Override
    public void cambiarRol(Usuario usuario, String rol) throws ExcepcionServicesBanco {
        try{
           administradorDAO.cambiarRol(usuario,rol);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al cambiar el Rol a"+usuario.toString());
        }
    }

    @Override
    public void registrarIniciativa(String descripcion, Date fecha, int usuario, String palabrasclave) throws ExcepcionServicesBanco {
        try{
           proponenteDao.registrarIniciativa(descripcion, fecha, usuario, palabrasclave);
        }catch(PersistenceException ex) {
            throw new ExcepcionServicesBanco("Error al registrar iniciativa ");
        }
    }

    @Override
    public Set<Iniciativa> buscarIniciativa(String palabraClave) throws ExcepcionServicesBanco {
        try{
            return iniciativaDAO.buscarIniciativa(palabraClave);
        }catch(PersistenceException ex) {
        	System.out.println(ex.getMessage());
            throw new ExcepcionServicesBanco("Error al buscar iniciativa con palabra clave "+ palabraClave );
        }
    }
    
    
    @Override
    public Set<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) throws ExcepcionServicesBanco {
        try{
            return iniciativaDAO.buscarIniciativasRelacionadas(iniciativa);
        }catch(PersistenceException ex) {
        	System.out.println(ex.getMessage());
            throw new ExcepcionServicesBanco("Error al buscar iniciativa relacionadas con palabra clave "+ iniciativa.getPalabrasClave() );
        }    
    }

    @Override
    public List<Iniciativa> getIniciativas() {
        try{
            return iniciativaDAO.getIniciativas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Iniciativa consultarIniciativa(int id) {
        try{
            return iniciativaDAO.consultarIniciativa(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void comentarIniciativas(int id_user, int id_iniciativa, String comentario, Date fecha) {
        try{
            iniciativaDAO.comentarIniciativas(id_user,id_iniciativa,comentario,fecha);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<String[]> getEstadisticas() throws ExcepcionServicesBanco  {
        try {
            List<String[]> temp = new ArrayList<String[]>();
            for (String s : iniciativaDAO.getEstadisticas()){
                String[] te = new String[2];
                te=s.split(" ");
                //System.out.println(te[0]+" "+te[1]);
                temp.add(te);
            }
            return temp;
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar las estadisticas por area");
        }
        
    }

    @Override
    public List<Comentario> getComentarios(int id) throws ExcepcionServicesBanco {
        try {
            return comentarioDAO.getComentarios(id);
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar los comentarios");
        }
    }

    @Override
    public List<String[]> getEstadisticasEstado() throws ExcepcionServicesBanco {
        try {
            List<String[]> temp = new ArrayList<String[]>();
            for (String s : iniciativaDAO.getEstadisticasEstado()){
                String[] te = new String[2];
                te=s.split(" ");
                //System.out.println(te[0]+" "+te[1]);
                temp.add(te);
            }
            return temp;
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar las estadisticas por estado");
        }
    }

    @Override
    public List<Iniciativa> buscarIniciativaProponente(int id) throws ExcepcionServicesBanco {
        try {
            return iniciativaDAO.buscarIniciativaProponente(id);
        }
        catch(PersistenceException ex) {
           throw new ExcepcionServicesBanco("Error al consultar Iniciativas del proponente");
        }
    }
}