package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Universite;

@Repository
public interface UniversiteRepo extends CrudRepository <Universite,Long> {
}
