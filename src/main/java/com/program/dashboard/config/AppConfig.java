package com.program.dashboard.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan("com.program.dashboard")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {


    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource dataSource(){

        HikariDataSource dataSource = new HikariDataSource();

        try {
            dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        } catch (Exception e){
            e.printStackTrace();
        }

        // log the connection props
        logger.info(">>>>> jdbc.url= " + environment.getProperty("jdbc.url"));
        logger.info(">>>>> jdbc.user= " + environment.getProperty("jdbc.user"));

        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setMinimumIdle(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
        dataSource.setMaximumPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
        dataSource.setIdleTimeout(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return dataSource;

    }



}
