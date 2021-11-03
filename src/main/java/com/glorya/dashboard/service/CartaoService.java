package com.glorya.dashboard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.glorya.dashboard.model.Cartao;
import com.glorya.dashboard.model.GloryaReport;
import com.glorya.dashboard.model.Premiado;
import com.glorya.dashboard.repository.CartaoRepository;
import com.glorya.dashboard.repository.PremiadoRepository;

import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    private final CartaoRepository cartaoRepository;
    private final PremiadoRepository premiadoRepository;

    public CartaoService(CartaoRepository empresaRepo, PremiadoRepository premiadoRepository) {
        this.cartaoRepository = empresaRepo;
        this.premiadoRepository = premiadoRepository;
    }

    public List<Cartao> getAll() {
        return cartaoRepository.findAll();
    }

    public List<Object> getCartaoPremiados() {
        return cartaoRepository.findCartaoPremiados();
    }

    public Cartao getCartao(Integer cartaoId) {
        Cartao premiadoRecuperado = cartaoRepository.findById(cartaoId)
                .orElseThrow(() -> new IllegalStateException("Cartao com Id" + cartaoId + "não consta na base"));
        return premiadoRecuperado;
    }

    @Transactional
    public void updateCartaoPremiado(String cpf) {
        Optional<Premiado> premiadoRecuperado = premiadoRepository.findPremiadoByCPF(cpf);
        if(!premiadoRecuperado.isPresent()) {
            throw new IllegalStateException("Cartão com PAM" + cpf + "não existe");
        }
        Optional<Cartao> cartaoOptional = cartaoRepository.findEmpty();

        if(!cartaoOptional.isPresent()) {
            throw new IllegalStateException("Não existe cartão sem Premiados");
        }
        cartaoOptional.get().setPremiado(premiadoRecuperado.get());
    }



    public Cartao getCartaoByPAM(String cartaoPAM) {

        Optional<Cartao> cartaoOptional = cartaoRepository.findByPAM(cartaoPAM);

        if(!cartaoOptional.isPresent()) {
            throw new IllegalStateException("Cartão com PAM" + cartaoPAM + "não existe");
        }

        return cartaoOptional.get();
    }

    public void saveCartao(Cartao cartao) {
        boolean cartaoExists = cartaoRepository.findByPAM(cartao.getPam()).isPresent();
        if (cartaoExists) {
            throw new IllegalStateException("Cartao com numero" + cartao.getPam() + "já cadastrado");
        }
        cartaoRepository.save(cartao);
    }



    public void deleteCartao(int cartaoId) {
        boolean premiadoExists = cartaoRepository.findById(cartaoId).isPresent();
        if (!premiadoExists) {
            throw new IllegalStateException("Cartao com Id" + cartaoId + "não existe");
        }
        cartaoRepository.deleteById(cartaoId);
    }

    @Transactional
    public void updateCartao(Cartao cartao) {

        Cartao cartaoRecuperado = cartaoRepository.findById(cartao.getProxyId()).orElseThrow(
                () -> new IllegalStateException("Cartao com PAM:" + cartao.getPam() + "não existe na base"));

        cartaoRecuperado.setCredito(cartao.getCredito());
        cartaoRecuperado.setDataExpiracao(cartao.getDataExpiracao());
        cartaoRecuperado.setPam(cartao.getPam());
        cartaoRecuperado.setPremiado(cartao.getPremiado());
        cartaoRecuperado.setProxyId(cartao.getProxyId());

    }

}
