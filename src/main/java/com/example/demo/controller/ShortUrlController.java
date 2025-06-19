package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ShortUrl;
import com.example.demo.service.ShortUrlService;

@RestController
public class ShortUrlController {
    
    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrl> shorten(@RequestParam String url) {
        try {
            return ResponseEntity.ok(service.shortenUrl(url));
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> redirect(@PathVariable String code) {
        return service.getOriginalUrl(code)
                .map(shortUrl -> ResponseEntity.status(HttpStatus.FOUND)
                        .header("Location", shortUrl.getOriginalUrl())
                        .body(""))
                .orElseThrow(() -> new ResourceNotFoundException("Short URL not found for code: " + code));
    }
}