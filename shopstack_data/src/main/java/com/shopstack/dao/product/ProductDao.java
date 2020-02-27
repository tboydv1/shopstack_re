package com.shopstack.dao.product;

import java.util.List;

import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;

/**
 * @author RAY-ABEL
 *
 */
public interface ProductDao {

	public void addProduct(Product newProduct);
	
	public List<Product> productList();
	
	public void addCategory(Category newCategory);

	public List<Category> categoryList();
	
	public Product findById(int productId);
	
	
	

	

}
