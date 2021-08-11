package com.kafeel.tracetheip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender emailSender;
	
	@Value(value="${spring.mail.sendTo}")
	private String sendTo;
	@Override
	public void sendMail(String text) {
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@kafeel.com");
        
        message.setTo(sendTo); 
        message.setSubject("IP Traced"); 
        message.setText(text);
        
        emailSender.send(message);
	}

}
