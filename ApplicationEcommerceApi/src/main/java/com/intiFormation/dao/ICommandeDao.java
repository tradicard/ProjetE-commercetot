package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;

public interface ICommandeDao extends JpaRepository<Commande, Integer>{
	
	public List<Commande> findByUtilisateur(Utilisateur utilisateur);

}
