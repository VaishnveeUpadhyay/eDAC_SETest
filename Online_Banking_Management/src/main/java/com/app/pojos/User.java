package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity //Specifies that the class is an entity(table)
@Table(name="user_mgmt") //Specifies the primary table for the annotated entity
public class User extends BaseEntity {
	
	@Column(length=30)
	private String name;
	
	@Column(length=25, unique=true)
	private String email="abc@gmail.com";
	
	@Column(name="dob")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;

	@Column(length=20)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="user_role", length=20)
	private Role userRole;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="reg_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate regDate;

	@Enumerated(EnumType.STRING)
	@Column(name="account_type", length=20)
	private AccountType accType;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, LocalDate dob, String password, Role userRole, double balance,
			LocalDate regDate, AccountType accType) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.userRole = userRole;
		this.balance = balance;
		this.regDate = regDate;
		this.accType = accType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	

	
		
}
