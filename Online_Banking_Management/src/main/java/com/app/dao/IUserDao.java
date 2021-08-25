package com.app.dao;

import java.util.List;

import com.app.pojos.BaseEntity;
import com.app.pojos.User;

public interface IUserDao {

	//add a method for user login
		User validateUser(String email, String password);
		
		//add a method for listing all account holders
		List<User> getAllAccHolder();
		
		//delete user details
		String deleteUserDetails(User accountHolder);
		
		//get account holder's details from it's primary key
		User findByUserId(int userId);
		
		//register new Account 
		String registerAccount(User accountHolder);

		//String deleteUserDetails(BaseEntity accountHolder);

		//String registerAccount(BaseEntity accountHolder);
	
}
