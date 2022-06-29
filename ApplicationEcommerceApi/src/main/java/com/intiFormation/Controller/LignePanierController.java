package com.intiFormation.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.ILignePanierService;
import com.intiFormation.Service.IPanierService;
import com.intiFormation.Service.IProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class LignePanierController {
	@Autowired
	ILignePanierService lps;
	@Autowired
	IPanierService pas;
	@Autowired
	IProduitService ps;
	
	
	@GetMapping("/LignesPanier")
	public List<LignePanier> AfficherLignePanier() {
		List<LignePanier> listelp=lps.getAllService();
		return listelp;
	}
	
	@GetMapping("/LignesPanierParPanier/{id}")
	public List<LignePanier> AfficherLignePanierParPanier(@PathVariable("id") int idPanier) {
		List<LignePanier> listelp=lps.findByPanier_IdPanier(idPanier);
		System.out.println(listelp);
		return listelp;
	}
	
	@GetMapping("/LignesPanier/{id}")
	public LignePanier AfficherLignePanier(@PathVariable("id") int id) {
		Optional<LignePanier> op=lps.selectByIdService(id);
		LignePanier lp=new LignePanier();
		if(op.isPresent()) {
			lp=op.get();
		}
		return lp;
	}
	/*
	@PostMapping("/LignesPanier")
	public void SaveLignePanier(@RequestBody LignePanier p,@RequestParam("idProduit") int id2, @RequestParam("idPanier") int id ) {
		Optional<Panier> op=pas.selectByIdService(id);
		Panier pa=null;
		Optional<Produit> op2=ps.selectByIdService(id2);
		Produit pr=null;
		if(op.isEmpty()==false) {
			pa=op.get();
		}
		if(op2.isEmpty()==false) {
			pr=op2.get();
		}
		pa.getLignePaniers().add(p);
		p.setProduit(pr);
		lps.ajouterService(p);
	}
	*/
	
	@PostMapping("/LignesPanier")
	public void SaveLignePanier(@RequestBody LignePanier p) {
		lps.ajouterService(p);
	}
	
	@DeleteMapping("/LignesPanier/{id}")
	public void SupprimerLignePanier(@PathVariable("id") int id) {
		lps.supprimerService(id);

	}
	
	@PutMapping("/LignesPanier")
	public void EditLignePanier(@RequestBody LignePanier lp,HttpSession s) {
		lps.modifierService(lp);
	}
	
	
	

}
