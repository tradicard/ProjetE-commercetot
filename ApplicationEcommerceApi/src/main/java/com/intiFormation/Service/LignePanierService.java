package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Commande;
import com.intiFormation.Entity.LigneCommande;
import com.intiFormation.Entity.LignePanier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.ICommandeDao;
import com.intiFormation.dao.ILigneCommandeDao;
import com.intiFormation.dao.ILignePanierDao;
import com.intiFormation.dao.IProduitDao;





@Service
public class LignePanierService implements ILignePanierService {
	
	@Autowired
	private ILignePanierDao lpdao;
	
	
	
	public LignePanierService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(LignePanier lp) {
		lpdao.save(lp);
	}
	
	public Optional<LignePanier> selectByIdService(int id){
		Optional<LignePanier>op=lpdao.findById(id);
		return op;
	}
	
	public List<LignePanier> getAllService(){
		List<LignePanier> liste=lpdao.findAll();
		return liste;
		
	}
	public List<LignePanier> findByPanier_IdPanier(int idPanier){
		List<LignePanier> liste=lpdao.findByPanier_IdPanier(idPanier);
		return liste;
	}
	public void supprimerService(int id) {
		lpdao.deleteById(id);
	}
	public void modifierService(LignePanier lp) {
		lpdao.save(lp);
	}

	public ILignePanierDao getLpdao() {
		return lpdao;
	}

	public void setLcdao(ILignePanierDao lpdao) {
		this.lpdao = lpdao;
	}
	
	
	
	

}
