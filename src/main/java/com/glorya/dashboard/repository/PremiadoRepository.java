package com.glorya.dashboard.repository;

import java.util.List;

import com.glorya.dashboard.model.Premiado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiadoRepository extends JpaRepository<Premiado, Long>{
    List<Premiado> findPremiadoByNome(String nome);
}
