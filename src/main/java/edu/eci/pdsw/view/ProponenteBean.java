/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author cdavi_000
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "proponenteBean")
@RequestScoped
public class ProponenteBean extends BasePageBean{
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    ServiciosBanco servicioBanco;
    
    @ManagedProperty(value = "#{param.usuarioEmail}")

    
    String descripcion,titulo,area;
    Date fecha;
    int usuarioId;
    
    
    public void registrarIniciativa(String descripcion,   String titulo, String area) throws ExcepcionServicesBanco{
        System.out.println("asaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(usuarioId);
        System.out.println(descripcion);
        System.out.println(titulo);
        System.out.println(area);
        
        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println(fecha);
        System.out.println(servicioBanco.getClass().getName());
        servicioBanco.registrarIniciativa(descripcion, fecha, usuarioId, titulo, area);
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
