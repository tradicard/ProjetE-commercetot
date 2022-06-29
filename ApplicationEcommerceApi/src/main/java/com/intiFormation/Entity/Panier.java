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
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPanier;
	@OneToMany(mappedBy = "panier",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<LignePanier> lignePaniers;
	
	
	
	
	public Panier(ArrayList<LignePanier> lignePaniers) {
		super();
		this.lignePaniers = lignePaniers;
	}
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}
	public void setLignePaniers(List<LignePanier> lignePaniers) {
		this.lignePaniers = lignePaniers;
	}
	
	

}
