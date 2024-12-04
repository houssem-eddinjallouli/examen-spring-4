package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.spring.entities.CoursClassroom;
import tn.examen.spring.entities.Specialite;

import java.util.List;

public interface CoursClassroomRepo extends JpaRepository<CoursClassroom,Integer> {
    List<CoursClassroom> findBySpecialite(Specialite s);

}
