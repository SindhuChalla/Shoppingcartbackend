package com.niit.shoppingcart.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.Lineofitem;


public interface LineofitemDAO {

	//CRUD operations
	
	public boolean save(Lineofitem lineofitem);
	
	public boolean update(Lineofitem lineofitem);
	
	public boolean delete(Lineofitem lineofitem);
	
	public Lineofitem get(String id);
	
	public List<Lineofitem> list();
}
