package tn.esprit._3cinfo.nomdulivrable.DAO.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetailsEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailsEquipe;

    private int salle;

    private String thematique;

    @OneToOne(mappedBy = "d") // si on ne met pas mapped by il va créer deux liaisons unidirectionnelles
    private Equipe e;
}
