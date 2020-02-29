package com.shopstack.controller.business;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessOutlet;
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

	private List<Business> savedBusinesses;

	private List<BusinessOutlet> outlets;
	
	@GetMapping("/home")
	public String showBusinessList(HttpServletRequest request, Model model) {

		BusinessUser activeUser = getCurrentUser(request.getUserPrincipal());

		savedBusinesses = new ArrayList<>();

		for(Business userBusiness: activeUser.getBusiness()){

			savedBusinesses.add(userBusiness);
		}

		model.addAttribute("businessList", savedBusinesses);
		
		return "business-dashboard";
	}
	
	
	@ModelAttribute("categoriesList")
	public List<String> getCategories()
	{
		
		logger.info("Fetching list of categories from the database");
		
		categories = businessServiceImpl.findAllCategories();
		
		List<String> categoryName = new ArrayList<>();
		
		for(int i = 0; i < categories.size(); i++) {
			
			categoryName.add(categories.get(i).getBizCategoryName());
		}
		
		return categoryName;
		
	}
	
	@ModelAttribute("servicesList")
	public List<String> getBusinessServiceTypes()
	{
		
		logger.info("Fetching list of services from the database");
		
		serviceTypes = businessServiceImpl.findAllServices();
		
		List<String> serviceName = new ArrayList<>();
		
		for(int i = 0; i < serviceTypes.size(); i++) {
			
			serviceName.add(serviceTypes.get(i).getBizServiceName());
		}
		
		return serviceName;
	}
	
	@GetMapping("/form")
	public ModelAndView showBusinessForm() 
	{
		
		return new ModelAndView("business-form-page", 
				"business", new Business());
		
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String saveNewBusiness(HttpServletRequest request, @ModelAttribute("business") 
			Business newBusiness, BindingResult resultBinder) 
	{
		
		logger.info("New business entry -->> " + newBusiness);
	
		if(resultBinder.hasErrors()) {
			
			return "redirect:/biz/form";
		}
		
		Principal principal = null;
		String userEmail = null;

		//get currently logged in user
		if(request.getUserPrincipal() != null) {

			BusinessUser existingUser = getCurrentUser(request.getUserPrincipal());

		    logger.info("Currently logged on user details is: "+ existingUser);
		
		//set currently logged in user as creator
		newBusiness.setCreator(existingUser);
		
		}
		else {
			return "redirect:/login";
		}
		
		if(newBusiness.getBizCategory().getBizCategoryName() != null || 
				newBusiness.getBizService().getBizServiceName() != null) {
			
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
		}
		else {
			return "redirect:/biz/form";
		}
		    
		    //save business
		    logger.info("Saving new Business");
		    businessServiceImpl.saveBusiness(newBusiness);	
		
		return "redirect:/biz/home";
	 }
 	
// 	public String listOutlets() {
// 		
// 		List<BusinessOutlet> outlets = businessServiceImpl.
// 	}
 	
 	@GetMapping("/outlet/list")
 	public String showOutletList(@RequestParam("bizId") int id, Model model) {

		outlets = new ArrayList<>();

		for(Business business: savedBusinesses){

			if(business.getBizId() == id){

				for(BusinessOutlet outlet: business.getBusinessOutlets())
						outlets.add(outlet);
			}
		}

		model.addAttribute("outlets", outlets);

 		return "list-outlets";
 	}

 	@GetMapping("/outlet/home")
	public String showOutletHome(@RequestParam("outletId") int outletId, Model model){

		BusinessOutlet currentOutlet = null;

		for(BusinessOutlet outlet: outlets){
			if(
					outlet.getOutletId() == outletId
			){
				currentOutlet = outlet;
			}
		}

		model.addAttribute("currentOutlet", currentOutlet);

		return "business-outlet-dashboard";
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
 		}
 		
 		return null;
 	}
 	
	public Integer findBusinessCategoryId(String category) {
		
		System.out.println(category);
		if(this.categories == null) {
			getCategories();
		}
		
		for(BusinessCategory categoryObj:categories) {
			
			if (categoryObj.getBizCategoryName().equals(category)) {
				
				System.out.println(categoryObj.getBizCategoryid());
				return categoryObj.getBizCategoryid();
			}
			
		}
		
		return null;
	
	
	}

	public BusinessUser getCurrentUser(Principal principal){

		BusinessUser currentUser = null;

		if(principal != null){

			logger.info("Currently loggged in user name is : "+ principal.getName());

			//Fetch user from the database
			currentUser = businessUserServiceImpl.findByEmail(principal.getName());


		}

		return currentUser;



	}
 	
}
