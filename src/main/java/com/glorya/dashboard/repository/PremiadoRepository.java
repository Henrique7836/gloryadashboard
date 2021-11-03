package com.glorya.dashboard.repository;

import java.util.List;
import java.util.Optional;

import com.glorya.dashboard.model.Premiado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiadoRepository extends JpaRepository<Premiado, Integer>{
    List<Premiado> findPremiadoByNome(String nome);
    Optional<Premiado> findPremiadoByCPF(String cpf);
}
