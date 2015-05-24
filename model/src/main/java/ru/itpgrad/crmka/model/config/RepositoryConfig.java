package ru.itpgrad.crmka.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Spring java based configuration for persistence layer
 *
 * @author maslowis
 */
@Configuration
@PropertySource("classpath:datasource.properties")
@ComponentScan("ru.itpgrad.crmka.model.entity")
@EnableJpaRepositories("ru.itpgrad.crmka.model.repository")
//@EnableTransactionManagement
public class RepositoryConfig {
    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";

    @Resource
    private Environment env;

    /**
     * This returns the hibernate properties that to specify in db.properties file
     *
     * @return the hibernate properties
     */
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
        return properties;
    }

    /**
     * Initialize the DataSource
     *
     * @return {@link javax.sql.DataSource}
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
        return dataSource;
    }

    /**
     * Initialize the EntityManagerFactory. As the vendor adapter set {@link org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter}.
     *
     * @return {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean}
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

//    /**
//     * Initialize the TransactionManager
//     *
//     * @return {@link org.springframework.orm.jpa.JpaTransactionManager}
//     */
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return txManager;
//    }

    /**
     * Initialize the ExceptionTranslation
     *
     * @return {@link org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor}
     */
    @Bean(name = "exceptionTranslation")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
