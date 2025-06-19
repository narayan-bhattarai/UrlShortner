package com.example.demo.service;

import com.example.demo.model.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ShortUrlService {
    
    private final ShortUrlRepository repository;
    private final Random random = new Random();
    
    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }
    
    public ShortUrl shortenUrl(String originalUrl) {
        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (repository.findByShortCode(shortCode).isPresent());
        
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(shortCode);
        
        return repository.save(shortUrl);
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