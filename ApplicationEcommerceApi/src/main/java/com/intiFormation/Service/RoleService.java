package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Role;
import com.intiFormation.dao.IProduitDao;
import com.intiFormation.dao.IRoleDao;





@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao rdao;
	
	
	
	public RoleService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterService(Role r) {
		rdao.save(r);
	}
	
	public Optional<Role> selectByIdService(int id){
		Optional<Role>op=rdao.findById(id);
		return op;
	}
	
	public List<Role> getAllService(){
		List<Role> liste=rdao.findAll();
		return liste;
		
	}
	public void supprimerService(int id) {
		rdao.deleteById(id);
	}
	public void modifierService(Role r) {
		rdao.save(r);
	}

	public IRoleDao getRdao() {
		return rdao;
	}

	public void setRdao(IRoleDao rdao) {
		this.rdao = rdao;
	}
	
	
	
	

}
