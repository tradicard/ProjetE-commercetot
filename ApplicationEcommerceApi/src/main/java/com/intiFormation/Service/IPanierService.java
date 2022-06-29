package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;



public interface IPanierService {
	
	public void modifierService(Panier pa);
	public void supprimerService(int id);
	public List<Panier> getAllService();
	public Optional<Panier> selectByIdService(int id);
	public void ajouterService(Panier pa);

}
