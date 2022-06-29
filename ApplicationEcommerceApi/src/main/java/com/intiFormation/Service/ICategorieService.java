package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;



public interface ICategorieService {
	
	public void modifierService(Categorie c);
	public void supprimerService(int id);
	public List<Categorie> getAllService();
	public Optional<Categorie> selectByIdService(int id);
	public void ajouterService(Categorie c);

}
