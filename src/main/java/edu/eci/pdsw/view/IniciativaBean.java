package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import org.javatuples.Pair; 


@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean implements Serializable{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    
    @Inject
    ServiciosBanco servicioBanco;
    
    
    private String rol;
    private String descripcion;
    private String palabraC = "";
    private TipoEstado estado;
    private Date fecha;
    private String palabraTemp = "";
    private Integer likes = 0;
    private HashMap<Integer, Integer> maplikes = new HashMap<>(); 
    private boolean nuevosLikes = false;
    private List<Iniciativa> iniciativas=new ArrayList<Iniciativa>();
    private HashMap<String, Boolean> mapliked = new HashMap<>(); 
    
    
    public List<Iniciativa> getIniciativas(){
        try{            
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa || super.cambioPagina){
                super.nuevaIniciativa=false;
                cambioPagina = false;
                temp.addAll(servicioBanco.getIniciativas());
                iniciativas= temp;
           }
           return iniciativas;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }    
    }

    /**
     * Este metodo se encarga de retornar un bool verificando que hay like o no.
     * @return Retorna True o False.
     */
    public boolean isnuevosLikes() {
        return nuevosLikes;
    }

    public void setNuevosLikes(boolean anadenLikes) {
        this.nuevosLikes = anadenLikes;
    }
    
    /**
     * Este metodo se encarga de buscar las iniciativas por un proponente dado.
     * @param id Es el id del proponente.
     * @return  Retorna la lista de iniciativas que realizó.
     */
    public List<Iniciativa> buscarIniciativaProponente(int id) {
        try{
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa || super.cambioPagina){
                super.nuevaIniciativa=false;
                cambioPagina = false;
                temp.addAll(servicioBanco.buscarIniciativaProponente(id));
                iniciativas= temp;
           }
            return iniciativas;
         }catch(Exception ex){
             System.out.println(ex.getMessage());
             return null;
         }
    }
    
    public void setDescripcion(String d){
        this.descripcion=d;
    }
    
    
    public void setEstado(TipoEstado e){
        this.estado=e;
    }
    
    public void setFecha(Date f){
        this.fecha=f;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    
    public TipoEstado getEstado(){
        return estado;
    }
    
    public Date getFecha(){
        return fecha;
    }

    public String getPalabraC() {
        return palabraC;
    }

    public void setPalabraC(String palabraC) {
        this.palabraC = palabraC;
    }
    
    /**
     * Este metodo se encarga de buscar las iniciativas por palabras clave.
     * @param palabraClave Son las palabras clave a buscar.
     * @return Retorna las iniciativas.
     */
    public List<Iniciativa> buscarIniciativas(String palabraClave) {
            
        try {  
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa || !palabraTemp.equals(this.palabraC) || super.cambioPagina){
                palabraTemp = palabraClave;
                super.nuevaIniciativa=false;
                super.cambioPagina = false;
                temp.addAll(servicioBanco.buscarIniciativa(palabraClave));
                iniciativas= temp;
            }
            return iniciativas;
        }
        catch (ExcepcionServicesBanco e) {
            return null;
        }    	
    }
    
    /**
     * Este metodo se encarga de buscar iniciativas relacionadas a otra.
     * @param iniciativa Es la iniciativa principal.
     * @return Retorna una lista de iniciativas relacionadas.
     */
    public List<Iniciativa> buscarIniciativasRelacionadas(Iniciativa iniciativa) {
            
        try {
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa || super.cambioPagina){
                super.nuevaIniciativa=false;
                super.cambioPagina=false;
                temp.addAll(servicioBanco.buscarIniciativasRelacionadas(iniciativa));
                iniciativas= temp;
            }
            return iniciativas;
        }
        catch (ExcepcionServicesBanco e) {
            return null;
        }    	
    }
    
    /**
     * Este metodo se encarga de verificar los likes y registrarlos.
     * @param iniciativa_id Es la iniciativa a la cual se le dio like.
     * @param usuario Es el usuario que le dio like.
     * @param like Es el bool dependiendo si es like o dislike.
     */
    public void likes(int iniciativa_id,Usuario usuario,boolean like){
        try{
            mapliked.replace(Integer.toString(iniciativa_id) +  "_" + Integer.toString(usuario.getId()),like);
            if (like){
                servicioBanco.likes(iniciativa_id,usuario.getId());
                maplikes.replace(iniciativa_id, maplikes.get(iniciativa_id)+1);
            }
            else {
                servicioBanco.dislikes(iniciativa_id,usuario.getId());
                maplikes.replace(iniciativa_id, maplikes.get(iniciativa_id)-1);
            }
        }
        catch (ExcepcionServicesBanco e) {
            System.out.println(e.getMessage());
        } 
    }
    
    /**
     * Este metodo se encarga de consultar los likes de una iniciativa.
     * @param iniciativa Es la iniciativa a consultar.
     * @return Retorna el numero de likes.
     */
    public Integer consultarLikes(int iniciativa){
        try{
            if (!maplikes.containsKey(iniciativa)){
                likes = Integer.parseInt(servicioBanco.consultarLikes(iniciativa)); 
                maplikes.put(iniciativa, likes);
                return likes;
            }
            else return maplikes.get(iniciativa);
        }
        catch (ExcepcionServicesBanco e) {
            return 0;
        }
    }
    
    /**
     * Este metodo se encarga de relacionar el usuario que dio like y la iniciativa.
     * @param iniciativa Es la iniciativa que se le dio like.
     * @param usuario Es el usuario que dio like.
     * @return Retorna un bool.
     * @throws ExcepcionServicesBanco 
     */
    public boolean estadoLike(int iniciativa, Usuario usuario) throws ExcepcionServicesBanco{
        String cadena = Integer.toString(iniciativa) + "_" +  Integer.toString(usuario.getId());
        if (mapliked.containsKey(cadena)){
            return mapliked.get(cadena);
        }
        else {
            boolean dioLike = servicioBanco.consultarUsuarioDioLike(iniciativa,usuario.getId());
            mapliked.put(cadena, dioLike);
            return mapliked.get(cadena);
        }
    }

    public String getRol() {
            return rol;
    }

    public void setRol(String rol) {
            this.rol = rol;
    }
    
    public void cambioPagina(){
        cambioPagina=true;
    }
    
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}