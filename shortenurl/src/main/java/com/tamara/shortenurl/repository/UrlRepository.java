package com.tamara.shortenurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tamara.shortenurl.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, String>, JpaSpecificationExecutor<Url> {

	public String findByShortURL(String url);
	
	public String findByLongUrl(String url);
	
	public String findByUniqueKey(String Key);
	
}
