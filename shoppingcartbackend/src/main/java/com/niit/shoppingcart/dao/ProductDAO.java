package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	//CRUD operations
	
	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
	
	public Product get(String id);
	
	public List<Product> list();
}
