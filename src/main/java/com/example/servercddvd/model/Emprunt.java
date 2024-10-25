package com.example.servercddvd.model;


import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private Cd cd;


    @NotNull
    @Column(name = "date_emprunt")
    private LocalDate dateEmprunt;

    @NotNull
    @Column(name = "date_retour_prevu")
    private LocalDate dateRetourPrevu;

    @Column(name = "date_retour")
    private LocalDate dateRetour;

    public Emprunt() {}

    public Emprunt(Cd cd, LocalDate dateEmprunt, LocalDate dateRetourPrevu) {
        this.cd = cd;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }


    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", cd=" + cd +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetourPrevu=" + dateRetourPrevu +
                ", dateRetour=" + dateRetour +
                '}';
    }
}
