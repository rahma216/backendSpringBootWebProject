
package tn.enicarthage.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.entities.userForm;


@Repository
public interface userFormRepository extends CrudRepository<userForm, Long>{

}
