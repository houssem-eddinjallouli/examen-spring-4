package tn.examen.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codeClasse;
    String titre;
    @Enumerated(EnumType.STRING)
    Niveau niveau;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="classe")
    private Set<CoursClassroom> CoursClassrooms = new HashSet<>();
}

