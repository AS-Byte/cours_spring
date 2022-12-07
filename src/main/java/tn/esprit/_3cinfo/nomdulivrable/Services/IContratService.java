package tn.esprit._3cinfo.nomdulivrable.Services;

import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    void deleteContrat(Contrat c);
    void deleteContrat (Long id );
    List<Contrat> findAllContrat();
    Contrat findContratById (Long id);
    List<Contrat> searchContratByArchive (boolean arch);
    List<Contrat> searchContratInBetweenDates(Date date1, Date date2);

}
