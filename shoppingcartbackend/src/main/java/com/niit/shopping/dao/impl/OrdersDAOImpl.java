package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Orders;


@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public OrdersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Orders orders) {
		try {
			
			if(get(orders.getId())==null)
					{
				return false;
					}
			sessionFactory.getCurrentSession().save(orders);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Orders orders) {
		try {
			sessionFactory.getCurrentSession().update(orders);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Orders orders) {
		try {
			if( get(orders.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(orders);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public Orders get(String id) {
		return (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Orders> list() {
		
		String hql = "from Orders";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
