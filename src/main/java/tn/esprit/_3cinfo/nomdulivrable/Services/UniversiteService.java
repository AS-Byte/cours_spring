package tn.esprit._3cinfo.nomdulivrable.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Departement;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Universite;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.DepartementRepo;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.UniversiteRepo;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    private UniversiteRepo iur;

    @Autowired
    private DepartementRepo idr;

    @Override
    public Universite addUniversite(Universite d) {
        return iur.save(d);
    }

    @Override
    public Universite updateUniversite(Universite d) {
        return iur.save(d);
    }

    @Override
    public void deleteUniversite(Universite d) {
        iur.delete(d);
    }

    @Override
    public void deleteUniversite(Long id) {
        iur.deleteById(id);
    }

    @Override
    public List<Universite> findAllUniversite() {
        return (List<Universite>) iur.findAll();
    }

    @Override
    public Universite findUniversiteById(Long id) {
        return iur.findById(id).get();
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universiteaaffecter=iur.findById(Long.valueOf(idUniversite)).get(); //parent pck unidirectionnelle et la flèche sortante pzrt de l'université
        Departement departementaaffecter=idr.findById(Long.valueOf(idDepartement)).get(); // child

        //affectation du child au parent en memoire vive
        universiteaaffecter.getDepartements().add(departementaaffecter);

        //persistance sur la BD

        iur.save(universiteaaffecter);



    }
}
