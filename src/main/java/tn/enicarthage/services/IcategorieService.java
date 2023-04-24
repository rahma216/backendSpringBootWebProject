package tn.enicarthage.services;

import java.util.List;

import tn.enicarthage.entities.categorie;



public interface IcategorieService {
	public void ajoutercategorie(categorie c);
	
	
	public categorie modifiercategorie(categorie c);

	
	public void supprimercategorie(categorie c);

	public void supprimercategorieById(int id);
	
	public List<categorie> listescategorie();


	categorie getcategorieById(Long id);

}
