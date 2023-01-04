package com.example.demo.service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController{

    @GetMapping("/")
    public String index() {
        return "<!DOCTYPE html>"+
                "<html>"+
                "<head>"+
                "<title>Spring Boot Tutorial</title>"+
                "</head>"+
                "<body>"+
                "<h1>Spring Boot Tutorial</h1>"+
                "<p>Spring Boot is a framework that helps you to build stand-alone, production-grade Spring based Applications that you can just run.</p>"+
                "<p>Spring Boot takes an opinionated view of building production-ready applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.</p>"+
                "<p>Spring Boot is a project of the Spring Framework.</p>"+
                "<p>Spring Boot is a Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.</p>"+
                "</body>"+
                "</html>";
    }

    @GetMapping("/request")
    public String sayHelloWithRequestParam(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
