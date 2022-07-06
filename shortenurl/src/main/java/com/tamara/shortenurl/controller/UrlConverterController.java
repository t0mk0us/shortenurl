package com.tamara.shortenurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.shortenurl.model.Url;
import com.tamara.shortenurl.service.UrlConverterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UrlConverterController {
	
	@Autowired
	UrlConverterService urlConverterService;
	
    @PostMapping("create-short")
    public String convertToShortUrl(@RequestBody Url request) {
        return urlConverterService.convertToShortUrl(request);
    }

    @GetMapping(value = "{shortUrl}") 
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) { 
        Url url = urlConverterService.getOriginalUrl(shortUrl); 
        return ResponseEntity.status(HttpStatus.FOUND)  
        .build(); 
}
}
