package tn.enicarthage.services;

import java.util.List;
import java.util.Optional;

import tn.enicarthage.entities.categorie;
import tn.enicarthage.entities.evenement;



public interface IevenementService {
	public void ajouterevenement(evenement c);
	
	
	public evenement modifierevenement(evenement c);

	
	public void supprimerevenement(evenement c);

	public void supprimerevenementById(int id);
	
	public List<evenement> listesevenement();








	public evenement getevenementById(Long id);

}
