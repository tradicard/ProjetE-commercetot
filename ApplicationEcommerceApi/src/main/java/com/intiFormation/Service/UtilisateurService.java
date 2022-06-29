package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Role;
import com.intiFormation.Entity.Utilisateur;
import com.intiFormation.dao.IUtilisateurDao;


@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	IUtilisateurDao udao;
	
	public Utilisateur chercherParUsername(String username) {
		return udao.findByUsername(username);
	}
	public void ajouterService(Utilisateur u) {
		udao.save(u);
	}
	
	public Optional<Utilisateur> selectByIdService(int id){
		Optional<Utilisateur>op=udao.findById(id);
		return op;
	}
	
	public List<Utilisateur> getAllService(){
		List<Utilisateur> liste=udao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		udao.deleteById(id);
	}
	public void modifierService(Utilisateur u) {
		udao.save(u);
	}

}
