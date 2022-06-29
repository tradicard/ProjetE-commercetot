package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;



public interface ICommandeService {
	
	public void modifierService(Commande co);
	public void supprimerService(int id);
	public List<Commande> getAllService();
	public Optional<Commande> selectByIdService(int id);
	public Commande ajouterService(Commande co);
	public List<Commande> findByUtilisateur(Utilisateur utilisateur);

}
