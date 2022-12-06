package tn.esprit._3cinfo.nomdulivrable.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Universite;
import tn.esprit._3cinfo.nomdulivrable.Services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("universiteRC")
public class UniversiteRestC {
    @Autowired
    private IUniversiteService iuns;

    @PostMapping("addUni")
    Universite addUniversite( @RequestBody Universite d) { return iuns.addUniversite(d); }

    @PutMapping("updateUni")
    Universite updateUniversite( @RequestBody Universite d) {return iuns.updateUniversite(d);}

    @DeleteMapping("deleteUni")
    void deleteUniversite( @RequestBody Universite d) {iuns.deleteUniversite(d);}

    @DeleteMapping("deleteUniId/{id}")
    void deleteUniversite ( @PathVariable Long id ) {iuns.deleteUniversite(id);}

    @GetMapping("findAllUni")
    List<Universite> findAllUniversite() { return iuns.findAllUniversite(); }

    @GetMapping("findbyIDUni")
    Universite findUniversiteById (@RequestParam Long id) {return iuns.findUniversiteById(id);}
}