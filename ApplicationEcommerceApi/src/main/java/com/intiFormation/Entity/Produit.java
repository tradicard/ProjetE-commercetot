package com.intiFormation.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduit;
	private String nomProduit;
	private String img;
	private int quantite;
	@OneToMany(mappedBy = "produit",cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
	@JsonIgnore
	private List<LigneCommande> lignecommande;
	@OneToMany(mappedBy = "produit",cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
	@JsonIgnore
	private List<LignePanier> lignepanier;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	
	

	
	
	public Produit(int idProduit, String nomProduit, int quantite) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.quantite = quantite;
	}



	public Produit(String nomProduit, int quantite) {
		super();
		this.nomProduit = nomProduit;
		this.quantite = quantite;
	}



	public List<LigneCommande> getLignecommande() {
		return lignecommande;
	}



	public void setLignecommande(List<LigneCommande> lignecommande) {
		this.lignecommande = lignecommande;
	}



	public List<LignePanier> getLignepanier() {
		return lignepanier;
	}



	public void setLignepanier(List<LignePanier> lignepanier) {
		this.lignepanier = lignepanier;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Produit(int idProduit, String nomProduit, String img, int quantite, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}



	public Produit(String nomProduit, String img, int quantite, List<LignePanier> lignepanier, Categorie categorie) {
		super();
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
		this.lignepanier = lignepanier;
		this.categorie = categorie;
	}







	public Produit(String nomProduit, String img, int quantite, Categorie categorie) {
		super();
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}



	public Produit(int idProduit, String nomProduit, String img, int quantite) {

		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
	}
	
	
	







	public Produit(int idProduit, String nomProduit, String img, int quantite, List<LigneCommande> lignecommande) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
		this.lignecommande = lignecommande;
	}



	public Produit(String nomProduit, String img, int quantite, List<LigneCommande> lignecommande) {
		super();
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
		this.lignecommande = lignecommande;
	}



	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Produit(String nomProduit, String img, int quantite) {
		super();
		this.nomProduit = nomProduit;
		this.img = img;
		this.quantite = quantite;
	}



	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", NomProduit=" + nomProduit + ", img=" + img + ", quantite="
				+ quantite + "]";
	}

	
	

}
