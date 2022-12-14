package tn.esprit._3cinfo.nomdulivrable.DAO.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode

//@Data remplace @getter, setter tostring et equals

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String prenomE;

    private String nomE;

    @Enumerated (EnumType.STRING)
    private Domaine domaine;

    @ManyToOne //vu qu'il n'ya pas de mappedby, l'étudiant est le parent
    private Departement de;

    @ManyToMany(mappedBy = "etudiants")
    List<Equipe>equipes;

    @OneToMany (mappedBy = "contrats_etudiants")
    List<Contrat>contratsetudiants;
}
