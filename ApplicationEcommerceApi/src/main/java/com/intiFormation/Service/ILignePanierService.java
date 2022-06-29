package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Produit;



public interface ILignePanierService {
	
	public void modifierService(LignePanier lp);
	public void supprimerService(int id);
	public List<LignePanier> getAllService();
	public Optional<LignePanier> selectByIdService(int id);
	public void ajouterService(LignePanier lp);
	public List<LignePanier> findByPanier_IdPanier(int idPanier);

}
