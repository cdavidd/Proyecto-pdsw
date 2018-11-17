package edu.eci.pdsw.tests;

import org.junit.Before;
import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.*;
import edu.eci.pdsw.sampleprj.dao.mybatis.*;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;



public class TestBase {
    protected Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("test");
                setClassPathResource("mybatis-config-h2.xml");                      
                bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
                bind(AdministradorDAO.class).to(MyBATISAdministradorDAO.class);
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                bind(ProponenteDAO.class).to(MyBATISProponenteDAO.class); 
            }
    });
    
    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}