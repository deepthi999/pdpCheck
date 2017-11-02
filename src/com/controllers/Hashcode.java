package com.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hashcode {
	public String getHashPassword(String password) {  
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		  String hashedPassword = passwordEncoder.encode(password);  
		  
		  System.out.println(hashedPassword);  
		  return hashedPassword;  
		 }  
}
