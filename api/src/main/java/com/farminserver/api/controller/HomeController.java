package com.farminserver.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RestController
//public class HomeController {
//    @GetMapping("/")
//    public Map<String, String> home() {
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Welcome to the Farm-In Server!");
//        response.put("status", "success");
//        return response;
//    }
//}

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot backend!";
    }
}
