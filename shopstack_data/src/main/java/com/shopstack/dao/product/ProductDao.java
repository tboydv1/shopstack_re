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
	
	public List<Product> product();
	
	public void addCategory(Category newCategory);

	public List<Category> category();
	
	public Product findById(int productId);
}
