package com.example.demo.dto;

public class ShortUrlResponse {
    private final String originalUrl;
    private final String shortUrl;  
    
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