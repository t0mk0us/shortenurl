package com.tamara.shortenurl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Data
@Table (name = "URLs")
public class Url{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String ID;
	
	@Column(name = "LongURL")
    private String longUrl;
	
	@Column(name = "ShortURL")
	private String shortURL;
	
	@Column(name = "UniqueID")
	private String uniqueKey;	

	@Override
	public String toString() {
		return ("longUrl = " + longUrl + " " + " shortURL " + shortURL);
	}

}
