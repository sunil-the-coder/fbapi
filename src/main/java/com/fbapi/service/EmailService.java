package com.fbapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public  EmailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
		
	}
	
	public void sendNotification(SimpleMailMessage message)throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(message.getTo());
		mail.setFrom(message.getFrom()); //"dvn.narewadkar@gmail.com"
		mail.setSubject(message.getSubject());
		mail.setText(message.getText());
		
		javaMailSender.send(mail);
		
	}

	
	
}
