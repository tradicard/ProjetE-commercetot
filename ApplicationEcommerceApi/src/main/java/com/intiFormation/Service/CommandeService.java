package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.ICommandeDao;
import com.intiFormation.dao.IProduitDao;





@Service
public class CommandeService implements ICommandeService {
	
	@Autowired
	private ICommandeDao codao;
	
	
	
	public CommandeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Commande> findByUtilisateur(Utilisateur utilisateur){
		List<Commande> c= codao.findByUtilisateur(utilisateur);
		return c;
	}

	public Commande ajouterService(Commande co) {
	return	codao.save(co);
	}
	
	public Optional<Commande> selectByIdService(int id){
		Optional<Commande>op=codao.findById(id);
		return op;
	}
	
	public List<Commande> getAllService(){
		List<Commande> liste=codao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		codao.deleteById(id);
	}
	public void modifierService(Commande co) {
		codao.save(co);
	}

	public ICommandeDao getCodao() {
		return codao;
	}

	public void setCdao(ICommandeDao codao) {
		this.codao = codao;
	}
	
	
	
	

}
