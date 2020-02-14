package com.shopstack.controller.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.shopstack.entities.businessuser.BusinessUser;

@Component
public class RegistrationListner implements ApplicationListener<OnRegistrationCompleteEvent> {

	
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private JavaMailSender mailSender;

		
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		// TODO Auto-generated method stub
		this.confirmRegistration(event);
		
	}
	
	
	
	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		
		System.out.println(event.getUser().getEmail());
		
		//generate token for user
		BusinessUser businessUser = event.getUser();
		String token = businessUser.getToken();
		
		
		//create confimation url
		String recepientAddress = businessUser.getEmail();
		String subject = "Registration Confimation";
		String confirmationUrl = event.getAppUrl() + "/user/confirm?token="+token;
        String message = messages.getMessage(
        		"Thank you for signing up to shopstack"
        		+ "\n"
        		+ "click the link below to verify your account\n ", null, event.getLocale());		
		//send email
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo(recepientAddress);
		email.setSubject(subject);
		email.setText(message +  "http://localhost:8080" + confirmationUrl);
		
		System.out.println(confirmationUrl);
		
		try {
			mailSender.send(email);
			System.out.println("Mail sent successfully");
		}catch(Exception mailException) {
			mailException.printStackTrace();
		}
				
		
	}

}
