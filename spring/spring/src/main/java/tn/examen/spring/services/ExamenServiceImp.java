package tn.examen.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.examen.spring.entities.*;
import tn.examen.spring.repositories.ClasseRepo;
import tn.examen.spring.repositories.CoursClassroomRepo;
import tn.examen.spring.repositories.UtilisateurRepo;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ExamenServiceImp implements IExamenService{

    ClasseRepo classeRepo;
    CoursClassroomRepo coursClassroomRepo;
    UtilisateurRepo utilisateurRepo;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepo.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe = classeRepo.findById(codeClasse).orElse(null);
        cc.setClasse(classe);

        return coursClassroomRepo.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur utilisateur = utilisateurRepo.findById(idUtilisateur).orElse(null);
        Classe classe = classeRepo.findById(codeClasse).orElse(null);

        utilisateur.setClasse(classe);
        utilisateurRepo.save(utilisateur);

    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        int nbr;
        List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
        nbr = (int) utilisateurs.stream().count();

        return nbr;
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom coursClassroom = coursClassroomRepo.findById(idCours).orElse(null);
        coursClassroom.setClasse(null);
        coursClassroomRepo.save(coursClassroom);
    }

    @Scheduled(fixedRate = 60000)
    //@Scheduled(cron = "*/60 * * * * *")
    @Override
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursClassrooms = coursClassroomRepo.findAll();
        for (CoursClassroom cc : coursClassrooms)
            cc.setArchive(true);
        coursClassroomRepo.saveAll(coursClassrooms);

    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        //List<CoursClassroom> coursClassroomList = coursClassroomRepo.findBySpecialite(sp);
        List<CoursClassroom> coursClassroomList = coursClassroomRepo.findAll();
        int nbrh=0;
        for (CoursClassroom c : coursClassroomList)
            if (c.getClasse() !=null &&c . getClasse().getNiveau() == nv && c.getSpecialite() == sp)
                nbrh +=c.getNbHeures();

        return nbrh;
    }





}
