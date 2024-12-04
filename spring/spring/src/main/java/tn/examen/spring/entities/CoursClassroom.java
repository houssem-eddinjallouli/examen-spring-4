package tn.examen.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CoursClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCours;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    String nom;
    int nbHeures;
    boolean archive;

    @ManyToOne
    Classe classe;
}

