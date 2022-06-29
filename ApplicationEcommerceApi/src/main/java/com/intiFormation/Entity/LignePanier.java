package com.intiFormation.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LignePanier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLignePanier;
	//private Panier panier;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProduit")
	private Produit produit;
	private int  quantite;
	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.MERGE})
	@JoinColumn(name="idPanier")
	private Panier panier;
	
	
	
	
	public LignePanier(int idLignePanier, Produit produit, int quantite, Panier panier) {
		super();
		this.idLignePanier = idLignePanier;
		this.produit = produit;
		this.quantite = quantite;
		this.panier = panier;
	}
	public LignePanier(Produit produit, int quantite, Panier panier) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.panier = panier;
	}
	public LignePanier(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}
	public LignePanier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdLignePanier() {
		return idLignePanier;
	}
	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
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
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", produit=" + produit + ", quantite=" + quantite
				+ ", panier=" + panier.getIdPanier() + "]";
	}
	
	

}
