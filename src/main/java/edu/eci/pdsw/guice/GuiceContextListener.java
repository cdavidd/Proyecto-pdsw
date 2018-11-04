/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.guice;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISIniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISAdministradorDAO;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import edu.eci.pdsw.sampleprj.dao.AdministradorDAO;

/**
 *
 * @author cdavi_000
 */
public class GuiceContextListener implements ServletContextListener{
     public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
	            bind(AdministradorDAO.class).to(MyBATISAdministradorDAO.class);
	            bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
            }   
       });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}