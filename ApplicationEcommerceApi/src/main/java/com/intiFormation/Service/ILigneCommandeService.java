package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.Produit;



public interface ILigneCommandeService {
	
	public void modifierService(LigneCommande lc);
	public void supprimerService(int id);
	public List<LigneCommande> getAllService();
	public Optional<LigneCommande> selectByIdService(int id);
	public void ajouterService(LigneCommande lc);
	public List<LigneCommande> getAllBYCommande(int idCommande);

}
