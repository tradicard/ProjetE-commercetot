package com.intiFormation.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.ILignePanierService;
import com.intiFormation.Service.IPanierService;
import com.intiFormation.Service.IProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class PanierController {
	@Autowired
	IPanierService pas;
	@Autowired
	ILignePanierService lps;
	@Autowired
	IProduitService ps;
	
	
	@GetMapping("/paniers")
	public List<Panier> AfficherPanier(Model m ) {
		List<Panier> liste=pas.getAllService();
		return liste;
	}
	
	@GetMapping("/paniers/{id}")
	public Panier AfficherPanier(@PathVariable("id") int id ) {
		Optional<Panier> op=pas.selectByIdService(id);
		Panier p=new Panier();
		if(op.isPresent()) {
			p=op.get();
		}
		return p;
	}
	
	@PostMapping("/paniers")
	public void AjoutePanier(@RequestBody Panier p, HttpSession s) {
		s.setAttribute("pan", p);
		pas.ajouterService(p);
	}

	
	@GetMapping("/verif")
	public void Verif(@RequestBody Panier p, HttpSession s) {
	
	for(int i=0;i<p.getLignePaniers().size();i++) {
		for(int j=0;j<p.getLignePaniers().size();j++) {
		if(i!=j && p.getLignePaniers().get(i).getProduit()==p.getLignePaniers().get(j).getProduit()) {
			boolean error2=true;
			s.setAttribute("error2", error2);
		}
		}
	}
	for(int k=0;k<p.getLignePaniers().size();k++) {
		if(p.getLignePaniers().get(k).getQuantite()>p.getLignePaniers().get(k).getProduit().getQuantite()) {
			boolean error=true;
			s.setAttribute("error", error);
		}
	}
	}
	
	
	@DeleteMapping("/paniers/{id}")
	public void SupprimerPanier(@PathVariable("id") int id) {
		pas.supprimerService(id);
	}
	

	
	@PutMapping("/paniers")
	public void EditPanier(@RequestBody Panier p, HttpSession s) {
		s.setAttribute("panier", p);
		pas.modifierService(p);
	}
	
	@DeleteMapping("/paniers")
	public void EcraserPanier(HttpSession s) {
		Panier pa=(Panier)s.getAttribute("pan");
	
	pas.supprimerService(pa.getIdPanier());
	s.removeAttribute("pan");
	//return "redirect:/sendSimpleEmail";
	}
	
}
