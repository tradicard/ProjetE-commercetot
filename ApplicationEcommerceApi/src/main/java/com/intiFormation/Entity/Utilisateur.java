package com.intiFormation.Entity;

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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String username;
	private String password;
	private String mail;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idRole")
	private Role role;
	@OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<Commande> commandes;
	
	
	
	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String username, String password,
			String mail, Role role, List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.role = role;
		this.commandes = commandes;
	}
	public Utilisateur(String nom, String prenom, String dateNaissance, String username, String password, String mail,
			Role role, List<Commande> commandes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.role = role;
		this.commandes = commandes;
	}
	public Utilisateur(String nom, String prenom, String dateNaissance, String username, String password, String mail,
			Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.role = role;
	}
	public Utilisateur(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
	}
	public Utilisateur(String nom, String prenom, String dateNaissance, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
	}
	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String login, String password,
			Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
		this.role = role;
	}
	public Utilisateur(String nom, String prenom, String dateNaissance, String login, String password, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
		this.role = role;
	}
	public Utilisateur(String nom, String prenom, String dateNaissance, String login, String password, Role role,
			List<Commande> commandes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
		this.role = role;
		this.commandes = commandes;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String login, String password,
			Role role, List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.username = login;
		this.password = password;
		this.role = role;
		this.commandes = commandes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", username=" + username + ", password=" + password + ", mail=" + mail + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
