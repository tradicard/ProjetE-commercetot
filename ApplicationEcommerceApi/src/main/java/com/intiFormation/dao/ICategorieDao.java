package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;


public interface ICategorieDao extends JpaRepository<Categorie, Integer>{
	

	

}
