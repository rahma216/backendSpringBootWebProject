package tn.enicarthage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.entities.evenement;


@Repository
public interface evenementRepository extends CrudRepository<evenement, Long>{

}
