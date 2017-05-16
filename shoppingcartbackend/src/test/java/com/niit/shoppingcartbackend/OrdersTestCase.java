package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Orders;


public class OrdersTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Orders orders;

@Autowired
static OrdersDAO ordersDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	orders = (Orders) context.getBean("orders"); 
	ordersDAO = (OrdersDAO) context.getBean("ordersDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createOrdersTestCase()
{

	orders.setId("CAT 07");
	orders.setTotal("Total");
	orders.setStatus("Status");
	
	Boolean status = ordersDAO.save(orders);
	
	Assert.assertEquals("Create Orders Test Case",true,status);
}

@Test

public void deleteOrdersTestCase()
{
	orders.setId("07");	
Boolean status= ordersDAO.delete(orders);
Assert.assertEquals("Delete Orders Test Case",true, status);
}
@Test
public void updateOrdersTestCase()
{
	
	orders.setId("MOB_07");
	orders.setTotal("Total");
	Boolean status= ordersDAO.update(orders);
	Assert.assertEquals("Update Orders Test Case",true, status);
}

@Test
public void getOrdersTestCase()
{
Assert.assertEquals("Get Catergory Test case", null,ordersDAO.get("abcd"));	
}

@Test
public void getAllOrdersTestCase()
{
	Assert.assertEquals("Get All Orders Test case", 12,ordersDAO.list().size());
}

}

