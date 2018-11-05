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
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author cdavi_000
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "proponenteBean")
@RequestScoped
public class ProponenteBean {
    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    ServiciosBanco servicioBanco;
    
    public void registrarIniciativa(String descripcion, Date fecha, Usuario usuario, String titulo, String area) throws ExcepcionServicesBanco{
        servicioBanco.registrarIniciativa(descripcion, fecha, usuario, titulo, area);
    }
}
