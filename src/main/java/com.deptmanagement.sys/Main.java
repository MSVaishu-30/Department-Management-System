package com.deptmanagement.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Main entry point of the Spring Boot application.
 */
@SpringBootApplication // Enables auto-configuration, component scanning, and configuration
@ComponentScan("com.deptmanagement.sys") // Scans all components (controllers, services, etc.) under this base package
@EnableJpaRepositories(basePackages = "com.deptmanagement.sys.repository") // Enables JPA repositories (PostgreSQL)
@EnableMongoRepositories(basePackages = "com.deptmanagement.sys.repository") // Enables MongoDB repositories
@EntityScan(basePackages = "com.deptmanagement.sys.domain.entity") // Scans for JPA entities in the given package
public class Main {

    /**
     * Main method to run the Spring Boot application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // Bootstraps the application
    }
}
