package com.farminserver.api.config;

import com.farminserver.api.util.ExcelExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {

    @Bean
    public ExcelExporter excelExporter() {
        return new ExcelExporter();
    }

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public void printDatabaseConfig() {
        System.out.println("URL: " + databaseUrl);
        System.out.println("Username: " + databaseUsername);
        System.out.println("Password: " + databasePassword);
    }
}
