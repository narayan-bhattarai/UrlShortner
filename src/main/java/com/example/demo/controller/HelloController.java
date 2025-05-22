package com.example.demo.controller; // Adjust this to match your package structure

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HelloController {
    @Operation(summary = "Just a Random Endpoint")
    @GetMapping("/api/random-endpoint")
    public String sayHello() {
        return "Hello, I am printing this line from Random Endpoints !";
    }
}
