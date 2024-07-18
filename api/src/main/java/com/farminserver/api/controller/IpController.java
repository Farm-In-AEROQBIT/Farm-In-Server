package com.farminserver.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IpController {

    @Value("${api.base.url}")
    private String apiUrl;

    @GetMapping("/test")
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        String IpResponses = restTemplate.getForObject(apiUrl + "/resource", String.class);
        return IpResponses;
    }

}
