package com.intiFormation.Entity;

import java.lang.reflect.Array;
import java.time.LocalDate;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	private String dateCommande;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "commande",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<LigneCommande> ligneCommandes;

	
	
	public Commande(int idCommande) {
		super();
		this.idCommande = idCommande;
	}

	public Commande(int idCommande, String dateCommande, Utilisateur utilisateur, List<LigneCommande> ligneCommandes) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.utilisateur = utilisateur;
		this.ligneCommandes = ligneCommandes;
	}

	public Commande(String dateCommande, Utilisateur utilisateur) {
		super();
		this.dateCommande = dateCommande;
		this.utilisateur = utilisateur;
	}

	public Commande(String dateCommande, Utilisateur utilisateur, List<LigneCommande> ligneCommandes) {
		super();
		this.dateCommande = dateCommande;
		this.utilisateur = utilisateur;
		this.ligneCommandes = ligneCommandes;
	}

	public Commande(String dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(int idCommande, String dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(String dateCommande, List<LigneCommande> ligneCommandes) {
		super();
		this.dateCommande = dateCommande;
		this.ligneCommandes = ligneCommandes;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}


	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

	@Override
	public String toString() {
		return "Votre Commande : ID=" + idCommande + ", date de la commande=" + dateCommande
				+ ", Produits achetes= ["+ ligneCommandes+"]";
	}
	
	
	
	
	

}
