package com.in28minuts.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class loginAuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}
}
