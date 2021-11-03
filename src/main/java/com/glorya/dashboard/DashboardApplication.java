package com.glorya.dashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.glorya.dashboard.model.*;
import com.glorya.dashboard.service.*;

@SpringBootApplication
public class DashboardApplication implements CommandLineRunner{

	private final CartaoService cartaoService;
	private final EmpresaService empresaService;
	private final PremiadoService premiadoService;

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

	public DashboardApplication(CartaoService cartaoService, EmpresaService empresaService, PremiadoService premiadoService) {
		this.cartaoService = cartaoService;
		this.empresaService = empresaService;
		this.premiadoService = premiadoService;
	}

	@Override
	public void run(String... args) throws Exception {
		String date = LocalDate.now().toString();
		
		Cartao cartao = new Cartao(1, 25.00, date, "251945445521245", null);
		Cartao cartao2 = new Cartao(2, 35.00, date, "111111111111111", null);
		Cartao cartao3 = new Cartao(3, 45.00, date, "255545445521898", null);
		Cartao cartao4 = new Cartao(4, 45.00, date, "266545445521888", null);
		Cartao cartao5 = new Cartao(5, 25.00, date, "277545445521878", null);
		Cartao cartao6 = new Cartao(6, 15.00, date, "288545445521868", null);
		Cartao cartao7 = new Cartao(7, 55.00, date, "299545445521858", null);
		Cartao cartao8 = new Cartao(8,105.00, date, "333478981235457", null);

		
		cartaoService.saveCartao(cartao);
		cartaoService.saveCartao(cartao2);
		cartaoService.saveCartao(cartao3);
		cartaoService.saveCartao(cartao4);
		cartaoService.saveCartao(cartao5);
		cartaoService.saveCartao(cartao6);
		cartaoService.saveCartao(cartao7);
		cartaoService.saveCartao(cartao8);

		Premiado premiado = new Premiado(1, "Jose Aldo", "40445698742", null);
		Premiado premiado2 = new Premiado(2, "Todd Philips", "40445698741", null);
		Premiado premiado3 = new Premiado(3, "Carlos Albert", "40465698741", null);
		Premiado premiado4 = new Premiado(4, "Cassia Olivar", "5105451511", null);
		Premiado premiado5 = new Premiado(5, "Denise Ranges", "48152105185", null);
		Premiado premiado6 = new Premiado(6, "Tiggo Mackintosh", "45456446444", null);
		Premiado premiado7 = new Premiado(7, "Sergio Ramos", "3034698741", null);
		Premiado premiado8 = new Premiado(8, "Gilberto Silva", "40445699941", null);
		Premiado premiado9 = new Premiado(9, "Henrique Rangel", "40785548765", null);
		
		premiadoService.savePremiado(premiado);
		premiadoService.savePremiado(premiado2);
		premiadoService.savePremiado(premiado3);
		premiadoService.savePremiado(premiado4);
		premiadoService.savePremiado(premiado5);
		premiadoService.savePremiado(premiado6);
		premiadoService.savePremiado(premiado7);
		premiadoService.savePremiado(premiado8);
		premiadoService.savePremiado(premiado9);

		Empresa empresa = new Empresa(1, "VIVO", "547875464878456474");
		Empresa empresa2 = new Empresa(2, "CLARO", "547875464878456474");
		Empresa empresa3 = new Empresa(3, "TIM", "547875464878456474");

		cartao.setPremiado(premiado);
		cartao2.setPremiado(premiado2);
		cartao3.setPremiado(premiado3);
		cartao4.setPremiado(premiado);
		cartao5.setPremiado(premiado5);
		cartao6.setPremiado(premiado6);
		cartao7.setPremiado(premiado);


		cartaoService.updateCartao(cartao);
		cartaoService.updateCartao(cartao2);
		cartaoService.updateCartao(cartao3);
		cartaoService.updateCartao(cartao4);
		cartaoService.updateCartao(cartao5);
		cartaoService.updateCartao(cartao6);
		cartaoService.updateCartao(cartao7);

		// cartaoService.saveCartao(cartao);
		
		empresaService.saveEmpresa(empresa);
		empresaService.saveEmpresa(empresa2);		
		empresaService.saveEmpresa(empresa3);

		premiado.setEmpresa(empresa);
		premiado2.setEmpresa(empresa2);
		premiado3.setEmpresa(empresa3);
		premiadoService.updatePremiado(premiado);
		premiadoService.updatePremiado(premiado2);
		premiadoService.updatePremiado(premiado3);
	}

}
