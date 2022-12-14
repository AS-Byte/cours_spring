package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Etudiant;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Niveau;

import java.util.List;

@Repository
public interface EtudiantRepo extends CrudRepository<Etudiant,Long> {

    List<Etudiant> findByEquipesIdEquipe(Long id);

    //la méthode qui suit est une application de l'utilisation de JPQL au lieu des keywords, en JPQL on utilise les entités et les attributs, alors que ne SQL on utilise les noms des colonnes et des tables dans la base
    @Query("selECT alias from Etudiant alias where alias.nomE= : lak and alias.prenomE= : esmo")
    Etudiant jibliLEtudiantElliEsmouWLakabouEnParamJPQL(@Param( value = "lak") String lakabu,
                                                        @Param(value = "esmo") String esmou);//l'ordre n'est pas important avec la @param

    //la méthode qui suit est application de l'utilisation de SQL au lieu de JPQL

    @Query(value = "SeLeCt * from etudiant where nome=?1 and prenome=?2 ", nativeQuery = true) //l'ordre est très important si pas de @param
    Etudiant jibliLEtudiantElliEsmouWLakabouEnParamSQL(String name, String surname);


    // La méthode suivante répond à la question: Afficher la liste des étudiants avec un niveau passé en paramètre, elle
    // ne peut etre faite qu'avec sql pck il y'a une table associative au niveau de l'implémentation

    //on utilise alias au lieu de * pck en utilisant * il va nous ramener les 3 listes (etudiant, equipe etudiant et equipe)
    @Query(value = "select alias from etudiant alias join equipe_etudiants alia2 on alia2.etudiants_id_etudiant=alias.id_etudiant" +
            "join equipe alia3 on alia2.equipes_id_equipe=alia3.id_equipe where alia3.niveau= : ni",nativeQuery = true)
    List <Etudiant> fetchEtudiantsWithLevelInParamSQL(@Param(value="ni") Niveau niv);


    //méthode pour supprimer un étudiant don le nom et prénom sont passés en param
    @Modifying //  à chaque fois que nous allons apporter une modif à la base
    @Query("delete from Etudiant where nomE= : nom and prenomE= : prenom")
    void supprimeretudiantavecNometPrenomJPQL(@Param(value = "nom") String nom , @Param(value="prenom") String prenom);

    @Modifying
    @Query( value ="delete from etudiant  where nome= : nom and prenome= : prenom", nativeQuery = true)
    void supprimeretudiantavecNometPrenomSQL(@Param(value = "nom") String nom , @Param(value="prenom") String prenom);

}
