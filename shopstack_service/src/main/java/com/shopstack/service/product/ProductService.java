package com.shopstack.service.product;
/**
 * @author RAY-ABEL
 *
 */
import java.util.List;

import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;

public interface ProductService {

	public void addProduct(Product newProduct);
	
	public List<Product> productList();
	
    public void addCategory(Category newCategory);
	
	public List<Category> categoryList();
	
	public void deleteProduct(int theId);
}
