package com.example.servercddvd.repository;

import com.example.servercddvd.model.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdRepository extends JpaRepository<Cd, Long> {
    List<Cd> findByIsEmprunteFalse();

    List<Cd> findByTitle(String title);

    @Query("SELECT c FROM CD c WHERE c.isEmprunte = true")
    List<Cd> findEmpruntes();
}
