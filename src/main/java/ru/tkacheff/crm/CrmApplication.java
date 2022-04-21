package ru.tkacheff.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    //TODO: enhanced search w/ query params (fuzzy search?)
    //TODO: Swagger/OpenAPI integration
    //TODO: appointment status change method
    //TODO: increase income on status finished
    //TODO: add archive field and move finished appointments to archive !!!
}
