package com.intiFormation.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategorie;
	private String nomCategorie;
	private String description;
	@OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@JsonIgnore
	private List<Produit> produitsc;
	


	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Categorie(int idCategorie, String nomCategorie, String description, List<Produit> produitsc) {

		this.nomCategorie = nomCategorie;
		this.description = description;
		this.produitsc = produitsc;
	}



	public Categorie(String nomCategorie, String description, List<Produit> produitsc) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.produitsc = produitsc;
	}



	public Categorie(int idCategorie, String nomCategorie, String description) {
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Produit> getProduitsc() {
		return produitsc;
	}
	public void setProduitsc(List<Produit> produitsc) {
		this.produitsc = produitsc;
	}



	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
				+ description +  ", produitsc=" + produitsc + "]";
	}
	
	
	
	

}
