package com.shopstack.dao.product;
/**
 * @author RAY-ABEL
 *
 */
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;
/**
 * @author RAY-ABEL
 *
 */
@Sql(scripts= {"classpath:/db/insert-into-productCategory.sql"})
@Sql(scripts= {"classpath:/db/insert-into-product-script.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class ProductDaoImplTest {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private ProductDao productDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void classesInitializedTest() {
		assertNotNull(productDao);
		logger.info(getClass()+ " product dao initialzed");
	}
	
	@Test
	public void getProduct() {
		List<Product> product = productDao.productList();
		assertNotNull(product);
		logger.info(getClass()+ " product list");
	}

	@Test
	public void addProduct() {
		Category category = new Category("food");
		 Product product = new Product("Laptop",new Date(2016-06-27),category,97000.00,"consumer product");
		 
		 productDao.addProduct(product);
		 int productId = product.getId();
		 productDao.findById(productId);
		 
		 
		 
			//assertNotNull(product);
	}
	@Test
	public void getCategory() {
		List<Category> category = productDao.categoryList();
		assertNotNull(category);
		logger.info(getClass()+ " category list");
	}
}
