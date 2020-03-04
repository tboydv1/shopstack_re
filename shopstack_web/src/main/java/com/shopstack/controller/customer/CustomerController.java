package com.shopstack.controller.customer;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.entities.customer.Customer;
import com.shopstack.service.businessoutlet.BusinessOutletServiceImpl;
import com.shopstack.service.customer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@Autowired
	private CustomerService customerService; 
	
	@Autowired
	private BusinessOutletServiceImpl businessOutletService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get the customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/form")
	public String showCustomeRegisterForm(Model myModel) {
		
	   myModel.addAttribute("customer", new Customer());
	   
		return "customer-form";
	}
   
   @PostMapping("/process")
	public String saveCustomer(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) { 
	   
	   BusinessOutlet existingOutlet = businessOutletService.findOutletById(7);
	   
	   
		
		logger.info("New customer form" + theCustomer);
		logger.info("Validating binding result");
		
		if(theBindingResult.hasErrors()) {
			
			return "customer-form";
		}
		else {
			
			if(existingOutlet != null) {
				theCustomer.setBusinessOutlet(existingOutlet);
			}
			customerService.saveCustomer(theCustomer);

			return "success-form";
		}
   }
   
   @GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
										Model theModel) {
		
		//get the customer from database
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form		
		return "customer-form";
		
	}
   
   @GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		//delete the customer
		customerService.deleteCustomer(theId);		
		
		//send over to our form		
		return "redirect:/customer/list";
		
	}
}
