package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTestCase {

	//configured through XMl-> ClassPathXmlApplicationContext
	
@Autowired
static AnnotationConfigApplicationContext context;	

@Autowired
static Category category;

@Autowired
static CategoryDAO categoryDAO; //to call the methods

@BeforeClass
public static void init() {
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
     category = (Category) context.getBean("category"); 
     categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
}
  //Start Junit test case //for each method defined in DAO
@Test
public  void createCategoryTestCase()
{

	category.setId("CAT 07");
	category.setDescription("This is Mobile Category");
	category.setName("Mobile Category");
	
	Boolean status = categoryDAO.save(category);
	
	Assert.assertEquals("Create Category Test Case",true,status);
}

@Test

public void deleteCategoryTestCase()
{
category.setId("07");	
Boolean status= categoryDAO.delete(category);
Assert.assertEquals("Delete Category Test Case",true, status);
}
@Test
public void updateCategoryTestCase()
{
	
	category.setId("MOB_07");
	category.setDescription("This is Mobile Category");
	Boolean status= categoryDAO.update(category);
	Assert.assertEquals("Update Category Test Case",true, status);
}

@Test
public void getCategoryTestCase()
{
Assert.assertEquals("Get Catergory Test case", null,categoryDAO.get("abcd"));	
}

@Test
public void getAllCategoryTestCase()
{
	Assert.assertEquals("Get All Catergory Test case", 12,categoryDAO.list().size());
}

}

