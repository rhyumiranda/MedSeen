package com.rhyu.medseen.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PocketBaseService {

    private final RestTemplate restTemplate;

    public PocketBaseService() {
        this.restTemplate = new RestTemplate();
    }

    public Object fetchPosts() {
        String url = "http://localhost:8090/api/collections/posts/records";
        // Send GET request to PocketBase API
        return restTemplate.getForObject(url, Object.class);
    }
}