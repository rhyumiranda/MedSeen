package com.rhyu.medseen.controller;

public class LoginRequest {
    private String email;
    private String password;

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: Add a constructor for convenience
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Default constructor
    public LoginRequest() {}
}
