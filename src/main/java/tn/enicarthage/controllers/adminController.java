package tn.enicarthage.controllers;
import org.apache.log4j.Logger;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import tn.enicarthage.entities.categorie;
import tn.enicarthage.entities.evenement;
import tn.enicarthage.entities.userForm;
import tn.enicarthage.repositories.evenementRepository;
import tn.enicarthage.services.evenementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.entities.admin;

import tn.enicarthage.repositories.adminRepository;
import tn.enicarthage.repositories.evenementRepository;
import tn.enicarthage.services.IadminService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class adminController {
	public static final Logger logger = Logger.getLogger(adminController.class);
	@Autowired
    private adminRepository adminRepository;

    @Autowired
    private IadminService adminService;
    
    @PostMapping("/login")
    public ResponseEntity<admin> loginAdmin(@RequestBody admin admin) {
    	 logger.info("Adding form: " + admin.toString());
    
        admin adm = adminRepository.findByEmail(admin.getEmail());
        if (adm != null && adm.getMdp().equals(admin.getMdp())) {
            return ResponseEntity.ok(adm);
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }


	

    @PostMapping("/ajouter")
    public void ajouterAdmin(@RequestBody admin c) {
        adminService.ajouteradmin(c);
       
    }

    @PostMapping("/modifier")
    public ResponseEntity<Void> modifierAdmin(@RequestBody admin c) {
        adminService.modifieradmin(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/supprimer")
    public ResponseEntity<Void> supprimerAdmin(@RequestBody admin c) {
        adminService.supprimeradmin(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
