package tn.esprit._3cinfo.nomdulivrable.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.DetailsEquipe;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.DetailsEquipeRepo;

import java.util.List;

@Service
public class DetailsEquipeService implements IDetailsEquipeService {
    @Autowired
    private DetailsEquipeRepo ider;

    @Override
    public DetailsEquipe addDetailsEquipe(DetailsEquipe d) {
        return ider.save(d);
    }

    @Override
    public DetailsEquipe updateDetailsEquipe(DetailsEquipe d) {
        return ider.save(d);
    }

    @Override
    public void deleteDetailsEquipe(DetailsEquipe d) {
        ider.delete(d);
    }

    @Override
    public void deleteDetailsEquipe(Long id) {
        ider.deleteById(id);
    }

    @Override
    public List<DetailsEquipe> findAllDetailsEquipe() {
        return (List<DetailsEquipe>) ider.findAll();
    }

    @Override
    public DetailsEquipe findDetailsEquipeById(Long id) {
        return ider.findById(id).get();
    }
}
