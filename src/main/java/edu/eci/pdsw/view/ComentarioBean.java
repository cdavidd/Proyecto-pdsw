package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Comentario;

import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 2133561
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "comentarioBean")
@RequestScoped
public class ComentarioBean extends BasePageBean{

    
    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value="#{param.id}")

    private int id;
    private Date fecha_publicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
    public List<Comentario> getComentarios() throws ExcepcionServicesBanco{
        return servicioBanco.getComentarios(id);
    }
    
}
