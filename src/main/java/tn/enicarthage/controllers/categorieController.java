package tn.enicarthage.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import tn.enicarthage.entities.categorie;
import tn.enicarthage.entities.evenement;
import tn.enicarthage.entities.userForm;
import tn.enicarthage.repositories.evenementRepository;
import tn.enicarthage.services.evenementService;


import tn.enicarthage.entities.categorie;
import tn.enicarthage.entities.evenement;
import tn.enicarthage.entities.userForm;
import tn.enicarthage.repositories.evenementRepository;
import tn.enicarthage.services.evenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.enicarthage.entities.categorie;
import tn.enicarthage.services.IcategorieService;

import org.apache.log4j.Logger;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categorie")
public class categorieController {

	public static final Logger logger = Logger.getLogger(categorieController.class);

    @Autowired
    private IcategorieService categorieService;

    @GetMapping("")
    public List<categorie> getAllCategories() {
    	logger.info("Fetching all categories");
        return categorieService.listescategorie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<categorie> getCategorieById(@PathVariable int id) {
        categorie categorie = categorieService.getcategorieById((long) id);
        logger.info("Fetching category with id " + id);
        return ResponseEntity.ok().body(categorie);
    }

    @PostMapping("")
    public ResponseEntity<?> createCategorie(@RequestBody categorie categorie) {
    	 logger.info("Adding category: " + categorie.toString());
        categorieService.ajoutercategorie(categorie);
        return new ResponseEntity<>("Categorie created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<categorie> updateCategorie(@PathVariable Long id, @RequestBody categorie categorieDetails){
        categorie categorie = categorieService.getcategorieById(id);
        
        categorie.setLibelle(categorieDetails.getLibelle());
        categorie.setDescription(categorieDetails.getDescription());
        
        categorie updatedCategorie = categorieService.modifiercategorie(categorie);
        return ResponseEntity.ok(updatedCategorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable int id) {
        categorieService.supprimercategorieById(id);
        return ResponseEntity.ok().body("Categorie deleted successfully");
    }
}
