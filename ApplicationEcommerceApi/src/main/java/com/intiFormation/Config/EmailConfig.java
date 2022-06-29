package com.intiFormation.Config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.intiFormation.Entity.MyConstants;

@Configuration
public class EmailConfig {
	
	@Bean
    public JavaMailSender getJavaMailSender() {
		
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //a trouver en cherchant sur internet
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        
        //recuperation de l'email et mot de passe
        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);
        
        //Proprietes de l'email
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
