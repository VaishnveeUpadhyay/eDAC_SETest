package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IUserService;

@Controller
@RequestMapping("/accHolder")
public class AccountSummary {
	
	@Autowired
	private IUserService userService;
	
	public AccountSummary() {
		System.out.println("in constructor of " + getClass().getName());
	}
	
	@GetMapping("/details")
	public String showAccountDetails(Model map)
	{
		System.out.println("in show account details");
		map.addAttribute("accList", userService.getAllAccHolders());
		return "/accHolder/details";
	}

}
