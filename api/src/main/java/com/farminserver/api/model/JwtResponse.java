package com.farminserver.api.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter and setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
