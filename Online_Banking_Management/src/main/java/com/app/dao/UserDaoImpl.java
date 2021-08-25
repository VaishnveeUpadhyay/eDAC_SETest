package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.User;

@Repository //to tell Spring Container : class contains data access logic
public class UserDaoImpl implements IUserDao{

	@Autowired //Marks a constructor, field, setter method, or config method as to be
	//autowired bySpring's dependency injection facilities
	private EntityManager manager;

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return manager.createQuery(jpql, User.class).setParameter("em",email).setParameter("pass",password).getSingleResult();
	}

	@Override
	public List<User> getAllAccHolder() {
		String jpql = "select u from User u where u.userRole=:role";
		return manager.createQuery(jpql,User.class).setParameter("role", Role.ACCOUNT_HOLDER).getResultList();
	}

	@Override
	public String deleteUserDetails(User accountHolder) {
	   String msg="Account deleted with Id" + accountHolder.getAccNo();
	   manager.remove(accountHolder);
		return msg;
	}

	@Override
	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return manager.find(User.class, userId);
	}

	
	@Override
	public String registerAccount(User accountHolder) {
		manager.persist(accountHolder);
		return "New Account registered successfully with Account Number=" + accountHolder.getAccNo();
	}
	
	
}
