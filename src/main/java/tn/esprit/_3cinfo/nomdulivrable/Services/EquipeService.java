package tn.esprit._3cinfo.nomdulivrable.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Equipe;
import tn.esprit._3cinfo.nomdulivrable.DAO.Repositories.EquipeRepo;

import java.util.List;

@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepo ieqr;

    @Override
    public Equipe addEquipe(Equipe d) {
        return ieqr.save(d);
    }

    @Override
    public Equipe updateEquipe(Equipe d) {
        return ieqr.save(d);
    }

    @Override
    public void deleteEquipe(Equipe d) {
        ieqr.delete(d);
    }

    @Override
    public void deleteEquipe(Long id) {
        ieqr.deleteById(id);
    }

    @Override
    public List<Equipe> findAllEquipe() {
        return (List<Equipe>) ieqr.findAll();
    }

    @Override
    public Equipe findEquipe(Long id) {
        return ieqr.findById(id).get();
    }
}
