package com.example.dine_in_order_api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class AppDoc {


    //OpenAPI -> it ia a class
    // info  -> it is also a class

    @Bean
    OpenAPI getOpenAPI () {
        return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title("Dine In Order")
                .description("""
                        ## Description
                        **Dine In Order** is an API built using Spring Boot under REST Architecture.
                        The API is designed to serve as an Backend to a  application that deals in ordering food online.

                        ## Tech-Stack
                        - Java 8
                        - Spring Boot
                        - Spring Data JPA
                        - MySQL Database
                        - Spring Security
                       """)
                .version("v1")
                .contact(contact());

    }

    private Contact contact () {
        return  new Contact().email("abc@gmail.com")
                .name("abc")
                .url("https://google.com");
    }



}

// http://localhost:8080/swagger-ui/index.html#/User%20Controller/registerUser