package com.glorya.dashboard.model;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_cartao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proxy")
    private Long proxyId;

    @Column(name = "credito")
    private double credito;

    @Column(name = "data_expiracao")
    private String dataExpiracao;

    @Column(name = "PAM")
    private String pam;

    @ManyToOne()
    @JoinColumn(name="id", nullable = true)
    private Premiado premiado;
}
