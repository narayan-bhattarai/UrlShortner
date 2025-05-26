package com.example.demo.controller;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ShortUrl;
import com.example.demo.service.ShortUrlService;

@RestController
public class ShortUrlController {
    
    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }


    @PostMapping("/shorten")
    public ShortUrl shorten(@RequestParam String url)
    {
        return service.shortenUrl(url);
    }


    @GetMapping("/{code}")
    public String redirect(@PathVariable String code) {
        Optional<ShortUrl> original = service.getOriginalUrl(code);
        return original.map(ShortUrl::getOriginalUrl)
                       .orElse("Not found");
    }
}
