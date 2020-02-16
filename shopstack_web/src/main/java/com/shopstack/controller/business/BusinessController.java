package com.shopstack.controller.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.service.business.BusinessService;

@Controller 
@RequestMapping("/biz")
public class BusinessController {

	@Autowired
	private BusinessService businessServiceImpl;
	
	
	@ModelAttribute("categoriesList")
	public List<String> getCategories(){
		
		List<BusinessCategory> result = businessServiceImpl.findAllCategories();
		
		List<String> categoryName = new ArrayList<>();
		
		for(int i = 0; i < result.size(); i++) {
			
			categoryName.add(result.get(i).getBizCategoryName());
		}
		
		return categoryName;
		
	}
	
	@ModelAttribute("servicesList")
	public List<String> getBusinessServiceTypes(){
		
		List<BusinessServiceType> result = businessServiceImpl.findAllServices();
		
		List<String> serviceName = new ArrayList<>();
		
		for(int i = 0; i < result.size(); i++) {
			
			serviceName.add(result.get(i).getBizServiceName());
		}
		
		return serviceName;
	}
	
	@GetMapping("/form")
	public ModelAndView showBusinessForm() {
		
		return new ModelAndView("business-register-page", 
				"business", new Business());
		
	}
	
	@PostMapping("/process")
	public ModelAndView renderBizInfo(@ModelAttribute("business") Business business) {
		
		return null;
	}
	
	
	
}
