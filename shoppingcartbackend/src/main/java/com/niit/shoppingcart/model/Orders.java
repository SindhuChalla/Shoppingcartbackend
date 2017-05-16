package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.springframework.stereotype.Component;

@Entity
@Table(name="orders")
@Component
public class Orders {
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLine_of_id() {
		return line_of_id;
	}

	public void setLine_of_id(String line_of_id) {
		this.line_of_id = line_of_id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="line_of_id")
	private String line_of_id;
	
	@Column(name="total")
	private String total;
	
	@Column(name="status")
	private String status;
	

}
