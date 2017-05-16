package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


public class CartTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Cart cart;

@Autowired
static CartDAO cartDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	cart = (Cart) context.getBean("cart"); 
	cartDAO = (CartDAO) context.getBean("cartDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createCartTestCase()
{

	cart.setId("CAT 07");
	cart.setOrder_id("This is Order Id");
	cart.setTotal("Total");
	
	Boolean status = cartDAO.save(cart);
	
	Assert.assertEquals("Create Cart Test Case",true,status);
}

@Test

public void deleteCartTestCase()
{
	cart.setId("07");	
Boolean status= cartDAO.delete(cart);
Assert.assertEquals("Delete Cart Test Case",true, status);
}
@Test
public void updateCartTestCase()
{
	
	cart.setId("MOB_07");
	cart.setOrder_id("Order Id");
	Boolean status= cartDAO.update(cart);
	Assert.assertEquals("Update Cart Test Case",true, status);
}

@Test
public void getCartTestCase()
{
Assert.assertEquals("Get Cart Test case", null,cartDAO.get("abcd"));	
}

@Test
public void getAllCartTestCase()
{
	Assert.assertEquals("Get All Cart Test case", 12,cartDAO.list().size());
}

}

