package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Orders;



public interface OrdersDAO {

	//CRUD operations
	
	public boolean save(Orders orders);
	
	public boolean update(Orders orders);
	
	public boolean delete(Orders orders);
	
	public Orders get(String id);
	
	public List<Orders> list();
}
