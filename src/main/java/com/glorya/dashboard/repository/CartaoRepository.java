package com.glorya.dashboard.repository;

import java.util.Optional;

import com.glorya.dashboard.model.Cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {


    @Query(value ="SELECT c FROM Cartao c WHERE c.pam = pam")
    Optional<Cartao> findCartaoByPAM(String pam);
}
