package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;
import com.intiFormation.Entity.Produit;
import com.intiFormation.Entity.Role;



public interface IRoleService {
	
	public void modifierService(Role r);
	public void supprimerService(int id);
	public List<Role> getAllService();
	public Optional<Role> selectByIdService(int id);
	public void ajouterService(Role r);

}
