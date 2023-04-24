package tn.enicarthage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.entities.categorie;


@Repository
public interface categorieRepository extends CrudRepository<categorie, Long>{

}
