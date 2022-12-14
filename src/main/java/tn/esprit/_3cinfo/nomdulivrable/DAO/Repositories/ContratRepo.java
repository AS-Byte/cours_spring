package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Contrat;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepo extends CrudRepository <Contrat,Long> {

    //Select * from contrat where archive= (valeur passée en paramètre)
    //get ou find c la meme
    List<Contrat> getByArchive(boolean archive);
    //Select * from contrat where archive=(param) and datedebutc=(param)
    List<Contrat> getByArchiveAndDateDebutC(boolean archive, Date date);

    //Select * from contrat where datedebutc >(param) and datedebutc<(param)
    List<Contrat> getByDateDebutCBetween(Date date1, Date date2);

    // Les 2 methodes suivantes répondent à la question: Afficher la liste des contrats d'un étudiant avec l'id passé en paramètre
    @Query("select cont from Contrat cont , Etudiant etu where " +
            "cont.contrats_etudiants.idEtudiant=etu.idEtudiant and etu.idEtudiant=?1")
    List<Contrat> retrieveContratsByIdEtudiantJPQL(Long idetudiant);

    @Query(value="select cont from t_contrat cont join etudiant etu" +
            "on cont.contrats_etudiants_id_etudiant=etu.id_etudiant where" +
            "etu.id_etudiant=?1 ",  nativeQuery = true)
    List<Contrat> retrieveContratsByIdEtudiantSQL(Long idetudiant);


}
