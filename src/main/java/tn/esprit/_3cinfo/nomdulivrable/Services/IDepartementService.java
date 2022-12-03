package tn.esprit._3cinfo.nomdulivrable.Services;

import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Contrat;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Departement;

import java.util.List;

public interface IDepartementService {
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    void deleteDepartement(Departement d);
    void deleteDepartement (Long id );
    List<Departement> findAllDepartement();
    Departement findDepartement (Long id);
}
