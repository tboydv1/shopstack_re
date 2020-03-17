package com.shopstack.controller.businessuser;


import java.util.List;
import java.util.logging.Logger;



import com.shopstack.model.businessuser.BusinessUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.controller.event.OnRegistrationCompleteEvent;

import com.shopstack.service.businessuser.BussinessUserService;

@RestController
@RequestMapping("/user")
public class BusinessUserController {

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private BussinessUserService businessUserServiceImpl;

	@GetMapping("/all")
	public List<BusinessUser> getAllUsers(){

		return businessUserServiceImpl.findAll();
	}
	
//	@GetMapping("/register")
//	public String showRegistrationForm(Model model) {
//
//		model.addAttribute("user", new BusinessUser());
//		return "user-register-page";
//	}
	
//	@GetMapping("/process")
//	public ModelAndView processRegistration(WebRequest request,
//			@ModelAttribute("user") @Valid BusinessUser businessUser,
//			BindingResult resultBinder, Errors errors) {
//
//		System.out.println("New Request -->> " + businessUser);
//
//		BusinessUser registered = new BusinessUser();
//
//
//		if(resultBinder.hasErrors()) {
//			System.out.println("Requst has errors");
//			return new ModelAndView("register-page", "user", new BusinessUser());
//		}
//
//		//generate token for new user
//		businessUserServiceImpl.generateUserToken(businessUser);
//
//		registered = createUserAccount(businessUser, resultBinder);
//
//
//		if(registered == null) {
//			logger.info("Email exists");
//			return new ModelAndView("register-page", "user", new BusinessUser());
//		}
//
//		try {
//			String appUrl = request.getContextPath();
//			eventPublisher.publishEvent(new OnRegistrationCompleteEvent
//					(businessUser, request.getLocale(), appUrl));
//		}catch(RuntimeException runtime) {
//
//			runtime.printStackTrace();
//			return new ModelAndView("emailError", "user", new BusinessUser());
//		}
//
//
//
//		return new ModelAndView("confirmation","user_email", registered.getEmail());
//	}
	
//	@GetMapping("/confirm")
//	public String confirmRegistration(WebRequest request, Model model,
//			@RequestParam("token") String token) {
//
//
//		BusinessUser existingUser = businessUserServiceImpl.findByToken(token);
//
//		if(existingUser == null) {
//			model.addAttribute("user","invalid user");
//			return "user-expired";
//		}
//
//		businessUserServiceImpl.activateUser(existingUser);
//
//		return "login";
//	}
	
	
//	private BusinessUser createUserAccount(BusinessUser businessUser, BindingResult result) {
//
//	    BusinessUser registered = null;
//	    try {
//	        registered = businessUserServiceImpl.registerNewUserAccount(businessUser, "ROLE_ADMIN");
//
//	    } catch (Exception e) {
//
//	        return null;
//	    }
//	    return registered;
//	}
	

   
}
