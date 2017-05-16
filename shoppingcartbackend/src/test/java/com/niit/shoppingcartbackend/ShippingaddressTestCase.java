package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.ShippingaddressDAO;
import com.niit.shoppingcart.model.Shippingaddress;


public class ShippingaddressTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Shippingaddress shippingaddress;

@Autowired
static ShippingaddressDAO shippingaddressDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	shippingaddress = (Shippingaddress) context.getBean("shippingaddress"); 
	shippingaddressDAO = (ShippingaddressDAO) context.getBean("shippingaddressDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createShippingaddressTestCase()
{

	shippingaddress.setId("CAT 07");
	shippingaddress.setCity("City");
	shippingaddress.setState("State");
	
	Boolean status = shippingaddressDAO.save(shippingaddress);
	
	Assert.assertEquals("Create Shippingaddress Test Case",true,status);
}

@Test

public void deleteCategoryTestCase()
{
	shippingaddress.setId("07");	
Boolean status= shippingaddressDAO.delete(shippingaddress);
Assert.assertEquals("Delete Shippingaddress Test Case",true, status);
}
@Test
public void updateShippingaddressTestCase()
{
	
	shippingaddress.setId("MOB_07");
	shippingaddress.setCity("City");
	Boolean status= shippingaddressDAO.update(shippingaddress);
	Assert.assertEquals("Update Shippingaddress Test Case",true, status);
}

@Test
public void getShippingaddressTestCase()
{
Assert.assertEquals("Get Shippingaddress Test case", null,shippingaddressDAO.get("abcd"));	
}

@Test
public void getAllCategoryTestCase()
{
	Assert.assertEquals("Get All Shippingaddress Test case", 12,shippingaddressDAO.list().size());
}

}

