package com.farminserver.api.config;

import com.farminserver.api.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public Boars_ExcelExporter boarsExcelExporter() {
        return new Boars_ExcelExporter();
    }

    @Bean
    @Primary
    public Finishing_ExcelExporter finishingExcelExporter() {
        return new Finishing_ExcelExporter();
    }

    @Bean
    @Primary
    public Gestation_ExcelExporter gestationExcelExporter() {
        return new Gestation_ExcelExporter();
    }

    @Bean
    @Primary
    public Growing_ExcelExporter growingExcelExporter() {
        return new Growing_ExcelExporter();
    }

    @Bean
    @Primary
    public Maternity_ExcelExporter maternityExcelExporter() {
        return new Maternity_ExcelExporter();
    }

    @Bean
    @Primary
    public Piglet_ExcelExporter pigletExcelExporter() {
        return new Piglet_ExcelExporter();
    }

    @Bean
    @Primary
    public Reserve_ExcelExporter reserveExcelExporter() {
        return new Reserve_ExcelExporter();
    }

    @Value("${spring.datasource.url}")
    private String SPRING_DATASOURCE_URL;

    @Value("${spring.datasource.username}")
    private String SPRING_DATASOURCE_USERNAME;

    @Value("${spring.datasource.password}")
    private String SPRING_DATASOURCE_PASSWORD;

    @Value("${spring.datasource.driver-class-name}")
    private String SPRING_DATASOURCE_DRIVER_CLASS_NAME;

    public void printDatabaseConfig() {
        System.out.println("URL: " + SPRING_DATASOURCE_URL);
        System.out.println("Username: " + SPRING_DATASOURCE_USERNAME);
        System.out.println("Password: " + SPRING_DATASOURCE_PASSWORD);
        System.out.println("Driver ClassName: " + SPRING_DATASOURCE_DRIVER_CLASS_NAME);
    }
}
