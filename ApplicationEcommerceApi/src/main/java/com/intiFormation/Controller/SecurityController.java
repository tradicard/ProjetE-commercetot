package com.intiFormation.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.Entity.Role;
import com.intiFormation.Entity.Utilisateur;

@Controller
public class SecurityController {
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@RequestMapping("/afficherlogin")
	public String afficherForm(HttpSession s) {
		//String pass=bc.encode("1234");
		//System.out.println(pass);
		//return"redirect:/Authentication";
		//Utilisateur u =new Utilisateur();
		//m.addAttribute("u",u);
		Utilisateur u=(Utilisateur)s.getAttribute("u");
		if( u==null) {
			s.invalidate();
		}
		return"afficherAuth";
	}
	@RequestMapping("/refuse")
	public String refuse() {
		return"refuser";
	}
	/*
	 * @RequestMapping("traiterAuth") public String test(@RequestParam("username")
	 * String username, @RequestParam("password") String password){ return }
	 */
	

}
