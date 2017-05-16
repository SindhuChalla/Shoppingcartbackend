package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.LineofitemDAO;
import com.niit.shoppingcart.model.Lineofitem;


public class LineofitemTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Lineofitem lineofitem;

@Autowired
static LineofitemDAO lineofitemDAO; //to call the methods

@BeforeClass
public static void init() 
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	lineofitem = (Lineofitem) context.getBean("lineofitem"); 
	lineofitemDAO = (LineofitemDAO) context.getBean("lineofitemDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createLineofitemTestCase()
{

	lineofitem.setId("CAT 07");
	lineofitem.setProduct_id("This is Product Id");
	lineofitem.setRate("Rate");
	
	Boolean status = lineofitemDAO.save(lineofitem);
	
	Assert.assertEquals("Create Lineofitem Test Case",true,status);
}

@Test

public void deleteLineofitemTestCase()
{
	lineofitem.setId("07");	
Boolean status= lineofitemDAO.delete(lineofitem);
Assert.assertEquals("Delete Lineofitem Test Case",true, status);
}
@Test
public void updateLineofitemTestCase()
{
	
	lineofitem.setId("MOB_07");
	lineofitem.setProduct_id("This is Product Id");
	Boolean status= lineofitemDAO.update(lineofitem);
	Assert.assertEquals("Update Lineofitem Test Case",true, status);
}

@Test
public void getLineofitemTestCase()
{
Assert.assertEquals("Get Lineofitem Test case", null,lineofitemDAO.get("abcd"));	
}

@Test
public void getAllLineofitemTestCase()
{
	Assert.assertEquals("Get All Lineofitem Test case", 12,lineofitemDAO.list().size());
}

}

