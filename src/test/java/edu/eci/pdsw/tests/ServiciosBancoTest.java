package edu.eci.pdsw.tests;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.ServiciosBancoFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

public class ServiciosBancoTest {

    @Inject
    private SqlSession sqlSession; 
    ServiciosBanco serviciosBanco;

    public ServiciosBancoTest() {
        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBancoTesting();
    }

    @Before
    public void setUp() {
    }
/*
    @Test
    public void emptyDB() {
        qt().forAll(longs().from(1).upTo(1000)).check((documento) -> {
            boolean r = true;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(documento);
            } catch(ExcepcionServiciosAlquiler e) {
                r = false;
            } catch(IndexOutOfBoundsException e) {
                r = false;
            }
            return r;
        });
    }
  
    @Test
    public void insertarconsultarcliente() {
    	 qt().forAll(ClientGenerator.Clientes())
    	 .check(cliente -> {
    		 try {
    			 serviciosAlquiler.registrarCliente(cliente);
    			 return serviciosAlquiler.consultarClientes().contains(cliente);
    			 }
    		 catch(ExcepcionServiciosAlquiler e) {
    			 return true;
    		 }
    		 catch(Exception ex) {
    			 ex.printStackTrace();
                 return false; 
    		 }	  
    	 });
    }
    
    @Test
    public void insertarconsultaritem() {
    	 qt().forAll(ItemGenerator.Items())
    	 .check(item -> {
    		 try {
    			 serviciosAlquiler.registrarItem(item);
    			 return serviciosAlquiler.consultarItemsDisponibles().contains(item);
    			 }
    		 catch(ExcepcionServiciosAlquiler e) {
    			 return true;
    		 }
    		 catch(Exception ex) {
    			 ex.printStackTrace();
                 return false; 
    		 }	  
    	 });
    }
*/    
    
  
}
