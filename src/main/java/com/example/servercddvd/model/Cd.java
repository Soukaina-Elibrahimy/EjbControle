package com.example.servercddvd.model;

import jakarta.persistence.*;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "cd")
@NamedQueries({
            @NamedQuery(name = "CD.findAll", query = "SELECT c FROM cd c"),
            @NamedQuery(name = "CD.findByTitle", query = "SELECT c FROM cd c WHERE c.title = :title"),
            @NamedQuery(name = "CD.findAvailable", query = "SELECT c FROM cd c WHERE c.isEmprunte = false")
 })
    public class Cd {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "title")
        private String title;

        @NotNull
        @Column(name = "is_emprunte")
        private boolean isEmprunte;

        @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL)
        private List<Emprunt> emprunts;

        public Cd() {
            this.isEmprunte = false;
        }

        // Getters et Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isEmprunte() {
            return isEmprunte;
        }

        public void setEmprunte(boolean emprunte) {
            isEmprunte = emprunte;
        }

        public List<Emprunt> getEmprunts() {
            return emprunts;
        }
        public void setEmprunts(List<Emprunt> emprunts) {
            this.emprunts = emprunts;
        }

        @Override
        public String toString() {
            return "CD [id=" + id + ", title=" + title + ", isEmprunte=" + isEmprunte + "]";
        }
    }