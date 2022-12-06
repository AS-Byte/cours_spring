package tn.esprit._3cinfo.nomdulivrable.Services;

import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.DetailsEquipe;

import java.util.List;

public interface IDetailsEquipeService {
    DetailsEquipe addDetailsEquipe(DetailsEquipe d);
    DetailsEquipe updateDetailsEquipe(DetailsEquipe d);
    void deleteDetailsEquipe(DetailsEquipe d);
    void deleteDetailsEquipe (Long id );
    List<DetailsEquipe> findAllDetailsEquipe();
    DetailsEquipe findDetailsEquipeById (Long id);
}