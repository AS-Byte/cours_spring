package tn.esprit._3cinfo.nomdulivrable.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Equipe;
import tn.esprit._3cinfo.nomdulivrable.Services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("equipeRC")
public class EquipeRestC {
    @Autowired
    private IEquipeService ieqs;

    @PostMapping("addEq")
    Equipe addEquipe( @RequestBody Equipe d) { return ieqs.addEquipe(d); }

    @PutMapping("updateEq")
    Equipe updateEquipe( @RequestBody Equipe d) {return ieqs.updateEquipe(d);}

    @DeleteMapping("deleteEq")
    void deleteEquipe( @RequestBody Equipe d) {ieqs.deleteEquipe(d);}

    @DeleteMapping("deleteEqId/{id}")
    void deleteEquipe ( @PathVariable Long id ) {ieqs.deleteEquipe(id);}

    @GetMapping("findAllEq")
    List<Equipe> findAllEquipe() { return ieqs.findAllEquipe(); }

    @GetMapping("findbyIDEq")
    Equipe findEquipeById (@RequestParam Long id) {return ieqs.findEquipeById(id);}
}