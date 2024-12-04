package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.spring.entities.Classe;

public interface ClasseRepo extends JpaRepository<Classe,Integer> {

}
