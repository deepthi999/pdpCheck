package com.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcryptjava {
	public static void main(String args[])
	{
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String password=passwordEncoder.encode("deepthi");
		System.out.println("password");
		
	}




}
