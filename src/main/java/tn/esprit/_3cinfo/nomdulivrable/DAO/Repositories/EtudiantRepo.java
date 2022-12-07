package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepo extends CrudRepository<Etudiant,Long> {

    List<Etudiant> findByEquipesIdEquipe(Long id);

    //la méthode qui suit est une application de l'utilisation de JPQL au lieu des keywords, en JPQL on utilise les entités et les attributs, alors que ne SQL on utilise les noms des colonnes et des tables dans la base
    @Query("selECT alias from Etudiant alias where alias.nomE= : lak and alias.prenomE= : esmo")
    Etudiant jibliLEtudiantElliEsmouWLakabouEnParamJPQL(@Param( value = "lak") String lakabu,
                                                        @Param(value = "esmo") String esmou);//l'ordre n'est pas important

    @Query(value = "SeLeCt * from etudiant where nome=?1 and prenome=?2 ", nativeQuery = true) //l'ordre est très important
    Etudiant jibliLEtudiantElliEsmouWLakabouEnParamSQL(String name, String surname);
}
