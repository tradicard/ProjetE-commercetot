package com.intiFormation.Entity;

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
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String librole;
	private String description;
	@OneToMany(mappedBy = "role",fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
	@JsonIgnore
	private List<Utilisateur> utilisateurs;
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(String librole, String description, List<Utilisateur> utilisateurs) {
		super();
		this.librole = librole;
		this.description = description;
		this.utilisateurs = utilisateurs;
	}


	public Role(int idRole, String librole, String description) {

		this.librole = librole;
		this.description = description;
	}
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getLibrole() {
		return librole;
	}
	public void setLibrole(String librole) {
		this.librole = librole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", librole=" + librole + ", description=" + description + ", utilisateurs="
				+ utilisateurs + "]";
	}
	
	

}
