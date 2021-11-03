package com.glorya.dashboard.controller;

import com.glorya.dashboard.model.Cartao;
import com.glorya.dashboard.model.GloryaReport;
import com.glorya.dashboard.service.CartaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/cartao")

public class CartaoController {
    private final CartaoService cartaoService;

    @Autowired
    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Cartao> getCartoes() {
        return cartaoService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "cartaoPremiados")
    public List<Object> getCartaoPremiados() {
        return cartaoService.getCartaoPremiados();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "save")
    public void registrarNovoCartao(@RequestBody Cartao cartao) {
        cartaoService.saveCartao(cartao);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "updatePremiado")
    public void associarCartao(@RequestBody String cpf) {
        cartaoService.updateCartaoPremiado(cpf);
    }
}
 