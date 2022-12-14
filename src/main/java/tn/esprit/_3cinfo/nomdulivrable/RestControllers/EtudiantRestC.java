package tn.esprit._3cinfo.nomdulivrable.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Etudiant;
import tn.esprit._3cinfo.nomdulivrable.Services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("etudiantRC")
public class EtudiantRestC {
    @Autowired
    private IEtudiantService iets;

    @PostMapping("addEtu")
    Etudiant addEtudiant(@RequestBody Etudiant d) { return iets.addEtudiant(d); }

    @PutMapping("updateEtu")
    Etudiant updateEtudiant(@RequestBody Etudiant d) {return iets.updateEtudiant(d);}

    @DeleteMapping("deleteEtu")
    void deleteEtudiant(@RequestBody Etudiant d) {iets.deleteEtudiant(d);}

    @DeleteMapping("deleteEtuId/{id}")
    void deleteEtudiant ( @PathVariable Long id ) {iets.deleteEtudiant(id);}

    @GetMapping("findAllEtu")
    List<Etudiant> findAllEtudiant() { return iets.findAllEtudiant(); }

    @GetMapping("findbyIDEtu")
    Etudiant findEtudiantById (@RequestParam Long id) {return iets.findEtudiantById(id);}

    @PutMapping("AffecterEtu")
    void affecterEtudiantaDepartement(@RequestParam Integer etudiantId, @RequestParam Integer departementId){
        iets.assignEtudiantToDepartement(etudiantId, departementId);
    }
}