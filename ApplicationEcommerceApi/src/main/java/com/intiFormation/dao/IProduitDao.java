package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;


public interface IProduitDao extends JpaRepository<Produit, Integer>{
	
	public List<Produit> findByCategorie(Categorie categorie);
	public List<Produit> findByCategorie_nomCategorie(String nomcategorie);
	public Produit findByNomProduit(String nomProduit);
}
