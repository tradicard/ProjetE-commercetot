package com.intiFormation.Controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.MyConstants;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.Service.ICommandeService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmailController {
	 @Autowired
	   public JavaMailSender emailSender;
	 @Autowired
	 private ICommandeService cos;

	   // @ResponseBody
	    @GetMapping("/sendSimpleEmail")
	    public void sendSimpleEmail(HttpSession s) {
	    	//recup utilisateur et commande
	    	Utilisateur u=(Utilisateur)s.getAttribute("u");
	    	Commande co=(Commande)s.getAttribute("co");
	    	
	    	//Recuperation des lignes de la commande avec les lignes de commandes
	    	Optional<Commande>op=cos.selectByIdService(co.getIdCommande());
	    	if(op.isPresent()) {
	    		co=op.get();
	    	}
	    	
	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	        //receveur
	        message.setTo(u.getMail());
	        //sujet
	        message.setSubject("Commande");
	        //message.setText(cos.findByUtilisateur(u).toString());
	        //contenu
	        message.setText(co.toString());

	        // Send Message!
	        this.emailSender.send(message);

	    }
	    
	    //@ResponseBody
	    @RequestMapping("/sendAttachmentEmail")
	    public String sendAttachmentEmail(HttpSession s) throws MessagingException {

	        MimeMessage message = emailSender.createMimeMessage();
	        Utilisateur u=(Utilisateur)s.getAttribute("u");
	        boolean multipart = true;

	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

	        helper.setTo(u.getMail());
	        helper.setSubject("Test email with attachments");
	        
	        helper.setText("Hello, Im testing email with attachments!");
	        
	        String path1 = "/home/tran/Downloads/test.txt";
	        String path2 = "/home/tran/Downloads/readme.zip";

	        // Attachment 1
	        FileSystemResource file1 = new FileSystemResource(new File("/scr/main/webapp/imageproduit/Pantalon.jp"));
	        helper.addAttachment("Txt file", file1);

	        // Attachment 2
	        //FileSystemResource file2 = new FileSystemResource(new File(path2));
	        //helper.addAttachment("Readme", file2);

	        emailSender.send(message);

	        return "Email Sent!";
	    }
	    
	    //@ResponseBody
	    @RequestMapping("/sendHtmlEmail")
	    public String sendHtmlEmail(HttpSession s) throws MessagingException {
	    	Utilisateur u=(Utilisateur)s.getAttribute("u");
	        MimeMessage message = emailSender.createMimeMessage();

	        boolean multipart = true;
	        
	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
	        
	        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
	                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
	        
	        message.setContent(htmlMsg, "text/html");
	        
	        helper.setTo(u.getMail());
	        
	        helper.setSubject("Test send HTML email");
	        
	    
	        this.emailSender.send(message);

	        return "Email Sent!";
	    }
}
