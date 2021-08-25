package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass  //to tell hibernate: no associated table But other entites
public class BaseEntity {

	@Id //to define primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Provides for the specification of generation strategies for thevalues of primary keys.
	private Integer AccNo; //to avoid optimistic locking we used Integer
	
	public BaseEntity() {
		System.out.println("in base entity CONSTRUCTOR");
	}
	
	public Integer getAccNo() {
		return AccNo;
	}
	
	public void setAccNo(Integer AccNo) {
		this.AccNo=AccNo;
	}
}
