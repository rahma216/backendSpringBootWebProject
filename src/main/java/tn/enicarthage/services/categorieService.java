package tn.enicarthage.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.entities.categorie;

import tn.enicarthage.exceptions.ResourceNotFoundException;
import tn.enicarthage.repositories.categorieRepository;

@Service
public class categorieService implements IcategorieService{
	   @Autowired
	    private categorieRepository categorieRepository;

	    public categorieService() {
	        // TODO Auto-generated constructor stub
	    }

	    @Override
	    public void ajoutercategorie(categorie c) {
	    	categorieRepository.save(c);
	    }

	    @Override
	    public categorie modifiercategorie(categorie c) {
	    	return categorieRepository.save(c);
	    }

	    @Override
	    public void supprimercategorie(categorie c) {
	    	categorieRepository.delete(c);
	    }

	    @Override
	    public void supprimercategorieById(int id) {
	    	categorieRepository.deleteById((long) id);
	    }

	    @Override
	    public List<categorie> listescategorie() {
	        return (List<categorie>) categorieRepository.findAll();
	    }

	    @Override
	    public categorie getcategorieById(Long id) {
	        Optional<categorie> optionalcategorie = categorieRepository.findById((long) id);
	        if (optionalcategorie.isPresent()) {
	            return optionalcategorie.get();
	        } else {
	            throw new ResourceNotFoundException("categorie not exist with id :" + id);
	        }
	    }

}
