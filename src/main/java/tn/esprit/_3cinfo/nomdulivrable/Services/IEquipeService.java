package tn.esprit._3cinfo.nomdulivrable.Services;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Equipe;

import java.util.List;

public interface IEquipeService {
   Equipe addEquipe(Equipe d);
    Equipe updateEquipe(Equipe d);
    void deleteEquipe(Equipe d);
    void deleteEquipe (Long id );
    List<Equipe> findAllEquipe();
    Equipe findEquipeById (Long id);
}