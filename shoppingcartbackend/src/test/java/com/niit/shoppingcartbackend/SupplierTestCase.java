package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.ApplicationContextConfig;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTestCase {

	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
   @Autowired
   static SupplierDAO supplierDAO;

   @Autowired
   static Supplier supplier;
   
   @BeforeClass
   public static void init()
   {
	 context = new AnnotationConfigApplicationContext();  
	 context.scan("com.niit.shoppingcart");
	 context.refresh();
	 
	 supplierDAO = (SupplierDAO) context.getBean("suppplierDAO");
	 supplier = (Supplier) context.getBean("supplier");
	   
   }
   
   @Test
   public void createSupplierTestCase()
   {
	   supplier.setId("SUP0912");
	   supplier.setName("Bigbazar");
	   supplier.setAddress("delhi");
	   
	   boolean flag = supplierDAO.save(supplier);
	   Assert.assertEquals("create Supplier Test case",true, supplierDAO.save(supplier));
	   
   }
   
   @Test
   public void updateSupplierTestCase()
   {
	   supplier.setId("SUP0911");
	   supplier.setAddress("chennai");
	   
	   Assert.assertEquals("update Supplier Test case",true, supplierDAO.update(supplier));
	   
   }
   
   
   
}

