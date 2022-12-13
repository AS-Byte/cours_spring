package tn.esprit._3cinfo.nomdulivrable.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Equipe;
import tn.esprit._3cinfo.nomdulivrable.DAO.Entities.Specialite;

import java.util.List;

@Repository
public interface EquipeRepo extends CrudRepository<Equipe,Long> {

    // Les 2 methodes suivantes répondent à la question: Afficher la liste des équipes avec une thématique passée en paramètres en JPQL ET SQL
    //vu que la relation n'est pas ManyToMany on peut la faire avec jpql

    @Query("select alias from Equipe alias, DetailsEquipe chouhira where " +
            "alias.d.idDetailsEquipe=chouhira.idDetailsEquipe and chouhira.thematique=?1")
    List<Equipe> retrieveequipebyThematiqueJPQL(String thematique);

    @Query (value = "SELECT elyas from equipe elyas join details_equipe chouhiramtaadetailequipe" +
            "on chouhiramtaadetailequipe.id_details_equipe=elyas.d_id_details_equipe where " +
            "chouhiramtaadetailequipe.thematique= ?1", nativeQuery = true)
    List<Equipe> retrieveequipebyThematiqueSQL(String thematique);
    
}
