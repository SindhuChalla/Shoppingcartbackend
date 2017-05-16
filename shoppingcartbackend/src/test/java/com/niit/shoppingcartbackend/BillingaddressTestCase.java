package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Billingaddress;


public class BillingaddressTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Billingaddress billingaddress;

@Autowired
static BillingaddressDAO billingaddressDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	billingaddress = (Billingaddress) context.getBean("billingaddress"); 
	billingaddressDAO = (BillingaddressDAO) context.getBean("billingaddressDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createBillingaddressTestCase()
{

	billingaddress.setId("CAT 07");
	billingaddress.setDoor_no("Door Number");
	billingaddress.setStreet_name("Street Name");
	
	Boolean status = billingaddressDAO.save(billingaddress);
	
	Assert.assertEquals("Create Billingaddress Test Case",true,status);
}

@Test

public void deleteBillingaddressTestCase()
{
	billingaddress.setId("07");	
Boolean status= billingaddressDAO.delete(billingaddress);
Assert.assertEquals("Delete Billingaddress Test Case",true, status);
}
@Test
public void updateBillingaddressTestCase()
{
	
	billingaddress.setId("MOB_07");
	billingaddress.setDoor_no("Door Number");
	Boolean status= billingaddressDAO.update(billingaddress);
	Assert.assertEquals("Update Billingaddress Test Case",true, status);
}

@Test
public void getBillingaddressTestCase()
{
Assert.assertEquals("Get Billingaddress Test case", null,billingaddressDAO.get("abcd"));	
}

@Test
public void getAllBillingaddressTestCase()
{
	Assert.assertEquals("Get All Billingaddress Test case", 12,billingaddressDAO.list().size());
}

}

