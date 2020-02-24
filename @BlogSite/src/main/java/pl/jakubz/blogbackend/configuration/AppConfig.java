package pl.jakubz.blogbackend.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan("pl.jakubz.blogbackend")
@PropertySource({"classpath:configuration.properties"})
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    //Creating ENV to store the properties in
    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    //Defining ViewResolver
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource myDataSource()
    {
        //Create connection pool
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();

        //Set JDBC Driver
        try {
            myDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        //connection props
        myDataSource.setUser(environment.getProperty("jdbc.user"));
        myDataSource.setPassword(environment.getProperty("jdbc.password"));
        myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));



        //set database conection properties
        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

        return myDataSource;

    }


    private Properties getHibernateProperties()
    {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));

        return properties;
    }

    private int getIntProperty(String propName) {

        String propVal = environment.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactoryBean()
    {
        //Create session factory
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        //set the properties
        sessionFactoryBean.setDataSource(myDataSource());
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        sessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));

        return sessionFactoryBean;
    }
    //Need to create hibernateTransactionManager for transactional

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory);

        return manager;
    }
}
