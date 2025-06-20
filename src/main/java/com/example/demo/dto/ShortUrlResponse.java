package com.example.demo.dto;

public class ShortUrlResponse {
    private final String originalUrl;
    private final String shortUrl;  // Will contain "xotoLink.io/abC234"
    
    public ShortUrlResponse(String originalUrl, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }
    
    // Getters
    public String getOriginalUrl() {
        return originalUrl;
    }
    
    public String getShortUrl() {
        return shortUrl;
    }
}