package pl.jakubz.simplehouse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource appDataSource()
    {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "security.datasource")
    public DataSource securityDataSource(){
        return DataSourceBuilder.create().build();
    }

}
