package com.example.testagg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class BackPfe implements CommandLineRunner {

    @Autowired
     private MongoTemplate mongoTemplate;
    public static void main(String[] args) {
        SpringApplication.run(BackPfe.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
