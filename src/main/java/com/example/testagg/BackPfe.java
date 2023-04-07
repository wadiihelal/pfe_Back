package com.example.testagg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackPfe implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackPfe.class, args);
    }


    @Override
    public void run(String... args)  {
        System.out.println("work");

    }
}
