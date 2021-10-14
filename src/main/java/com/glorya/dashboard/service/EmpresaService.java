package com.glorya.dashboard.service;

import com.glorya.dashboard.repository.EmpresaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.glorya.dashboard.model.Empresa;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepo) {
        this.empresaRepository = empresaRepo;
    }

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresa(Long empresaId) {
        Empresa premiadoRecuperado = empresaRepository.findById(empresaId)
            .orElseThrow(() -> new IllegalStateException("Empresa com Id" + empresaId + "não consta na base"));
        return premiadoRecuperado;
    }

    public List<Empresa> getEmpresaByName(String premiadoName) {
        try {
            List<Empresa> premiadosRecuperado = empresaRepository.findEmpresaByNome(premiadoName);
            return premiadosRecuperado;
        } catch (Exception e) {
            throw e;
        }
    }

    public void saveEmpresa(Empresa empresa) {
        boolean premiadoExists = empresaRepository.findById(empresa.getId()).isPresent();
        if(premiadoExists) {
            throw new IllegalStateException("Empresa com CPF" + empresa.getCnpj() + "já cadastrado");
        }
        empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long empresaId) {
        boolean premiadoExists = empresaRepository.findById(empresaId).isPresent();
        if(!premiadoExists) {
            throw new IllegalStateException("Empresa com Id" + empresaId + "não existe");
        }
        empresaRepository.deleteById(empresaId);
    }

    @Transactional
    public void updateEmpresa(Empresa empresa) {

        Empresa empresaRecuperado = empresaRepository.findById(empresa.getId())
            .orElseThrow(() -> new IllegalStateException("Empresa com CNPJ:" + empresa.getCnpj() +"não existe na base"));
        
            empresaRecuperado.setCnpj(empresa.getCnpj());
            empresaRecuperado.setId(empresa.getId());
            empresaRecuperado.setNome(empresa.getNome());
            empresaRecuperado.setPremiados(empresa.getPremiados());
    }


}
