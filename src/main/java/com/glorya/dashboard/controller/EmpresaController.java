package com.glorya.dashboard.controller;
import com.glorya.dashboard.model.Cartao;
import com.glorya.dashboard.model.Empresa;
import com.glorya.dashboard.service.CartaoService;
import com.glorya.dashboard.service.EmpresaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.getAll();
    }
}
