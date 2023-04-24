package tn.enicarthage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.enicarthage.entities.admin;
import tn.enicarthage.repositories.adminRepository;

@Service
public class adminService implements IadminService{
	@Autowired
	adminRepository adminRepository ;

	public adminService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouteradmin(admin c) {
		// TODO Auto-generated method stub
		
		adminRepository.save(c); 
	}

	@Override
	public void modifieradmin(admin c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeradmin(admin c) {
		// TODO Auto-generated method stub
		
	}
}
