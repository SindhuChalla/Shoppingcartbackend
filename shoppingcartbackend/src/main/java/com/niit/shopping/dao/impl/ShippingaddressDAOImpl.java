package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ShippingaddressDAO;
import com.niit.shoppingcart.model.Shippingaddress;


@Repository("shippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingaddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Shippingaddress shippingaddress) {
		try {
			
			if(get(shippingaddress.getId())==null)
					{
				return false;
					}
			sessionFactory.getCurrentSession().save(shippingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Shippingaddress shippingaddress) {
		try {
			sessionFactory.getCurrentSession().update(shippingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Shippingaddress shippingaddress) {
		try {
			if( get(shippingaddress.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(shippingaddress);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public Shippingaddress get(String id) {
		return (Shippingaddress) sessionFactory.getCurrentSession().get(Shippingaddress.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Shippingaddress> list() {
		
		String hql = "from Shippingaddress";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
