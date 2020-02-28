package com.shopstack.controller.product;



import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopstack.entities.product.Category;
import com.shopstack.entities.product.Product;
import com.shopstack.service.product.ProductService;


/**
 * @author RAY-ABEL
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	Logger logger = Logger.getLogger(getClass().getName());
	 @Autowired
	 private ProductService productService;
	  
	 private List<Category> categoriesList;
	
	 @ModelAttribute("categoriesList")
		public List<String> getCategories(){
			
			 categoriesList = productService.categoryList();
			
			List<String> categoryName = new ArrayList<>();
			
			for(int i = 0; i < categoriesList.size(); i++) {
				
				categoryName.add(categoriesList.get(i).getCategoryName());
				
			}
			return categoryName;
	 }
			
	 @GetMapping("/form")
		public String addForm(Model theModel) {
			
		 Product theProduct = new Product();
		 theModel.addAttribute("product",theProduct);
		 
		 
		return "product";
			
		}
	 @GetMapping("/list-product")
	 public String viewProduct(Model theModel) {
		 List<Product> productList = productService.productList();
		 theModel.addAttribute("product",productList);
		 logger.info("productList " +productList);
		return "list-product";
		 
	 }
	 
	 @PostMapping("/process")
	 @ResponseBody
	 public String processProduct(@ModelAttribute("product")Product theProduct) {
		 
		 
		 logger.info("New product entry " + theProduct);
		 
		 
		Integer productCategoryId = findByCategoryId(theProduct.getCategory().getCategoryName());
		
		if(productCategoryId != null) {
			theProduct.getCategory().setId(productCategoryId);
		}
		
		logger.info("New product entry " + theProduct);
		 
	    productService.addProduct(theProduct);
	    
	    logger.info("saved product successfully");
		 
		return "ok sent";
		 
	 }
	 @RequestMapping("/category-form")
		public String addCategoryForm(Model theModel) {
			
		 Category theCategory = new Category();
		 theModel.addAttribute("category",theCategory);
		
		return "category-form";
			
		}
	 @RequestMapping("/processCategory")
	 public String processCategory(@ModelAttribute("category")Category theCategory) {
		 
		 productService.addCategory(theCategory);
		 
		 logger.info("saved product successfully");
		 
		return "redirect:/product/form";
		 
	 }
	 
	 public Integer findByCategoryId(String categoriyName) {
		 
		 System.out.println(categoriyName);
		 
		 if(categoriesList == null) {
			 getCategories();
			
		 }
		 		 
		 for(Category categoryObj:categoriesList) {
			 
			 if(categoryObj.getCategoryName().equals(categoriyName)) {
				 System.out.println(categoryObj.getId());
				 return categoryObj.getId();
			 }
		logger.info("categories is null");
		 }
		return null;
		 
		 
		 
	 }
	 @GetMapping("/delete")
	 public String deleteProduct(@RequestParam("productId")int theId) {
		 productService.deleteProduct(theId);
		return "redirect:/product/list-product";
	 }

}

	
		

