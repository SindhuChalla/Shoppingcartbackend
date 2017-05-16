package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
SessionFactory sessionFactory;
	
public SupplierDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory = sessionFactory;
}

public boolean save(Supplier supplier) {
	
	try {
		
		if(get(supplier.getId())==null)
				{
			return false;
				}
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

@Transactional
public boolean update(Supplier supplier) {
	try {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}

@Transactional
public boolean delete(Supplier supplier) {
	try {
		sessionFactory.openSession().delete(supplier);

	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}

@Transactional
public Supplier get(String id) {

	return ((Supplier)sessionFactory.openSession().get(Supplier.class, id));
}

@Transactional
public List<Supplier> list() {
	
	String hql="from Supplier";
	Query query =sessionFactory.openSession().createQuery(hql);
	
	return query.list();
}

}
