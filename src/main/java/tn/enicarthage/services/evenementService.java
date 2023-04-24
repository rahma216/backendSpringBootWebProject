package tn.enicarthage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.entities.categorie;
import tn.enicarthage.entities.evenement;
import tn.enicarthage.exceptions.ResourceNotFoundException;
import tn.enicarthage.repositories.evenementRepository;

@Service
public class evenementService implements IevenementService {

    @Autowired
    private evenementRepository evenementRepository;

    public evenementService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void ajouterevenement(evenement c) {
        evenementRepository.save(c);
    }

    @Override
    public evenement modifierevenement(evenement c) {
        return evenementRepository.save(c);
    }

    @Override
    public void supprimerevenement(evenement c) {
        evenementRepository.delete(c);
    }

    @Override
    public void supprimerevenementById(int id) {
        evenementRepository.deleteById((long) id);
    }

    @Override
    public List<evenement> listesevenement() {
        return (List<evenement>) evenementRepository.findAll();
    }

    @Override
    public evenement getevenementById(Long id) {
        return evenementRepository.findById((long) id).get();
       
    }

}
