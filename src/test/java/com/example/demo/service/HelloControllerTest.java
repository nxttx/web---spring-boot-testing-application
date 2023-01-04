package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HelloControllerTest {

    private static HelloController controller;

    @BeforeAll
    public static void setUp() {
        controller = new HelloController();
    }

    @Test
    public void testIndex() {
        // ----- Arrange -----
        String expectedResponse = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Spring Boot Tutorial</title>" +
                "</head>" +
                "<body>" +
                "<h1>Spring Boot Tutorial</h1>" +
                "<p>Spring Boot is a framework that helps you to build stand-alone, production-grade Spring based Applications that you can just run.</p>" +
                "<p>Spring Boot takes an opinionated view of building production-ready applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.</p>" +
                "<p>Spring Boot is a project of the Spring Framework.</p>" +
                "<p>Spring Boot is a Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.</p>" +
                "</body>" +
                "</html>";

        // ----- Mock -----
        // No need to mock any dependencies for this method

        // ----- Act -----
        String response = controller.index();

        // ----- Assert -----
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testSayHelloWithRequestParam() {
        // ----- Arrange -----
         // Test with default value
        String expectedResponse1 = "Hello World!";

         // Test with specified value
        String expectedResponse2 = "Hello John!";

        // ----- Mock -----
         // No need to mock any dependencies for this method

        // ----- Act -----
        String response = controller.sayHelloWithRequestParam("World");
        String response2 = controller.sayHelloWithRequestParam("John");

        // ----- Assert -----
        assertEquals(expectedResponse1, response);
        assertEquals(expectedResponse2, response2);
    }
}
