package com.shopstack.controller.business;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.service.business.BusinessService;
import com.shopstack.service.businessuser.BussinessUserService;

@Controller 
@RequestMapping("/biz")
public class BusinessController {
	
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private BusinessService businessServiceImpl;
	
	@Autowired
	private BussinessUserService businessUserServiceImpl;
	
	
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
	
//	@PostMapping("/process")
//	public ModelAndView renderBizInfo(@ModelAttribute("business") Business business) {
//		
//		return null;
//	}
	
 	@RequestMapping(value = "/process", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request, @ModelAttribute("business") 
    		Business newBusiness, BindingResult resultBinder) {
 		
 		//get currently logged in user
        Principal principal = request.getUserPrincipal();
        String userEmail = principal.getName();
        
        logger.info("Currently loggged in user name is : "+ userEmail);
//        //Fetch user from the database
        BusinessUser existingUser = 
        		businessUserServiceImpl.findByEmail(userEmail);
        
        logger.info("Currently logged on user details is: "+ existingUser);
        
        //set currently logged in user as creator
        newBusiness.setCreator(existingUser);
        
        
        //save business
        logger.info("Saving new Business");
        businessServiceImpl.saveBusiness(newBusiness);	
        
        return "redirect:/user/dashboard";
	 }
	
	
	
}
