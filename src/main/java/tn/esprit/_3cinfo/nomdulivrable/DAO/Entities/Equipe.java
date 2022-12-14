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
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String nomEquipe;

    @Enumerated (EnumType.STRING)
    private Niveau niveau;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailsEquipe d;

    @ManyToMany
    List<Etudiant>etudiants;
}