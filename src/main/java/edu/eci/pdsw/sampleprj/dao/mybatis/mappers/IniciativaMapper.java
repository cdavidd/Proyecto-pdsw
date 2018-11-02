package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;

public interface IniciativaMapper {

	public void cambiarEstado(@Param("iniciativa")Iniciativa iniciativa, @Param("estado")TipoEstado tipoEstado);
		
}