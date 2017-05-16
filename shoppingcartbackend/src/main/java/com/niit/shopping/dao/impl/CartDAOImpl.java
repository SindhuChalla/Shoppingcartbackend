package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Cart cart) {
		try {
			
			if(get(cart.getId())==null)
					{
				return false;
					}
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Cart cart) {
		try {
			if( get(cart.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public Cart get(String id) {
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Cart> list() {
		
		String hql = "from Category";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
