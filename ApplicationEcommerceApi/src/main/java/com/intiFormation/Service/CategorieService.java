package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;
import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.dao.IProduitDao;





@Service
public class CategorieService implements ICategorieService {
	
	@Autowired
	private ICategorieDao cdao;
	
	
	
	public CategorieService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(Categorie c) {
		cdao.save(c);
	}
	
	public Optional<Categorie> selectByIdService(int id){
		Optional<Categorie>op=cdao.findById(id);
		return op;
	}
	
	public List<Categorie> getAllService(){
		List<Categorie> liste=cdao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		cdao.deleteById(id);
	}
	public void modifierService(Categorie c) {
		cdao.save(c);
	}
	
	

	public ICategorieDao getCdao() {
		return cdao;
	}

	public void setCdao(ICategorieDao cdao) {
		this.cdao = cdao;
	}
	
	
	
	

}
