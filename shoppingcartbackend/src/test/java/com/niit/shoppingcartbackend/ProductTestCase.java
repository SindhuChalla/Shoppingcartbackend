package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Product product;
	
	@Autowired
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
	     product = (Product) context.getBean("product"); 
	     productDAO = (ProductDAO) context.getBean("productDAO");
	    
	}
	
	@Test
	public void deleteProductTestCase()
	{
	product.setId("07");	
	Boolean status= productDAO.delete(product);
	Assert.assertEquals("Delete Product Test Case",true, status);
	}
	
	@Test
	public void updateProductTestCase()
	{
		
		product.setId("MOB_07");
		product.setPrice("This is Mobile Product");
		Boolean status= productDAO.update(product);
		Assert.assertEquals("Update Product Test Case",true, status);
	}
  @Test
  public void getProductTestCase()
  {
  Assert.assertEquals("Get Product Test case", null,productDAO.get("abcd"));	
  }
	
  @Test
  public void getAllProductTestCase()
  {
  	Assert.assertEquals("Get All Product Test case", 12,productDAO.list().size());
  }

}
