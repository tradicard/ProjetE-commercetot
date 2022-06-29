package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;



public interface IProduitService {
	
	public void modifierService(Produit p);
	public void supprimerService(int id);
	public List<Produit> getAllService();
	public Optional<Produit> selectByIdService(int id);
	public void ajouterService(Produit p);
	public List<Produit> getByCategorie(Categorie categorie);
	public Produit findByNom(String nomProduit);

}
