package com.example.servercddvd.service;

import com.example.servercddvd.model.Cd;
import com.example.servercddvd.repository.CdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdService {

    @Autowired
    private final CdRepository cdRepository;

    @Autowired
    public CdService(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    public List<Cd> listerCDsDisponibles() {
        return cdRepository.findByIsEmprunteFalse();
    }

    public List<Cd> voirCDsEmpruntes() {
        return cdRepository.findEmpruntes();
    }

    public Cd emprunterCD(Long cdId) {
        Cd cd = cdRepository.findById(cdId).orElse(null);
        if (cd != null && !cd.isEmprunte()) {
            cd.setEmprunte(true);
            cdRepository.save(cd);
        }
        return cd;
    }

    public Cd retournerCD(Long cdId) {
        Cd cd = cdRepository.findById(cdId).orElse(null);
        if (cd != null && cd.isEmprunte()) {
            cd.setEmprunte(false);
            cdRepository.save(cd);
        }
        return cd;
    }
}
