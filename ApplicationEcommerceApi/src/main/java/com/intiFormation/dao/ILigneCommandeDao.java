package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.LignePanier;

public interface ILigneCommandeDao extends JpaRepository<LigneCommande, Integer>{
	public List<LigneCommande> findByCommande_IdCommande(int idCommande);
}
