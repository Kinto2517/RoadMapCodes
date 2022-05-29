package com.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class CustomerDal implements ICustomerDal {
	@Value("${database.connectionString}")
	String connectionStr;
	public String getConnectionStr() {
		return connectionStr;
	}
	public void setConnectionStr(String connectionStr) {
		this.connectionStr = connectionStr;
	}
	
	@Override
	public void add() {
		System.out.println(connectionStr);
		System.out.println("Oracle Eklendi");

	}
	
	

}
