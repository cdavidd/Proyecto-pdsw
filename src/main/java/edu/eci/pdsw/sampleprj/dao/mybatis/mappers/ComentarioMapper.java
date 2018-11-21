/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Comentario;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ComentarioMapper {
	public List<Comentario> getComentarios (@Param("Id_Iniciativa")int id);

}