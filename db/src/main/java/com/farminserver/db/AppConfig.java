package com.farminserver.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {
    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USERNAME}")
    private String databaseUsername;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    public void printDatabaseConfig() {
        System.out.println("URL: " + databaseUrl);
        System.out.println("Username: " + databaseUsername);
        System.out.println("Password: " + databasePassword);
    }
}
