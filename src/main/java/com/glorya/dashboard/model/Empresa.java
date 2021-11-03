package com.glorya.dashboard.model;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_empresa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Integer id;

    @Column(name = "nome_empresa", length = 50)
    private String nome;

    @Column(name = "CNPJ")
    private String cnpj;


}
