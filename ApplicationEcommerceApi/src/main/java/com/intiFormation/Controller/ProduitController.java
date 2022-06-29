package com.intiFormation.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.IProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ProduitController {
	@Autowired
	IProduitService ps;
	@Autowired
	ICategorieService cs;
	
	@GetMapping("/produits")
	public List<Produit> AfficherProduits(Model m ) {
		List<Produit> liste=ps.getAllService();

		return liste;
	}
	
	@GetMapping("/produits/{id}")
	public Produit cherche(@PathVariable("id") int id) {
		Optional<Produit> op=ps.selectByIdService(id);
		Produit c=new Produit();
		if (op.isPresent()) {
			c=op.get();
		}
		return c;
	}
	
	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file,@RequestParam ("nomProduit") String nomProduit, HttpSession s ) {
		
		
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;  
		Produit p=ps.findByNom(nomProduit);
		p.setImg("imageproduit\\"+filename);
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	}
		
	}
	
	
	@PostMapping("/produits")
	public void SaveProduit(@RequestParam("file") MultipartFile file, @RequestParam ("nomProduit") String nomProduit,@RequestParam ("idcat") int idcat,@RequestParam ("quantite") int quantite,HttpSession s ) {
		System.out.println("tout ok!!!!!");
		Produit p=new Produit(nomProduit,quantite);
		Optional<Categorie> op=cs.selectByIdService(idcat);
		if(op.isPresent()) {
			Categorie c=op.get();
			p.setCategorie(c);
		}
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;  
		p.setImg("imageproduit\\"+filename);
		
		//uploadFile(file, s);
		ps.ajouterService(p);
		
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	}
	        	
		
	}

	@DeleteMapping("/produits/{id}")
	public void SupprimerProduit(@PathVariable("id") int id) {
		ps.supprimerService(id);
	}
	
	
	@PutMapping("produits")
	public void EditProduit(@RequestParam ("idcat") int idcat, @RequestParam ("id") int id, @RequestParam ("nomProduit") String nomProduit,@RequestParam ("quantite") int quantite,@RequestParam("file") MultipartFile file,HttpSession s ) {	
		Produit p=new Produit(id,nomProduit,quantite);
		Optional<Categorie> op=cs.selectByIdService(idcat);
		if(op.isPresent()) {
			Categorie c=op.get();
			p.setCategorie(c);
		}
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;  
		p.setImg("imageproduit\\"+filename);
		
		//uploadFile(file, s);
		ps.ajouterService(p);
		
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	}
	}
	
	
	@GetMapping("produitscats/{idcat}")
	public List<Produit> ProduitparCat(@PathVariable("idcat") int id) {
	Categorie c=null;
	Optional<Categorie> op=cs.selectByIdService(id);
	System.out.println(id);
	if(op.isEmpty()==false) {
	 c=op.get();
	}
	List<Produit>listep=ps.getByCategorie(c);
	return listep;
	}
	
	
	@GetMapping("/produitsch/{cherche}")
	public List<Produit> Recherche(@PathVariable("cherche") String ch) {
		List<Produit>liste=ps.getAllService();
		List<Produit>listch=new ArrayList<>();
		for(int i=0;i<liste.size();i++) {
			if(liste.get(i).getNomProduit().toLowerCase().contains(ch.toLowerCase())) {
				listch.add(liste.get(i));
			}
		}

		return listch;
	}
	
}
