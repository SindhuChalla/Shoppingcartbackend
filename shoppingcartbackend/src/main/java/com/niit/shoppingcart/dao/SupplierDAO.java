package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	//CRUD operations
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public Supplier get(String id);
	
	public List<Supplier> list();
}
