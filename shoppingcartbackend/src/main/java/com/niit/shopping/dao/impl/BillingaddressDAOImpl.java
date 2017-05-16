package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.model.Billingaddress;


@Repository("billingaddressDAO")
public class BillingaddressDAOImpl implements BillingaddressDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BillingaddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Billingaddress billingaddress) {
		try {
			
			if(get(billingaddress.getId())==null)
					{
				return false;
					}
			sessionFactory.getCurrentSession().save(billingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Billingaddress billingaddress) {
		try {
			sessionFactory.getCurrentSession().update(billingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Billingaddress billingaddress) {
		try {
			if( get(billingaddress.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(billingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public Billingaddress get(String id) {
		return (Billingaddress) sessionFactory.getCurrentSession().get(Billingaddress.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Billingaddress> list() {
		
		String hql = "from Billingaddress";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
