package tn.esprit._3cinfo.nomdulivrable.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Departement;
import tn.esprit._3cinfo.nomdulivrable.Services.IDepartementService;

import java.util.List;

@RestController
@RequestMapping("departementRC")
public class DepartementRestC {
    @Autowired
    private IDepartementService ideps;

    @PostMapping("addDep")
    Departement addDepartement(@RequestBody Departement d) {return ideps.addDepartement(d);}
    @PutMapping("updateDep")
    Departement updateDepartement(@RequestBody Departement d) {return ideps.updateDepartement(d);}
    @DeleteMapping("deleteDep")
    void deleteDepartement(@RequestBody Departement d) {ideps.deleteDepartement(d);}
    @DeleteMapping("deleteDepId/{id}")
    void deleteDepartement (@PathVariable Long id ) {ideps.deleteDepartement(id);}
    @GetMapping("findAllDep")
    List<Departement> findAllDepartement() {return ideps.findAllDepartement();}
    @GetMapping("findbyIDDep")
    Departement findDepartement (@RequestParam Long id) {return ideps.findDepartementById(id);}

}
