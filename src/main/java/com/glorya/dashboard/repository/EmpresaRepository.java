package com.glorya.dashboard.repository;

import java.util.List;

import com.glorya.dashboard.model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findEmpresaByNome(String nome);
}
