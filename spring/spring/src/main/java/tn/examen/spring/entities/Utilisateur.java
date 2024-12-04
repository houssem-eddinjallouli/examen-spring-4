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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUtilisateur;
    String prenom;
    String nom;
    String password;

    @ManyToOne(cascade = CascadeType.ALL)
    Classe classe;
}

