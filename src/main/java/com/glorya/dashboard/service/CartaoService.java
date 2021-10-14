package com.glorya.dashboard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.glorya.dashboard.model.Cartao;
import com.glorya.dashboard.repository.CartaoRepository;

import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository empresaRepo) {
        this.cartaoRepository = empresaRepo;
    }

    public List<Cartao> getAll() {
        return cartaoRepository.findAll();
    }

    public Cartao getCartao(Long cartaoId) {
        Cartao premiadoRecuperado = cartaoRepository.findById(cartaoId)
                .orElseThrow(() -> new IllegalStateException("Cartao com Id" + cartaoId + "não consta na base"));
        return premiadoRecuperado;
    }

    public Cartao getCartaoByPAM(String cartaoPAM) {

        Optional<Cartao> cartaoOptional = cartaoRepository.findCartaoByPAM(cartaoPAM);

        if(!cartaoOptional.isPresent()) {
            throw new IllegalStateException("Cartão com PAM" + cartaoPAM + "não existe");
        }

        return cartaoOptional.get();
    }

    public void saveCartao(Cartao cartao) {
        boolean premiadoExists = cartaoRepository.findById(cartao.getProxyId()).isPresent();
        if (premiadoExists) {
            throw new IllegalStateException("Cartao com numero" + cartao.getPam() + "já cadastrado");
        }
        cartaoRepository.save(cartao);
    }

    public void deleteCartao(Long cartaoId) {
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
