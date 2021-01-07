package com.jdnd.data.persistence.m4e1dsp.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant");
        return dsb.build();
    }
}
