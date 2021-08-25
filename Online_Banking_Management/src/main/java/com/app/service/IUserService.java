package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService  {

	User validateUser(String email, String password);
	
	//add a method for listing all Accounts
	List<User> getAllAccHolders();
	
	//delete AccountHolder Details
	String deleteAccountDetails(int accNo);
	
	//Open new Account
	String registerNewAccount(User accHolder);
}
