package tn.esprit._3cinfo.nomdulivrable.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Departement;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Etudiant;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.DepartementRepo;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.EtudiantRepo;

import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{
    @Autowired
    private EtudiantRepo ietr;

    @Autowired
    private DepartementRepo ider;

    @Override
    public Etudiant addEtudiant(Etudiant d) {
        return ietr.save(d);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant d) {
        return ietr.save(d);
    }

    @Override
    public void deleteEtudiant(Etudiant d) {
        ietr.delete(d);
    }

    @Override
    public void deleteEtudiant(Long id) {
        ietr.deleteById(id);
    }

    @Override
    public List<Etudiant> findAllEtudiant() {
        return (List<Etudiant>) ietr.findAll();
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return ietr.findById(id).get();
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {

        Etudiant etudiantaaffecter = ietr.findById(Long.valueOf(etudiantId)).get(); //parent
        Departement departaaffecter = ider.findById(Long.valueOf(departementId)).get(); //child

        //on affecte toujoutrs le child au parent

        etudiantaaffecter.setDe(departaaffecter);

        //Pour persister on appelle le save du parent

        ietr.save(etudiantaaffecter);

    }

}
