package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name="category")//If table name is same as class name, you no need to specify
@Component  //create instance of the class
public class Category {
//id,name,description
	
	private Set<Product> products;
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	public Set<Product>getProducts(){
	return products;	
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	@Id
	private String id;
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="description")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
