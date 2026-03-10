package com.example.student_management.service;

import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

// Classe de service contenant les traitements liés aux étudiants
// Elle sert d'intermédiaire entre le contrôleur REST et la couche repository
@Service
public class StudentService {

    // Injection du repository afin d'effectuer les opérations sur la base de données
    @Autowired
    private StudentRepository studentRepository;

    // Fonction qui permet d'ajouter un nouvel étudiant ou de modifier un étudiant déjà existant
    public Student save(Student student) {

        // La méthode save() du repository gère automatiquement l'insertion ou la mise à jour
        return studentRepository.save(student);
    }

    // Fonction permettant de supprimer un étudiant à partir de son identifiant
    public boolean delete(int id) {

        // Recherche de l'étudiant correspondant à l'id fourni
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));

        // Si l'étudiant est trouvé dans la base
        if (studentOptional.isPresent()) {

            // Suppression de l'étudiant
            studentRepository.delete(studentOptional.get());
            return true;
        }
        // Si aucun étudiant n'est trouvé avec cet id
        else {
            return false;
        }
    }

    // Fonction qui récupère tous les étudiants enregistrés
    public List<Student> findAll() {

        // Appel de la méthode findAll() du repository
        return studentRepository.findAll();
    }

    // Fonction qui calcule le nombre total d'étudiants
    public long countStudents() {

        // La méthode count() est fournie par l'interface JpaRepository
        return studentRepository.count();
    }

    // Fonction qui retourne les statistiques du nombre d'étudiants selon leur année de naissance
    public Collection<?> findNbrStudentByYear() {

        // Utilisation de la requête personnalisée définie dans le repository
        return studentRepository.findNbrStudentByYear();
    }
}