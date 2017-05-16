package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


public class UserTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static User user;

@Autowired
static UserDAO userDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	user = (User) context.getBean("user"); 
	userDAO = (UserDAO) context.getBean("userDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createCategoryTestCase()
{

	user.setId("CAT 07");
	user.setName("Name");
	user.setContact("Contact");
	
	Boolean status = userDAO.save(user);
	
	Assert.assertEquals("Create User Test Case",true,status);
}

@Test

public void deleteUserTestCase()
{
	user.setId("07");	
Boolean status= userDAO.delete(user);
Assert.assertEquals("Delete User Test Case",true, status);
}
@Test
public void updateUserTestCase()
{
	
	user.setId("MOB_07");
	user.setName("Name");
	Boolean status= userDAO.update(user);
	Assert.assertEquals("Update User Test Case",true, status);
}

@Test
public void getUserTestCase()
{
Assert.assertEquals("Get Catergory Test case", null,userDAO.get("abcd"));	
}

@Test
public void getAllUserTestCase()
{
	Assert.assertEquals("Get All User Test case", 12,userDAO.list().size());
}

}

