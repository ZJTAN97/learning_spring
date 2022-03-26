package com.learnspring.springmvc.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
//@ComponentScans(value= {@ComponentScan("com.learnspring.springmvc.dao")})
public class AppConfig {

    @Autowired
    private Environment environment;
    
    // Customer Session Factory
    @Bean
    public LocalSessionFactoryBean customerSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(customerDataSource());
        sessionFactory.setPackagesToScan(new String[] {
            "com.learnspring.springmvc.entity"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource customerDataSource() {
        DriverManagerDataSource customerDataSource = new DriverManagerDataSource();
        customerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        customerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        customerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        customerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return customerDataSource;
    }
    
    

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(customerSessionFactory().getObject());
        return transactionManager;
    }
 
}