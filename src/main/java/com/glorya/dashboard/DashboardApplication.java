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
		LocalDate date = LocalDate.now();
		
		Cartao cartao = new Cartao(1L, 25.00, "05/05/25", "254545445521445", null);
		Cartao cartao2 = new Cartao(2L, 25.00, "05/05/25", "254545445521777", null);
		Cartao cartao3 = new Cartao(3L, 25.00, "05/05/25", "254545445521888", null);
		
		cartaoService.saveCartao(cartao);
		cartaoService.saveCartao(cartao2);
		cartaoService.saveCartao(cartao3);
		Premiado premiado = new Premiado(1L, "Jose Aldo", "40445698741", null, null);
		Premiado premiado2 = new Premiado(2L, "Todd Philips", "40445698741", null, null);
		Premiado premiado3 = new Premiado(3L, "Ruanda Rear", "40445698741", null, null);
		
		premiadoService.savePremiado(premiado);
		premiadoService.savePremiado(premiado2);
		premiadoService.savePremiado(premiado3);
		Empresa empresa = new Empresa(1L, "VIVO", "547875464878456474", null);
		Empresa empresa2 = new Empresa(2L, "CLARO", "547875464878456474", null);
		Empresa empresa3 = new Empresa(3L, "TIM", "547875464878456474", null);

		cartao.setPremiado(premiado);
		cartao2.setPremiado(premiado2);
		cartao3.setPremiado(premiado3);

		List<Premiado> premiados =  new ArrayList<Premiado>();
		// premiados.add(premiado);
		premiados.add(premiado2);
		premiados.add(premiado3);

		empresa.setPremiados(premiados);

		// cartaoService.saveCartao(cartao);
		
		empresaService.saveEmpresa(empresa);
		
	}

}
