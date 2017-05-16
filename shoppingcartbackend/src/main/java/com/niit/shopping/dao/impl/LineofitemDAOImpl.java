package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.LineofitemDAO;
import com.niit.shoppingcart.model.Lineofitem;


@Repository("lineofitemDAO")
public class LineofitemDAOImpl implements LineofitemDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public LineofitemDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Lineofitem lineofitem) {
		try {
			
			if(get(lineofitem.getId())==null)
					{
				return false;
					}
			sessionFactory.getCurrentSession().save(lineofitem);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Lineofitem lineofitem) {
		try {
			sessionFactory.getCurrentSession().update(lineofitem);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(Lineofitem lineofitem) {
		try {
			if( get(lineofitem.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(lineofitem);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public Lineofitem get(String id) {
		return (Lineofitem) sessionFactory.getCurrentSession().get(Lineofitem.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Lineofitem> list() {
		
		String hql = "from Category";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
