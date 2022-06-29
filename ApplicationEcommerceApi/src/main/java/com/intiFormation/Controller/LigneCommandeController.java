package com.intiFormation.Controller;

import java.util.ArrayList;
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
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.ICommandeService;
import com.intiFormation.Service.ILigneCommandeService;
import com.intiFormation.Service.ILignePanierService;
import com.intiFormation.Service.IPanierService;
import com.intiFormation.Service.IProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class LigneCommandeController {
	@Autowired
	ILignePanierService lps;
	@Autowired
	IPanierService pas;
	@Autowired
	IProduitService ps;
	@Autowired
	ILigneCommandeService lcs;
	@Autowired
	ICommandeService cos;
	
	@GetMapping("/lignesCommande")
	public List<LigneCommande> AfficherLigneCommande( ) {
		List<LigneCommande> listelp=lcs.getAllService();
		return listelp;
	}
	
	@GetMapping("/lignesCommandes/{id}")
	public List<LigneCommande> AfficherLigneCommandeParCommande( @PathVariable("id") int id) {
		List<LigneCommande> listelp=lcs.getAllBYCommande(id);
		return listelp;
	}
	
	@GetMapping("/lignesCommande/{id}")
	public LigneCommande AfficherLigneCommande(@PathVariable("id") int id ) {
		Optional<LigneCommande> op=lcs.selectByIdService(id);
		LigneCommande lc=new LigneCommande();
		if(op.isEmpty()) {
			lc=op.get();
		}
		return lc;
	}
	
	
	@PostMapping("/lignesCommande")
	public void SaveLigneCommande(@RequestBody LigneCommande lc, HttpSession s) {
		Produit p=new Produit();
		Optional<Produit> op=ps.selectByIdService(lc.getProduit().getIdProduit());
		if(op.isPresent()) {
			p=op.get();
		}
		p.setQuantite(p.getQuantite()-lc.getQuantite());
		lcs.ajouterService(lc);
	}
	
	@DeleteMapping("/lignesCommande/{id}")
	public void SupprimerLigneCommande(@PathVariable("id") int id) {;
		lcs.supprimerService(id);
	}
	

	
	@PutMapping("/lignesCommande")
	public void EditLigneCommande(@RequestBody LigneCommande p) {
		lcs.modifierService(p);
	}
	
	
	

}
