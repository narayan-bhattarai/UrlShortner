package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;

import java.util.Optional;
import java.util.UUID;
@Service
public class ShortUrlService  {
    
    private final ShortUrlRepository repository;

    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public ShortUrl shortenUrl(String originalUrl) {
        String code = UUID.randomUUID().toString().substring(0, 6); // Simple random code
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setShortCode(code);
        shortUrl.setOriginalUrl(originalUrl);
        return repository.save(shortUrl);
    }

    public Optional<ShortUrl> getOriginalUrl(String code) {
        return repository.findByShortCode(code);
    }
}
