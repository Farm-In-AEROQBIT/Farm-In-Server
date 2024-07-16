package com.farminserver.api.config;

import com.farminserver.api.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {

    @Bean
    public Boars_ExcelExporter boarsExcelExporter() {
        return new Boars_ExcelExporter();
    }

    @Bean
    public Finishing_ExcelExporter finishingExcelExporter() {
        return new Finishing_ExcelExporter();
    }

    @Bean
    public Gestation_ExcelExporter gestationExcelExporter() {
        return new Gestation_ExcelExporter();
    }

    @Bean
    public Growing_ExcelExporter growingExcelExporter() {
        return new Growing_ExcelExporter();
    }

    @Bean
    public Maternity_ExcelExporter maternityExcelExporter() {
        return new Maternity_ExcelExporter();
    }

    @Bean
    public Piglet_ExcelExporter pigletExcelExporter() {
        return new Piglet_ExcelExporter();
    }

    @Bean
    public Reserve_ExcelExporter reserveExcelExporter() {
        return new Reserve_ExcelExporter();
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
