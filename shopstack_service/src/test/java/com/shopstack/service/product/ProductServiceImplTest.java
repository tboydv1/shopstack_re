/**
 * 
 */
package com.shopstack.service.product;
import static org.mockito.Mockito.doNothing;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;



/**
 * @author RAY-ABEL
 *
 */
public class ProductServiceImplTest {

//	@Mock
//	private ProductService productService;
//
//	@Rule
//	public MockitoRule rule = MockitoJUnit.rule();
//
//	@Test
//	public void addProduct() {
//
//		Product product =new Product();
//
//		doNothing().when(productService).addProduct(isA(Product.class));
//		productService.addProduct(product);
//
//		verify(productService,times(1)).addProduct(product);
//	}
//	@Test
//	public void getProductList() {
//		List<Product> productList = new ArrayList<>();
//		when(productService.productList()).thenReturn(productList);
//		productService.productList();
//
//		verify(productService, times(1)).productList();
//	}
//	@Test
//	public void addCategory() {
//
//		Category category = new Category();
//		doNothing().when(productService).addCategory(isA(Category.class));
//		productService.addCategory(category);
//
//		verify(productService, times(1)).addCategory(category);
//	}
//	@Test
//	public void getCategoryList() {
//
//		List<Category> categoryList = new ArrayList<>();
//
//		when(productService.categoryList()).thenReturn(categoryList);
//		productService.categoryList();
//
//		verify(productService, times(1)).categoryList();
//	}
}
