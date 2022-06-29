package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Categorie;
import com.intiFormation.Entity.Produit;
import com.intiFormation.dao.IProduitDao;





@Service
public class ProduitService implements IProduitService {
	
	@Autowired
	private IProduitDao pdao;
	
	
	
	public ProduitService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(Produit p) {
		pdao.save(p);
	}
	
	public Optional<Produit> selectByIdService(int id){
		Optional<Produit>op=pdao.findById(id);
		return op;
	}
	
	public List<Produit> getAllService(){
		List<Produit> liste=pdao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		System.out.println("début");
		Produit p=pdao.findById(id).get();
		System.out.println(p);
		pdao.delete(p);
		//pdao.deleteById(id);
		System.out.println("fin op");
	}
	public void modifierService(Produit p) {
		pdao.save(p);
	}
	
	public Produit findByNom(String nomProduit) {
		Produit p=pdao.findByNomProduit(nomProduit);
		return p;
	}
	
	public List<Produit> getByCategorie(Categorie categorie){
		List<Produit> liste=pdao.findByCategorie(categorie);
		return liste;
	}

	public IProduitDao getPdao() {
		return pdao;
	}

	public void setPdao(IProduitDao pdao) {
		this.pdao = pdao;
	}
	
	
	
	
	

}
