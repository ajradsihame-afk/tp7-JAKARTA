package com.example.student_management.controllers;

import com.example.student_management.entities.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

// Cette classe représente un contrôleur REST pour gérer les étudiants
// Les réponses envoyées seront automatiquement converties en JSON
@RestController

// Définit le chemin de base utilisé par toutes les routes de ce contrôleur
@RequestMapping("/students")
public class StudentController {

    // Injection du service chargé de la logique métier liée aux étudiants
    @Autowired
    private StudentService studentService;

    // API permettant d'ajouter un nouvel étudiant dans la base
    // Les informations de l'étudiant sont envoyées au format JSON dans la requête
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {

        // Appelle le service pour enregistrer l'étudiant
        Student savedStudent = studentService.save(student);

        // Retourne l'objet sauvegardé avec le code HTTP 201 indiquant la création
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // API utilisée pour supprimer un étudiant en fonction de son identifiant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {

        // Demande au service d'effectuer la suppression
        boolean deleted = studentService.delete(id);

        // Si l'étudiant a été supprimé correctement on renvoie 204
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // Si aucun étudiant ne correspond à cet id on renvoie 404
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API pour obtenir la liste complète des étudiants enregistrés
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {

        // Récupération de tous les étudiants via le service
        List<Student> students = studentService.findAll();

        // Retour de la liste avec le statut HTTP 200
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // API qui renvoie le nombre total d'étudiants présents dans la base
    @GetMapping("/count")
    public ResponseEntity<Long> countStudent() {

        // Calcul du nombre d'étudiants
        long count = studentService.countStudents();

        // Renvoi du résultat avec le code 200
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // API qui fournit des statistiques du nombre d'étudiants par année
    @GetMapping("/byYear")
    public ResponseEntity<Collection<?>> findByYear() {

        // Récupération des données statistiques via le service
        Collection<?> studentsByYear = studentService.findNbrStudentByYear();

        // Envoie les résultats au client
        return new ResponseEntity<>(studentsByYear, HttpStatus.OK);
    }
}