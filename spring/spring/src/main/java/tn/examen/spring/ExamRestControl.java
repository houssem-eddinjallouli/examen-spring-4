package tn.examen.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.examen.spring.entities.*;
import tn.examen.spring.services.IExamenService;

@RestController
@RequestMapping("/exam")
public class ExamRestControl {
    @Autowired
    IExamenService iExamenService;

    @PostMapping("/addu")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return iExamenService.ajouterUtilisateur(utilisateur);
    }

    @PostMapping("/addclasse")
    public Classe ajouterClasse(Classe c) {
        return iExamenService.ajouterClasse(c);
    }

    @PostMapping("/addcours/{code}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable("code") Integer codeClasse) {
        return iExamenService.ajouterCoursClassroom(cc,codeClasse);
    }

    @PutMapping("/affecteruc/{idu}/{codec}")
    public void affecterUtilisateurClasse(@PathVariable("idu") Integer idUtilisateur,@PathVariable("codec") Integer codeClasse) {
        iExamenService.affecterUtilisateurClasse(idUtilisateur,codeClasse);
    }

    @GetMapping("/nbrutilisateur/{n}")
    public Integer nbUtilisateursParNiveau(@PathVariable("n") Niveau nv) {
        return iExamenService.nbUtilisateursParNiveau(nv);
    }

    @PutMapping("/desaffecteruc/{idc}")
    public void desaffecterCoursClassroomClasse(@PathVariable("idc") Integer idCours) {
        iExamenService.desaffecterCoursClassroomClasse(idCours);
    }


    @GetMapping("/nbrutilisateur/{sp}/{nv}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable("sp") Specialite sp,@PathVariable("nv") Niveau nv) {
        return iExamenService.nbHeuresParSpecEtNiv(sp,nv);
    }



    }
