package webApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by sachin on 25/2/18.
 */
@Configuration
public class DatabaseConfig {

    @Bean
     public DataSource getDataSource(){
        DriverManagerDataSource sqlDriver = new DriverManagerDataSource();
        sqlDriver.setDriverClassName("com.mysql.jdbc.Driver");
        sqlDriver.setUrl("jdbc:mysql://localhost:3306/Demo");
        sqlDriver.setUsername("demo");
        sqlDriver.setPassword("password");
        return sqlDriver;
    }
}
