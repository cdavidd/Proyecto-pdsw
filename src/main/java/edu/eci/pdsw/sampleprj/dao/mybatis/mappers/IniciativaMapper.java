package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import java.util.ArrayList;

public interface IniciativaMapper {

	public void cambiarEstado(@Param("id")int id, @Param("estado")TipoEstado tipoEstado);

	public List<Iniciativa> buscarIniciativa(@Param("palabra")String palabraClave);
        
        public List<Iniciativa> getIniciativas();
        
        public Iniciativa consultarIniciativa(@Param("id")int id);
		
}