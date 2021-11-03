package com.glorya.dashboard.model;

import javax.persistence.Entity;

// import com.glorya.dashboard.model.Empresa;
// import com.glorya.dashboard.model.Cartao;
// import com.glorya.dashboard.model.Premiado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
@AllArgsConstructor
@Getter
@Setter

public class GloryaReport {
    private int proxy;
    private String pam;
    private String nomePremiado;
    private String CPF;
    private String empresa;
    private String credito;
    private String vencimento;
}
