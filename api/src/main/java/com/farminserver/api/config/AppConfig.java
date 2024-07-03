package com.farminserver.api.config;

import com.farminserver.api.util.Boars_ExcelExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {

    @Bean
    public Boars_ExcelExporter excelExporter() {
        return new Boars_ExcelExporter();
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
