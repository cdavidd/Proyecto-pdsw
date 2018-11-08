package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    
    @Inject
    ServiciosBanco servicioBanco;
    
    
    private String rol;
    private String descripcion,area;
    private String palabraC;
    private TipoEstado estado;
    private Date fecha;
    
   
    public List<Iniciativa> getIniciativas(){
        try{
            System.out.println(palabraC);
            return servicioBanco.getIniciativas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
    
    public void setDescripcion(String d){
        this.descripcion=d;
    }
    
    public void setArea(String a){
        this.area=a;
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
    
    public String getArea(){
        return area;
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
    
    public Set<Iniciativa> buscarIniciativas(String palabraClave) throws ExcepcionServicesBanco{
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("");
        System.out.println(palabraC);
        System.out.println("");
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    	return servicioBanco.buscarIniciativa(palabraClave.toLowerCase());
    }

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}