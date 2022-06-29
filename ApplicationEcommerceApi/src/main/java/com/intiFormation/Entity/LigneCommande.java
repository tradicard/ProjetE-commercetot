package com.intiFormation.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLigneCommande;
	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.MERGE})
	@JoinColumn(name="idCommande")
	private Commande commande;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProduit")
	private Produit produit;
	private int quantite;

	
	
	public LigneCommande(int idLigneCommande) {
		super();
		this.idLigneCommande = idLigneCommande;
	}

	public LigneCommande(int idLigneCommande, Commande commande, Produit produit, int quantite) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}

	public LigneCommande(Commande commande, Produit produit, int quantite) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}

	public LigneCommande(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}


	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return " " + quantite + " " + produit.getNomProduit()+" ";
	}
	
	

}
