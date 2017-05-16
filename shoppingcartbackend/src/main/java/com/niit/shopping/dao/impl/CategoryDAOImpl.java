package com.niit.shopping.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {


	
	private SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Category category) {
		try {
			
			if(get(category.getId())!=null)
			{
			  return false;
			}
			sessionFactory.getCurrentSession().save(category);
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean update(Category category) {
		try {
			if(get(category.getId())==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().update(category);
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean delete(Category category) {
		try {
			if( get(category.getId())==null)
			 {
				 return false;
			 }
			
			sessionFactory.getCurrentSession().delete(category);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public Category get(String id) {
		return sessionFactory.openSession().get(Category.class, id);
		
	}
//open the connection,commit/rollback ,close the connection
	@Transactional
	public List<Category> list() {
		
		String hql = "from Category";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//We need to convert this hql to db spacific query
		return query.list();
	}

	
	
}
