package com.intiFormation.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Entity.Role;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.Service.IRoleService;
import com.intiFormation.Service.IUtilisateurService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class UtilisateurController {
	@Autowired
	IUtilisateurService us;
	@Autowired
	IRoleService rs;
	@Autowired
	BCryptPasswordEncoder bc;
	
	
	@PostMapping("/utilisateurs")
	public void SaveUtilisateur( @RequestBody Utilisateur u) {
		List<Utilisateur> uts=us.getAllService();
		for(int i=0;i<uts.size();i++) {
			if (uts.get(i).getUsername()==u.getUsername()) {
				break;
			}
		}
		
		Optional<Role> op=rs.selectByIdService(2);
		Role r=op.get();
		String pass=u.getPassword();
		pass=bc.encode(pass);
		u=new Utilisateur(u.getNom(),u.getPrenom(),u.getDateNaissance(),u.getUsername(),pass,u.getMail(),r);
		us.ajouterService(u);
		
	}
	
	@GetMapping("/utilisateurs")
	public List<Utilisateur> listUtilisateur(){
		List<Utilisateur> uts=us.getAllService();
		return uts;
	}
	
	@GetMapping("/utilisateurs/{username}")
	public Utilisateur listUtilisateur(@PathVariable("username") String username){
		Utilisateur uts=us.chercherParUsername(username);
		return uts;
	}
	
	@DeleteMapping("/utilisateurs/{id}")
	public void ajouteUtil(@PathVariable("id") int id) {
		us.supprimerService(id);
	}
	
	@RequestMapping("Deconnection")
	public void Deconnection( HttpSession s) {
		 s.invalidate();
	}

}
