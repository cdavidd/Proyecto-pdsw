package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import java.util.ArrayList;
import java.util.Date;

public interface IniciativaMapper {

	public void cambiarEstado(@Param("id")int id, @Param("estado")TipoEstado tipoEstado);

	public List<Iniciativa> buscarIniciativa(@Param("palabra")String palabraClave);
        
        public List<Iniciativa> buscarIniciativasRelacionadas(@Param("palabra")String palabraClave);
        
        public List<Iniciativa> getIniciativas();
        
        public Iniciativa consultarIniciativa(@Param("id")int id);
        
        public void registrarIniciativa(@Param("descripcion")String descripcion,@Param("fecha") Date fecha,@Param("usuario") int usuario,@Param("palabrasclave") String palabrasclave);
		
        public void comentarIniciativas(@Param("usuario_id")int usuario_id,@Param("iniciativa_id")int iniciativa_id,@Param("comentario")String comentario,@Param("fecha_publicacion")Date fecha_publicacion);

}