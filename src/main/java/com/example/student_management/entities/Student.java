package com.example.student_management.entities;

import jakarta.persistence.*;
import java.util.Date;

// Indique que cette classe correspond à une entité persistée dans la base de données
@Entity
public class Student {

    // Clé primaire de l'entité
    @Id

    // L'identifiant est généré automatiquement par la base de données
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nom de l'étudiant
    private String nom;

    // Prénom de l'étudiant
    private String prenom;

    // Date de naissance de l'étudiant (stockée uniquement avec la partie date)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    // Constructeur vide requis par JPA
    public Student() {
    }

    // Constructeur permettant d'initialiser les informations principales de l'étudiant
    public Student(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // Retourne l'identifiant de l'étudiant
    public int getId() {
        return id;
    }

    // Modifie l'identifiant
    public void setId(int id) {
        this.id = id;
    }

    // Retourne le nom de l'étudiant
    public String getNom() {
        return nom;
    }

    // Met à jour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Retourne le prénom
    public String getPrenom() {
        return prenom;
    }

    // Modifie le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Retourne la date de naissance
    public Date getDateNaissance() {
        return dateNaissance;
    }

    // Met à jour la date de naissance
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}