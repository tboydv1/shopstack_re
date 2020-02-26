package com.shopstack.controller.business;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.service.business.BusinessService;
import com.shopstack.service.businessuser.BussinessUserService;


/**
 * @author tobi
 *
 */

@Controller 
@RequestMapping("/biz")
public class BusinessController {
	
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private BusinessService businessServiceImpl;
	
	@Autowired
	private BussinessUserService businessUserServiceImpl;
	
	private List<BusinessCategory> categories;
	
	private List<BusinessServiceType> serviceTypes;
	
	@GetMapping("/list")
	public String showBusinessList() {
		
//		List<Business> savedBusinesses 
		
		
		return null;
	}
	
	
	@ModelAttribute("categoriesList")
	public List<String> getCategories(){
		
		logger.info("Fetching list of categories from the database");
		
		categories = businessServiceImpl.findAllCategories();
		
		List<String> categoryName = new ArrayList<>();
		
		for(int i = 0; i < categories.size(); i++) {
			
			categoryName.add(categories.get(i).getBizCategoryName());
		}
		
		return categoryName;
		
	}
	
	@ModelAttribute("servicesList")
	public List<String> getBusinessServiceTypes(){
		
		logger.info("Fetching list of services from the database");
		
		serviceTypes = businessServiceImpl.findAllServices();
		
		List<String> serviceName = new ArrayList<>();
		
		for(int i = 0; i < serviceTypes.size(); i++) {
			
			serviceName.add(serviceTypes.get(i).getBizServiceName());
		}
		
		return serviceName;
	}
	
	@GetMapping("/form")
	public ModelAndView showBusinessForm() {
		
		
		
		return new ModelAndView("business-register-page", 
				"business", new Business());
		
	}
	

	
 	@RequestMapping(value = "/process", method = RequestMethod.GET)
    public String currentUserNameSimple(HttpServletRequest request, @ModelAttribute("business") 
    		Business newBusiness, BindingResult resultBinder) {
 		
 		logger.info("New business entry -->>" + newBusiness);
 		
 		//get currently logged in user
        Principal principal = request.getUserPrincipal();
        String userEmail = principal.getName();
        
        logger.info("Currently loggged in user name is : "+ userEmail);
       //Fetch user from the database
        BusinessUser existingUser = 
        		businessUserServiceImpl.findByEmail(userEmail);
        
        logger.info("Currently logged on user details is: "+ existingUser);
        
        //set currently logged in user as creator
        newBusiness.setCreator(existingUser);
        
        logger.info("find business category type id for " + newBusiness.getBizCategory().getBizCategoryName());
        Integer categoryId = findBusinessCategoryId(newBusiness.getBizCategory().getBizCategoryName());
       
        logger.info("Category id --> " + categoryId);
        
        if(categoryId != null)
        	newBusiness.getBizCategory().setBizCategoryid(categoryId);
        
        logger.info("find business service id for " + newBusiness.getBizService().getBizServiceName());
        Integer serviceId = findByServiceTypeId(newBusiness.getBizService().getBizServiceName());
        
        logger.info("Service id --> " + serviceId);
        if(serviceId != null)	
        	newBusiness.getBizService().setBizServiceId(serviceId);
        
        //save business
        logger.info("Saving new Business");
        businessServiceImpl.saveBusiness(newBusiness);	
        
        return "redirect:/user/dashboard";
	 }
 	
 	public Integer findByServiceTypeId(String serviceType) {
 		
 		System.out.println(serviceType);
 		if(this.serviceTypes == null) {
 			getBusinessServiceTypes();
 			
 			System.out.println("null service types");
 		}
 		
 		for(BusinessServiceType serviceObj: serviceTypes) {
 			
 			if(serviceObj.getBizServiceName().equals(serviceType)) {
 				
 				
 				return serviceObj.getBizServiceId();
 			}
 			System.out.println("id's" +serviceObj.getBizServiceId());
 		}
 		
 		return null;
 	}
 	
 	public Integer findBusinessCategoryId(String category) {
		
 		System.out.println(category);
 		if(this.categories == null) {
 			getCategories();
 			
 			System.out.println("Null categories");
 		}
 		
 		for(BusinessCategory categoryObj:categories) {
 			
 			if (categoryObj.getBizCategoryName().equals(category)) {
				
 				System.out.println(categoryObj.getBizCategoryid());
 				return categoryObj.getBizCategoryid();
			}
 			System.out.println("id's" +categoryObj.getBizCategoryid());
 		}
 		
 		return null;
	
	
 	}	
}
