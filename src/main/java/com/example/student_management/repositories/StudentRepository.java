package com.example.student_management.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.student_management.entities.Student;

// Cette annotation indique que cette interface représente la couche d'accès aux données
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Méthode permettant de récupérer un étudiant en utilisant son identifiant
    Student findById(int id);

    // Requête JPQL personnalisée qui calcule le nombre d'étudiants selon leur année de naissance
    // La requête retourne l'année ainsi que le total d'étudiants pour cette année
    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();
}