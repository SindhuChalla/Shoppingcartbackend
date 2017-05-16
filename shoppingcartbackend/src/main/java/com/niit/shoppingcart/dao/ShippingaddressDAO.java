package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Shippingaddress;



public interface ShippingaddressDAO {

	//CRUD operations
	
	public boolean save(Shippingaddress shippingaddress);
	
	public boolean update(Shippingaddress shippingaddress);
	
	public boolean delete(Shippingaddress shippingaddress);
	
	public Shippingaddress get(String id);
	
	public List<Shippingaddress> list();
}
