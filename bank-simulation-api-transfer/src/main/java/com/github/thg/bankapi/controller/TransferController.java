package com.github.thg.bankapi.controller;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.thg.bankapi.dto.ContaDto;
import com.github.thg.bankapi.entities.Conta;
import com.github.thg.bankapi.entities.Transfer;
import com.github.thg.bankapi.repositories.TransferRepository;
import com.github.thg.bankapi.request.ContaRequestTransfer;
import com.github.thg.bankapi.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	
	@Autowired
	private TransferService service;
	
	@Autowired
	ContaRequestTransfer contaRequest;
	
	@Autowired
	TransferRepository repository;
	
	
	@Autowired
    private ServletWebServerApplicationContext server;
	
	
	
//	@PostMapping(value = "/{contaId}/{valueSlip}")
//	public ResponseEntity<PaymentSlip> getPaymentSlip(@PathVariable Long contaId, @PathVariable Double valueSlip){
//		PaymentSlip registerPayment = new PaymentSlip(true, valueSlip, contaId);
//		PaymentSlip paymentSlip = service.getPayment(contaId, valueSlip, "123");
//		System.out.println("Pagemtno realizado!");
//		return new ResponseEntity(repository.save(paymentSlip),HttpStatus.CREATED);
//	}
	
	
	@GetMapping("/test")
	public String getTest() {
		return contaRequest.getTest();
	}
	
	@GetMapping("transfer/{id}")
	public final ContaDto findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@GetMapping("/listContas")
	public ResponseEntity<List<Conta>> listAll(){
		return contaRequest.listContas();
	}
	
	@GetMapping("conta/{id}")
	public ResponseEntity<ContaDto> contaById(@PathVariable Long id){
		ContaDto contaEncontrada = contaRequest.findById(id);
		return ResponseEntity.ok(contaEncontrada);
	}
	
	
	@PostMapping("do/{contaOrigemId}/{valor}/{contaDestinoId}")
	public String generateTransfer( 
			@PathVariable Long contaOrigemId,
			@PathVariable Double valor,
			@PathVariable Long contaDestinoId
			) {
		
		Transfer transferencia = new Transfer(contaOrigemId, valor, contaDestinoId);
		repository.save(transferencia);
		
		if (contaRequest.getTransfer(contaOrigemId,valor, contaDestinoId) != null) {
			HttpStatus ok = HttpStatus.OK;
			System.out.println(server.getWebServer().getPort());
			return "TRANSFERÊNCIA REALIZADA COM SUCESSO! "
					+ "Código da Transferencia: " + transferencia.getId()
			+ " / Valor: R$ " + transferencia.getValorTransferencia() +
			" / CONTA ORIGEM:  " + transferencia.getNumContaOrigem() +
			" / CONTA DESTINO: " + transferencia.getNumContaDestino()
			+ ok;
			
		}
		
		return "Erro ao gerar a transferência";
	}
	
	@PostMapping("transfer1/{contaOrigemId}/{valor}/{contaDestinoId}")
	public boolean generateTransfer2(
			@PathVariable Long contaOrigemId,
			@PathVariable Double valor,
			@PathVariable Long contaDestinoId) {
		
		contaRequest.postTransfer(contaOrigemId, valor, contaDestinoId);
		return true;
	}
	
	
	
}
