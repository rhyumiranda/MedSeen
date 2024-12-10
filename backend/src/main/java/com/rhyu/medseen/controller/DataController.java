package com.rhyu.medseen.controller;

// import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/data")
    public String getData() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/api/posts")
    public Object fetchPosts(){
        String url = "http://localhost:8090/api/collections/posts/records";
        return restTemplate.getForObject(url, Object.class);
    }
}