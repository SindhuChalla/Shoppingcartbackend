package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.User;


public interface UserDAO {

	//CRUD operations
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User get(String id);
	
	public List<User> list();
}
