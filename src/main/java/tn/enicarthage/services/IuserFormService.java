package tn.enicarthage.services;

import java.util.List;

import tn.enicarthage.entities.userForm;



public interface IuserFormService {
	public void ajouteruserForm(userForm c);
	
	
	public userForm modifieruserForm(userForm c);

	
	public void supprimeruserForm(userForm c);

	public void supprimeruserFormById(int id);
	
	public List<userForm> listesuserFormt();


	public userForm getuserFormById(long id);

}
