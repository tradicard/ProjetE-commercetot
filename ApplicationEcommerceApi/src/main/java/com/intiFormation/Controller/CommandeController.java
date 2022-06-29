package com.intiFormation.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.ICommandeService;
import com.intiFormation.Service.IPanierService;
import com.intiFormation.Service.IProduitService;
import com.intiFormation.Service.IUtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class CommandeController {
	@Autowired
	IProduitService ps;
	@Autowired
	ICommandeService cos;
	@Autowired
	IPanierService pas;
	@Autowired
	IUtilisateurService us;
	
	@GetMapping("/commandes")
	public List<Commande> GestionCommande( ) {
		List<Commande> listeco=cos.getAllService();
		return listeco;
	}
	
	@GetMapping("/commandes/{id}")
	public Commande GestionCommande(@PathVariable("id") int id ) {
		Optional<Commande> op=cos.selectByIdService(id);
		Commande co=new Commande(id);
		if(op.isPresent()) {
			co=op.get();
		}
		return co;
	}
	
	@PostMapping("/commandes")
	public Commande SaveCommande(@RequestBody Commande co, HttpSession s) {
		
		
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		System.out.println(formattedDate);
		Utilisateur u=(Utilisateur)s.getAttribute("u");
		System.out.println(u);
		co.setDateCommande(formattedDate);
		Commande comm= cos.ajouterService(co);
		s.setAttribute("co",co);
		
		return comm;
	}
	
	
	
	
	@DeleteMapping("/commandes/{id}")
	public void SupprimerCommande(@PathVariable("id") int id) {
		cos.supprimerService(id);
	}
	
	
	@PutMapping("/commandes")
	public void EditCommande(@RequestBody Commande c) {
		cos.modifierService(c);
	}
	
	@GetMapping("/commandesuts/{username}")
	public List<Commande> GestionCommandeClient(HttpSession s) {
		Utilisateur u=(Utilisateur)s.getAttribute("u");
		List<Commande> listeco=cos.findByUtilisateur(u);
		return listeco;
	}

}
