package tn.esprit._3cinfo.nomdulivrable.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.DetailsEquipe;
import tn.esprit._3cinfo.nomdulivrable.Services.IDetailsEquipeService;

import java.util.List;

@RestController
@RequestMapping("detailsEquipeRC")
public class DetailsEquipeRestC {
    @Autowired
    private IDetailsEquipeService idets;

    @PostMapping("addDEq")
    DetailsEquipe addDetailsEquipe( @RequestBody DetailsEquipe d) {return idets.addDetailsEquipe(d); }

    @PutMapping("updateDEq")
    DetailsEquipe updateDetailsEquipe( @RequestBody DetailsEquipe d) {return idets.updateDetailsEquipe(d);}

    @DeleteMapping("deleteDEq")
    void deleteDetailsEquipe(@RequestBody DetailsEquipe d) {idets.deleteDetailsEquipe(d);}

    @DeleteMapping("deleteDEqId/{id}")
    void deleteDetailsEquipe ( @PathVariable Long id ) {idets.deleteDetailsEquipe(id);}

    @GetMapping("findAllDEq")
    List<DetailsEquipe> findAllDetailsEquipe() { return idets.findAllDetailsEquipe(); }

    @GetMapping("findbyIDDEq")
    DetailsEquipe findDetailsEquipeById (@RequestParam Long id) {return idets.findDetailsEquipeById(id);}
}