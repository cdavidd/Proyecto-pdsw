package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;

import java.time.LocalDate;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "proponenteBean")
@RequestScoped
public class ProponenteBean extends BasePageBean{
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value = "#{param.usuarioId}")

    private int usuarioId;
    private String descripcion,palabrasClave,area;
    private Date fecha;
    
    
    /**
     * Este metodo se encarga de registrar una nueva iniciativa.
     * @param descripcion Es la descripcion de la nueva iniciativa.
     * @param palabrasClave Son las palabras clave de la nueva iniciativa.
     * @throws ExcepcionServicesBanco 
     */
    public void registrarIniciativa(String descripcion,String palabrasClave) throws ExcepcionServicesBanco{
        super.nuevaIniciativa=true;
        servicioBanco.registrarIniciativa(descripcion,java.sql.Date.valueOf(LocalDate.now()), usuarioId, palabrasClave);
    }

    public ServiciosBanco getServicioBanco() {
        return servicioBanco;
    }

    public void setServicioBanco(ServiciosBanco servicioBanco) {
        this.servicioBanco = servicioBanco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
