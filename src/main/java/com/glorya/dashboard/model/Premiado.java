package com.glorya.dashboard.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_premiado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Premiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premiado_id")
    private Integer id;

    @Column(name = "nome_premiado", length = 50)
    private String nome;

    @Column(name = "CPF", length = 11)
    private String CPF;
    
    @ManyToOne()
    @JoinColumn(name="empresa_id", nullable = true)
    private Empresa empresa;

}
