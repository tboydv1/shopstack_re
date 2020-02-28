package com.shopstack.dao.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;
/**
 * @author RAY-ABEL
 *
 */

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	private Logger logger =Logger.getLogger(getClass());
	@Transactional
	@Override
	public void addProduct(Product newProduct) {
		
	Session session =factory.getCurrentSession();
	if(newProduct !=null) {
		session.save(newProduct);
		logger.info("saved newproduct to database successfully");
	}
	
			

	}
	@Transactional
	@Override
	public List<Product> productList() {
		Session session=factory.getCurrentSession();
		List<Product> resultList;
		Query<Product> query=session.createQuery("from Product",Product.class);
		logger.info("reterive from database");
		resultList=query.getResultList();
	 
	 
		return resultList;
	}
	@Transactional
	@Override
	public void addCategory(Category newCategory) {
		Session session =factory.getCurrentSession();
		if(newCategory != null) {
			session.save(newCategory);
			logger.info("saved category iteam to database successful");
		}
	}
	@Transactional
	@Override
	public List<Category> categoryList() {
		Session session =factory.getCurrentSession();
	 List<Category> resultList;
	 
	 Query<Category> query =session.createQuery("from Category",Category.class);
	 logger.info("reterive from database");
	 resultList = query.getResultList();		
	 return resultList;
	}
	@Transactional
	@Override
	public Product findById(int productId) {
	Session session =factory.getCurrentSession();
		return session.get(Product.class,productId);
	}
	
	}


