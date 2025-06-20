package com.example.demo.service;

import com.example.demo.dto.ShortUrlResponse;
import com.example.demo.model.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ShortUrlService {
    
    private final ShortUrlRepository repository;
    private final Random random = new Random();
    private final String baseUrl;

    public ShortUrlService(ShortUrlRepository repository,    
                        @Value("${app.short-url-prefix}") String baseUrl) {
        this.repository = repository;
        this.baseUrl = baseUrl;
    }
    
    public ShortUrlResponse shortenUrl(String originalUrl) {
        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (repository.findByShortCode(shortCode).isPresent());
        
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(shortCode);
        repository.save(shortUrl);
          return new ShortUrlResponse(originalUrl, baseUrl + "/" + shortCode);
    }
    
    public Optional<ShortUrl> getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode);
    }
    
    private String generateShortCode() {
        // Generate a 6-character alphanumeric code
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        
        return sb.toString();
    }
}