package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Billingaddress;


public interface BillingaddressDAO {

	//CRUD operations
	
	public boolean save(Billingaddress billingaddress);
	
	public boolean update(Billingaddress billingaddress);
	
	public boolean delete(Billingaddress billingaddress);
	
	public Billingaddress get(String id);
	
	public List<Billingaddress> list();
}
