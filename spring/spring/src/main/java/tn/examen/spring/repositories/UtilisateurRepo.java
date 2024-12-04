package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.spring.entities.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {

}
