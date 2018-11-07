package edu.eci.pdsw.samples.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISIniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISAdministradorDAO;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;
import edu.eci.pdsw.sampleprj.dao.AdministradorDAO;
import edu.eci.pdsw.sampleprj.dao.ProponenteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISProponenteDAO;

public class ServiciosBancoFactory {

	private static ServiciosBancoFactory instance = new ServiciosBancoFactory();
	private static Injector injector;
	private static Injector testInjector;
	
	public ServiciosBancoFactory() {
		
		injector = createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("my-batis-config.xml");
                    bind(ProponenteDAO.class).to(MyBATISProponenteDAO.class);
	            bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
	            bind(AdministradorDAO.class).to(MyBATISAdministradorDAO.class);
	            bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
			}
		});
		
		testInjector = createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("my-batis-config-h2.xml");
                                bind(ProponenteDAO.class).to(MyBATISProponenteDAO.class);
				bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
				bind(AdministradorDAO.class).to(MyBATISAdministradorDAO.class);
				bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
			}
		});
	}
	
	public ServiciosBanco getServiciosBanco() {
		return injector.getInstance(ServiciosBanco.class);
	}
	
	public ServiciosBanco getServiciosBancoTesting() {
		return testInjector.getInstance(ServiciosBanco.class);
	}
	public static ServiciosBancoFactory getInstance() {
		return instance;
	}	
}