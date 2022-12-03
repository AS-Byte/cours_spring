package tn.esprit._3cinfo.nomdulivrable.Services;

import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite d);
    Universite updateUniversite(Universite d);
    void deleteUniversite(Universite d);
    void deleteUniversite (Long id );
    List<Universite> findAllUniversite();
    Universite findUniversite (Long id);
}
