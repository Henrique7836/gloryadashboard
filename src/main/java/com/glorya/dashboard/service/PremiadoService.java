package com.glorya.dashboard.service;

import java.util.List;

import javax.transaction.Transactional;

import com.glorya.dashboard.model.Premiado;
import com.glorya.dashboard.repository.PremiadoRepository;
import org.springframework.stereotype.Service;

@Service
public class PremiadoService {

    private final PremiadoRepository premiadoRepository;

    public PremiadoService(PremiadoRepository premiadoRepo) {
        this.premiadoRepository = premiadoRepo;
    }

    public List<Premiado> getAll() {
        return premiadoRepository.findAll();
    }

    public Premiado getPremiado(Long premiadoId) {
        Premiado premiadoRecuperado = premiadoRepository.findById(premiadoId)
            .orElseThrow(() -> new IllegalStateException("Premiado com Id" + premiadoId + "não consta na base"));
        return premiadoRecuperado;
    }

    public List<Premiado> getPremiadoByName(String premiadoName) {
        try {
            List<Premiado> premiadosRecuperado = premiadoRepository.findPremiadoByNome(premiadoName);
            return premiadosRecuperado;
        } catch (Exception e) {
            throw e;
        }
    }

    public void savePremiado(Premiado premiado) {
        boolean premiadoExists = premiadoRepository.findById(premiado.getId()).isPresent();
        if(premiadoExists) {
            throw new IllegalStateException("Premiado com CPF" + premiado.getCPF() + "já cadastrado");
        }
        premiadoRepository.save(premiado);
    }

    public void deletarPremiado(Long premiadoId) {
        boolean premiadoExists = premiadoRepository.findById(premiadoId).isPresent();
        if(!premiadoExists) {
            throw new IllegalStateException("Premiado com Id" + premiadoId + "não existe");
        }
        premiadoRepository.deleteById(premiadoId);
    }

    @Transactional
    public void updatePremiado(Premiado premiado) {

        Premiado premiadoRecuperado = premiadoRepository.findById(premiado.getId())
            .orElseThrow(() -> new IllegalStateException("Premiado com CPF:" + premiado.getCPF() +"não existe na base"));
        
            premiadoRecuperado.setCPF(premiado.getCPF());
            premiadoRecuperado.setCartoes(premiado.getCartoes());
            premiadoRecuperado.setEmpresa(premiado.getEmpresa());
            premiadoRecuperado.setId(premiado.getId());
            premiadoRecuperado.setNome(premiado.getNome());
    }


}
