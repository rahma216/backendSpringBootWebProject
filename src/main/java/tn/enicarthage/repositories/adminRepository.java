package tn.enicarthage.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.entities.admin;



@Repository
public interface adminRepository extends CrudRepository<admin, Long>, JpaRepository<admin, Long> {
	admin findByEmail(String email);

}
