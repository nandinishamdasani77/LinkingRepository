package com.nandini.javaprojectbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.nandini.javabackendproject" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String database_URL = "jdbc:h2:tcp://localhost/~/test";
	private final static String database_DRIVER = "org.h2.Driver";
	private final static String database_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String database_USERNAME = "sa";
	private final static String database_PASSWORD = "";

	// datasource bean will be available
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();

		// providing database connection information
		datasource.setDriverClassName(database_DRIVER);
		datasource.setUrl(database_URL);
		datasource.setUsername(database_USERNAME);
		datasource.setPassword(database_PASSWORD);

		return datasource;
	}
	
	//sessionfactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.nandini.javaprojectbackend.Model");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", database_DIALECT);
		properties.put("hibernate.show_sql",true);
		properties.put("hibernate.format_sql",true);
		
		return properties;
	}
//transactionmanager bean to manage the transactions	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionfactory);
		return transactionManager;
	}
}
