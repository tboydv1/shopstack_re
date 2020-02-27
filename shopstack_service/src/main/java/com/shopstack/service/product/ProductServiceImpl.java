package com.shopstack.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.product.ProductDao;
import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public void addProduct(Product newProduct) {
		productDao.addProduct(newProduct);
		
	}

	@Override
	public List<Product> product() {
	
		return productDao.product();
	}
	
	@Override
	public void addCategory(Category newCategory) {

		productDao.addCategory(newCategory);
		
	}

	@Override
	public List<Category> category() {
		
		return productDao.category();
	}
}
