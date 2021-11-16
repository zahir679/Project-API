package com.bluechickenfm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
    public class DatasourceConfig {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "app.datasource.main")
        public HikariDataSource hikariDataSource() {
            return DataSourceBuilder
                    .create()
                    .type(HikariDataSource.class)
                    .build();
        }

        @Bean
        public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
            return new JdbcTemplate(hikariDataSource);
        }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR353Module());

        return objectMapper;
    }
    }
