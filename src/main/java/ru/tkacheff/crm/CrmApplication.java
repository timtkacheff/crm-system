package ru.tkacheff.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
    // TODO: Custom validation (format, message, exception)
    // TODO: Appointment Controller
    // TODO: DTO mapper
}
