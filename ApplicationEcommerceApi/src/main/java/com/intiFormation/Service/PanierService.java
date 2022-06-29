package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Panier;
import com.intiFormation.Entity.Produit;
import com.intiFormation.dao.IPanierDao;
import com.intiFormation.dao.IProduitDao;





@Service
public class PanierService implements IPanierService {
	
	@Autowired
	private IPanierDao padao;
	
	
	
	public PanierService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(Panier pa) {
		padao.save(pa);
	}
	
	public Optional<Panier> selectByIdService(int id){
		Optional<Panier>op=padao.findById(id);
		return op;
	}
	
	public List<Panier> getAllService(){
		List<Panier> liste=padao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		padao.deleteById(id);
	}
	public void modifierService(Panier pa) {
		padao.save(pa);
	}

	public IPanierDao getPadao() {
		return padao;
	}

	public void setPadao(IPanierDao padao) {
		this.padao = padao;
	}
	
	
	
	

}
