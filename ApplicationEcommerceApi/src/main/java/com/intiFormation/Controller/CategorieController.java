package com.intiFormation.Controller;

import java.util.List;
import java.util.Optional;

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
import com.intiFormation.Entity.Produit;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.IProduitService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class CategorieController {
	@Autowired
	IProduitService ps;
	@Autowired
	ICategorieService cs;
	
	@GetMapping("/categories")
	public List<Categorie> GestionCategorie() {
		List<Categorie> listec=cs.getAllService();
		return listec;
	}
	
	@GetMapping("/categories/{id}")
	public Categorie GestionCategorie(@PathVariable("id") int id) {
		Optional<Categorie> op=cs.selectByIdService(id);
		Categorie c=new Categorie();
		if (op.isPresent()) {
			c=op.get();
		}
		return c;
	}
	
	@PostMapping("/categories")
	public void SaveCategorie(@RequestBody Categorie c) {
		cs.ajouterService(c);
	}
	
	
	
	
	@DeleteMapping("/categories/{id}")
	public void SupprimerCategorie(@PathVariable("id") int id) {
		cs.supprimerService(id);
	}
	
	
	
	@PutMapping("/categories")
	public void EditCategorie(@RequestBody Categorie c) {
		cs.modifierService(c);
	}


}
