package tn.esprit._3cinfo.nomdulivrable.Services;

import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant d);
    Etudiant updateEtudiant(Etudiant d);
    void deleteEtudiant(Etudiant d);
    void deleteEtudiant (Long id );
    List<Etudiant> findAllEtudiant();
    Etudiant findEtudiant (Long id);
}
