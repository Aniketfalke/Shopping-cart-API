package com.mindtree.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ServiceConfig {

    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.username}")
    private String usernname;
    @Value("${database.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url(databaseUrl)
                .username(usernname)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();

        return dataSourceBuilder.build();
    }
    @Bean
    @Primary
    public HibernateProperties getHibernateProperties(){
        HibernateProperties properties= new HibernateProperties();
        properties.setDdlAuto("update");
        return properties;
    }
}
