package com.glorya.dashboard.controller;

import com.glorya.dashboard.model.Cartao;
import com.glorya.dashboard.model.Premiado;
import com.glorya.dashboard.service.CartaoService;
import com.glorya.dashboard.service.PremiadoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/premiado")
public class PremiadoController {
    private final PremiadoService premiadoService;

    @Autowired
    public PremiadoController(PremiadoService premiadoService) {
        this.premiadoService = premiadoService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<Premiado> getPremiados() {
        return premiadoService.getAll();
    }

}
