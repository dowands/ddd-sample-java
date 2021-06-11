package com.example.dddsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.dddsample"})
public class DddSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddSampleApplication.class, args);
    }
}
