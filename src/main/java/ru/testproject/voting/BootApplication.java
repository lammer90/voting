package ru.testproject.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class BootApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(BootApplication.class, args);
    }

}
