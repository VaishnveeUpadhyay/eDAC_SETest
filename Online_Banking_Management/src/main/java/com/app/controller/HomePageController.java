package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Indicates that an annotated class is a "Controller" (front controller).
public class HomePageController {
	
	public HomePageController() {
		System.out.println("in constructor of " + getClass().getName());
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in show home page ");
		return "/index"; //logical view name , actual view name : /WEB-INF/views/index.jsp

	}

}
