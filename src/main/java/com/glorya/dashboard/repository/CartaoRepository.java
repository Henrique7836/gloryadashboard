package com.glorya.dashboard.repository;

import java.util.List;
import java.util.Optional;

import com.glorya.dashboard.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    @Query(value ="SELECT c FROM Cartao c WHERE c.pam = ?1")
    Optional<Cartao> findByPAM(String pam);

    @Query(value ="SELECT c FROM Cartao c WHERE c.premiado is null")
    Optional<Cartao> findEmpty();
    
    @Query(value = "SELECT cartao.proxy, cartao.PAM, premiado.nome_premiado, premiado.cpf, empresa.nome_empresa,cartao.credito, cartao.data_expiracao FROM public.tb_cartao AS cartao RIGHT JOIN public.tb_premiado AS premiado ON cartao.premiado_id = premiado.premiado_id LEFT JOIN public.tb_empresa AS empresa ON premiado.empresa_id = empresa.empresa_id;",
    nativeQuery = true)
    List<Object> findCartaoPremiados();
}
