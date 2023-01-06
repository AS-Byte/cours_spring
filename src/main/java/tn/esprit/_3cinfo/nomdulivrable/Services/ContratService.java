package tn.esprit._3cinfo.nomdulivrable.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Contrat;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.ContratRepo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j

@Service
public class ContratService implements IContratService {
    @Autowired //@Inject
    private ContratRepo icr;

    @Override
    public Contrat addContrat(Contrat c) {
        return icr.save(c); //save ajout if id null or non existant in DB
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return icr.save(c); // save updates if id exists in DB
    }

    @Override
    public void deleteContrat(Contrat c) {
        icr.delete(c);
    }

    @Override
    public void deleteContrat(Long id) {
        icr.deleteById(id);
    }

    @Override
    public List<Contrat> findAllContrat() {
        return (List<Contrat>) icr.findAll();
    }

    @Override
    public Contrat findContratById(Long id) {
        return icr.findById(id).get(); // pour eviter d'avoir un nullpointer exception
    }

    @Override
    public List<Contrat> searchContratByArchive(boolean arch) {
        return icr.getByArchive(arch);
    }

    @Override
    public List<Contrat> searchContratInBetweenDates(Date date1, Date date2) {
        return icr.getByDateDebutCBetween(date1, date2);
    }

    @Override
    public String retrieveAndUpdateStatusContrat() {
        String msgforadmin="";
        List<Contrat> contratsVerif = icr.getByArchive(false);
        for (Contrat c : contratsVerif) {
            log.error(calculDiff(c.getDateFinC(), new Date())+"");
            if (calculDiff(c.getDateFinC(), new Date()) == 0) {
                c.setArchive(true);
                icr.save(c);
                log.info("le contrat " +
                        c.getIdContrat() +
                        "de l'étudiant" +
                        c.getContrats_etudiants().getNomE()+
                        "est expiré"
                );

            } else if (calculDiff(c.getDateFinC(), new Date()) +1==15) {
                msgforadmin += "le contrat "+c.getIdContrat()+
                        "sera expiré dans 15jrs";
            }
        }
        return msgforadmin;
    }

    public long calculDiff(Date date1, Date date2) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


}
