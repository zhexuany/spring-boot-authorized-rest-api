package edu.global.sgs.config.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:infrastructure.properties" })
public class InfrastructureConfig {

    @Autowired
    Environment        env;

    @Autowired
    private DataSource dataSource;


    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager());
        return transactionTemplate;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPersistenceUnitName("javaconfigSamplePersistenceUnit");
        em.setPackagesToScan("edu.global.sgs.domain");
        em.setJpaVendorAdapter(jpaVendorAdaper());
        em.setJpaPropertyMap(additionalProperties());
        em.afterPropertiesSet();
        return em.getObject();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdaper() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(env.getProperty("jpa.database", Database.class));
        vendorAdapter.setShowSql(env.getProperty("jpa.showSql", Boolean.class));
        vendorAdapter.setGenerateDdl(env.getProperty("jpa.generateDdl", Boolean.class));
        return vendorAdapter;
    }

    private Map<String, Object> additionalProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.validator.apply_to_ddl", "false");
        properties.put("hibernate.validator.autoregister_listeners", "false");
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
        // Second level cache configuration and so on.
        return properties;
    }


}
