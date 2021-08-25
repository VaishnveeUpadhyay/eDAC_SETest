package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("in constructor of " + getClass().getName() + " " + userService);
	}
	
	@PostConstruct //This method must be invoked before the classis put into service.
	public void myInit() {
		System.out.println("in init of "+ getClass().getName() + " " + userService);
	}
	
	@GetMapping("/login")  // add request handling method for showing the login form
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}
	
	@PostMapping("/login") // add request handling method for processing the login form
	public String processLoginForm(@RequestParam String email, @RequestParam(name="pass") String pwd, Model map, HttpSession session)
	{
		System.out.println("in preocess login form " + email + " " + pwd);
		
		try {
		User validateUser = userService.validateUser(email, pwd);
		
		session.setAttribute("user_details", validateUser);
		session.setAttribute("message","Hello, " + validateUser.getName());
		
		//if(validateUser.getUserRole().equals(Role.ACCOUNT_HOLDER))
			return "redirect:/accHolder/details";
		//return "You do not have account in this bank";
		
		}catch(RuntimeException e) {
			e.printStackTrace();
			map.addAttribute("message", "Invalid Login Credentials!!! Try Again");
			return "/user/login";
		}
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model modelMap, HttpServletRequest request,HttpServletResponse resp)
	{
		System.out.println("in user's logout");
		
		modelMap.addAttribute("details", session.getAttribute("user_details"));
		
		session.invalidate();
		
		resp.setHeader("refresh", "3;url=" + request.getContextPath());
		return "/user/logout";
	}
	
}
