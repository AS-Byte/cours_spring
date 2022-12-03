package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Contrat;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepo extends CrudRepository <Contrat,Long> {

    //Select * from contrat where archive= (valeur passée en paramètre)
    //get ou find c la meme
    List<Contrat> getByArchive(boolean archive);
    //Select * from contrat where archive=(param) and datedebutc=(param)
    List<Contrat> getByArchiveAndDateDebutC(boolean archive, Date date);

    //Select * from contrat where datedebutc >(param) and datedebutc<(param)
    List<Contrat> getByDateDebutCBetween(Date date1, Date date2);



}
