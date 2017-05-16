package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Cart;


public interface CartDAO {

	//CRUD operations
	
	public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart get(String id);
	
	public List<Cart> list();
}
