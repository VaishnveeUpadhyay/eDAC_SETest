package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service //to tell class that holds Business Logic
@Transactional //Describes a transaction attribute on an individual method or on a class.
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	public User validateUser(String email, String password) {
		System.out.println("in service : " + email + " and " + password);
		//invoke dao's method
		return userDao.validateUser(email, password);
	}

	@Override
	public List<User> getAllAccHolders() {
		
		return userDao.getAllAccHolder();
	}

	@Override
	public String deleteAccountDetails(int accNo) {
		User user = userDao.findByUserId(accNo);
		if(user != null)
			return userDao.deleteUserDetails(user);
		return "Account deletion failed";
	}

	@Override
	public String registerNewAccount(User accHolder) {
		//for New Account
		accHolder.setUserRole(Role.ACCOUNT_HOLDER);
		return userDao.registerAccount(accHolder);
	}
	
	
}
