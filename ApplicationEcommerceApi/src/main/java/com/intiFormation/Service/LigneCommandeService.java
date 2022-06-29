package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.Produit;
import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.ICommandeDao;
import com.intiFormation.dao.ILigneCommandeDao;
import com.intiFormation.dao.IProduitDao;





@Service
public class LigneCommandeService implements ILigneCommandeService {
	
	@Autowired
	private ILigneCommandeDao lcdao;
	
	
	
	public LigneCommandeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(LigneCommande lc) {
		lcdao.save(lc);
	}
	
	public Optional<LigneCommande> selectByIdService(int id){
		Optional<LigneCommande>op=lcdao.findById(id);
		return op;
	}
	
	public List<LigneCommande> getAllService(){
		List<LigneCommande> liste=lcdao.findAll();
		return liste;
		
	}
	public List<LigneCommande> getAllBYCommande(int idCommande){
		List<LigneCommande> liste=lcdao.findByCommande_IdCommande(idCommande);
		return liste;
		
	}
	public void supprimerService(int id) {
		lcdao.deleteById(id);
	}
	public void modifierService(LigneCommande lc) {
		lcdao.save(lc);
	}

	public ILigneCommandeDao getLcdao() {
		return lcdao;
	}

	public void setLcdao(ILigneCommandeDao lcdao) {
		this.lcdao = lcdao;
	}
	
	
	
	

}
