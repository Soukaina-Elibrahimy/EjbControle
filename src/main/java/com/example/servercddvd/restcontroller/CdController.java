package com.example.servercddvd.restcontroller;

import com.example.servercddvd.model.Cd;
import com.example.servercddvd.repository.CdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cds")
public class CdController {
    @Autowired
    private final CdRepository cdRepository;

    @Autowired
    public CdController(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    @GetMapping("/disponibles")
    public List<Cd> listerCDDisponibles() {
        return cdRepository.findByIsEmprunteFalse();
    }
}
