package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Utilisateur;

public interface ILignePanierDao extends JpaRepository<LignePanier, Integer>{
	public List<LignePanier> findByPanier_IdPanier(int idPanier);

}
