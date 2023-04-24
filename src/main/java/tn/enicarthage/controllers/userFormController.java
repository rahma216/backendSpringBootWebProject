package tn.enicarthage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.entities.evenement;
import tn.enicarthage.entities.userForm;
import tn.enicarthage.exceptions.ResourceNotFoundException;
import tn.enicarthage.repositories.userFormRepository;
import tn.enicarthage.services.userFormService;
import org.apache.log4j.Logger;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/userForm")
public class userFormController {
	public static final Logger logger = Logger.getLogger(userFormController.class);
	@Autowired
	private userFormService userFormService;
	
    @GetMapping("")
    public List<userForm> getAlluserForms() {
    	logger.info("Fetching all userForms");
    	 return userFormService.listesuserFormt();
       
    }

    @GetMapping("/{id}")
    public userForm getuserFormById(@PathVariable("id") long id) {
    	logger.info("Fetching form with id " + id);
    	 return userFormService.getuserFormById(id);

    }

	@PostMapping("")
	public ResponseEntity<Void> ajouteruserForm(@RequestBody userForm userForm) {
		 logger.info("Adding form: " + userForm.toString());
		userFormService.ajouteruserForm(userForm);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<userForm> modifieruserForm(@PathVariable("id") long id,@RequestBody userForm updatedUserForm) {
	    userForm existingUserForm = userFormService.getuserFormById(id);
	    existingUserForm.setNom(updatedUserForm.getNom());
	    existingUserForm.setEmail(updatedUserForm.getEmail());
	    existingUserForm.setAge(updatedUserForm.getAge());
	    existingUserForm.setTypeUtilisateur(updatedUserForm.getTypeUtilisateur());
	    existingUserForm.setEvent(updatedUserForm.getEvent());
	    userFormService.modifieruserForm(existingUserForm);
	    
	    userForm updatedform = userFormService.modifieruserForm(updatedUserForm);
        return ResponseEntity.ok(updatedform);
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<?> supprimeruserFormById(@PathVariable("id") int id) {
		userFormService.supprimeruserFormById(id);
		  return ResponseEntity.ok().body("userForm deleted successfully");
	}

	
}
