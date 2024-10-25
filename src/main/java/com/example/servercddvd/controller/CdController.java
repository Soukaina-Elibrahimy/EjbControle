package com.example.servercddvd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CdController {
    @GetMapping("/liste-cds")
    public String afficherListeCDs() {
        return "listCDs";
    }
}