package tn.enicarthage.controllers;

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
import org.apache.log4j.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/evenement")
public class evenementController {

	public static final Logger logger = Logger.getLogger(evenementController.class);


    @Autowired
    private evenementService evenementService;

    @GetMapping("")
    public List<evenement> getAllEvenements() {
        logger.info("Fetching all evenements");
        return evenementService.listesevenement();
    }

    @GetMapping("/{id}")
    public evenement getEvenementById(@PathVariable("id") long id) {
        logger.info("Fetching evenement with id " + id);
        return evenementService.getevenementById(id);
    }

    @GetMapping("/{id}/userForm")
    public Set<userForm> getUserFormsByEventId(@PathVariable long id) {
        evenement evenement = evenementService.getevenementById(id);
        logger.info("Fetching user forms for evenement with id " + id);
        return evenement.getUserForms();
    }

    @GetMapping("/{id}/userFormCount")
    public int getUserFormCountByEventId(@PathVariable long id) {
        evenement evenement = evenementService.getevenementById(id);
        logger.info("Fetching user form count for evenement with id " + id);
        return evenement.getUserForms().size();
    }

    @PostMapping("")
    public ResponseEntity<Void> addEvenement(@RequestBody evenement evenement) {
        logger.info("Adding evenement: " + evenement.toString());
        evenementService.ajouterevenement(evenement);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<evenement> updateEvenement(@PathVariable("id") long id, @RequestBody evenement evenement) {
        logger.info("Updating evenement with id " + id);
        evenement currentEvenement = evenementService.getevenementById((long) id);
        currentEvenement.setNom(evenement.getNom());
        currentEvenement.setDescription(evenement.getDescription());
        currentEvenement.setDate(evenement.getDate());
        evenementService.modifierevenement(currentEvenement);

        evenement updatedEvenement = evenementService.modifierevenement(evenement);
        return ResponseEntity.ok(updatedEvenement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvenement(@PathVariable("id") int id) {
        logger.info("Deleting evenement with id " + id);
        evenementService.supprimerevenementById(id);
        return ResponseEntity.ok().body("evenement deleted successfully");
    }
}
