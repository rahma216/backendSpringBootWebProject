package tn.enicarthage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.enicarthage.entities.userForm;
import tn.enicarthage.exceptions.ResourceNotFoundException;
import tn.enicarthage.repositories.userFormRepository;

@Service
public class userFormService implements IuserFormService{

	@Autowired
	private userFormRepository userFormRepo;
	public userFormService() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void ajouteruserForm(userForm userForm) {
		userFormRepo.save(userForm);
	}

	@Override
	public userForm modifieruserForm(userForm userForm) {
		return userFormRepo.save(userForm);
	}

	@Override
	public void supprimeruserForm(userForm userForm) {
		userFormRepo.delete(userForm);
	}

	@Override
	public void supprimeruserFormById(int id) {
		userFormRepo.deleteById((long) id);
	}

	@Override
	public List<userForm> listesuserFormt() {
		return (List<userForm>) userFormRepo.findAll();
	}
	@Override
	public userForm getuserFormById(long id) {
		return userFormRepo.findById((long) id).get();
	  
	
}}
