

package pl.jakubz.simplehouse.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;


@Configuration
public class DataSourceConfig {

    @Autowired
    Environment env;

    public DataSourceConfig() {
    }

    @Bean
    @Primary
    public DataSource appDataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        //dataSource.driverClassName(env.getProperty(""));
        dataSource.password(env.getProperty("app.datasource.password"));
        dataSource.username(env.getProperty("app.datasource.username"));
        dataSource.url(env.getProperty("app.datasource.jdbc-url"));
        return dataSource.build();
    }

    @Bean
    public DataSource securityDataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        //dataSource.driverClassName(env.getProperty(""));
        dataSource.password(env.getProperty("security.datasource.password"));
        dataSource.username(env.getProperty("security.datasource.username"));
        dataSource.url(env.getProperty("security.datasource.jdbc-url"));
        return dataSource.build();
    }

}
