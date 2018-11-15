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
    private List<Iniciativa> iniciativas=new ArrayList<Iniciativa>();
    
   
    public List<Iniciativa> getIniciativas(){
        try{
            
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa){
                super.nuevaIniciativa=false;
                temp.addAll(servicioBanco.getIniciativas());
                iniciativas= temp;
           }
           //System.out.println(iniciativas.toString());
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
    
    public List<Iniciativa> buscarIniciativas(String palabraClave) {
            
        try {
           
            List<Iniciativa> temp=new ArrayList<Iniciativa>();
            if (iniciativas.isEmpty() || super.nuevaIniciativa || !palabraTemp.equals(this.palabraC) ){
                palabraTemp = palabraClave;
                super.nuevaIniciativa=false;
                temp.addAll(servicioBanco.buscarIniciativa(palabraC));
                iniciativas= temp;
            }
             //System.out.println(iniciativas.toString());
             //System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

            return iniciativas;
        }
        catch (ExcepcionServicesBanco e) {
            return null;
        }    	
    }

    public String getRol() {
            return rol;
    }

    public void setRol(String rol) {
            this.rol = rol;
    }
    


}