package com.farminserver.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.farminserver.db"})
@EntityScan(basePackages = "com.farminserver.db")
@EnableTransactionManagement
public class JpaConfig {
}
