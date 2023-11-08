package com.in28minuts.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginConroller {
	
	private loginAuthenticationService authenticationService;
	
	public LoginConroller(loginAuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	// http://localhost:8080/login?name=Ranga
	// GET, POST
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	// @RequestParam 어노테이션을 이용한다 
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
		
			model.put("name", name);
			//Authentication 
			//name - in28minutes
			//password - dummy
			
			return "welcome";
		}
		
		return "login";
	}

}