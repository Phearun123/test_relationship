package com.example.test_relationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.test_relationship")
public class TestRelationshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRelationshipApplication.class, args);
    }

}
