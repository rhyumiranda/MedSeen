package com.rhyu.medseen.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${pocketbase.apiUrl}")
    private String pocketbaseApiUrl;

    public void printApiUrl() {
        System.out.println("PocketBase API URL: " + pocketbaseApiUrl);
    }

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String url = pocketbaseApiUrl + "/api/collections/users/auth-with-password";
        // Call PocketBase login endpoint
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Prepare login request body
        String requestBody = String.format(
                "{\"identity\":\"%s\",\"password\":\"%s\"}",
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody()); // Return token or user data
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest loginRequest) {
        // Similar logic to register a user via PocketBase API
        String url = pocketbaseApiUrl + "/api/collections/users/records";
        // Make the API call to PocketBase
        return ResponseEntity.ok("User registered successfully");
    }
}