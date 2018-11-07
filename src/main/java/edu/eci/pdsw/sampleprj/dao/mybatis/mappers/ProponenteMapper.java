/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author cdavi_000
 */
public interface ProponenteMapper {
    public void registrarIniciativa(@Param("descripcion")String descripcion,@Param("fecha") Date fecha,@Param("usuario") int usuario,@Param("titulo") String titulo,@Param("area") String area);
}
