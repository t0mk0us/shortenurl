package com.tamara.shortenurl.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.tamara.shortenurl.model.Url;
import com.tamara.shortenurl.repository.UrlRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UrlConverterService {

	@Autowired
	UrlRepository urlRepository;
	
	public Url sauvegarder(Url url) {

		return urlRepository.saveAndFlush (url);
	}
	
	public String convertToShortUrl(Url request) {
	 
	     char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
	   
	     StringBuffer shorturl = new StringBuffer(); 
	   
	     int n = 62;
	     while (n > 0) 
	     { 
	         shorturl.append(map[n % 62]);
	         n = n / 62; 
	     } 
	   
	     // Reverse shortURL to complete base conversion 
	     return shorturl.reverse().toString(); 
	}
	
	  public static String getDictionaryKeyFromUniqueID(String dk) {
			String result  = getDictionaryKeyFromUniqueID(dk);
			return result;
		}

	public Url getOriginalUrl(String shortUrl) {
		Url result = urlRepository.getById(shortUrl);
		return result;
	}
	
}
