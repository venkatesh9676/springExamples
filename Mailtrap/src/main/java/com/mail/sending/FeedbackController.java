package com.mail.sending;

import javax.validation.ValidationException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	private EmailConfig emailConfig;
	
	
	public FeedbackController(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}
	
	@PostMapping("/send")
	public void sendFeedback( @RequestBody Feedback feedback,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid");
		}
		
		//create mail sender
				JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
				mailSender.setHost(this.emailConfig.getHost());
				mailSender.setPort(this.emailConfig.getPort());
				mailSender.setUsername(this.emailConfig.getUsername());
				mailSender.setPassword(this.emailConfig.getPassword());
		
		//Create an Email instance
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("a9f48db34c-69da82@inbox.mailtrap.io");
		mailMessage.setSubject("New Feedback from " +feedback.getName());
		mailMessage.setText(feedback.getFeedback());
		
		//Send mail 
		mailSender.send(mailMessage);
	}
}
