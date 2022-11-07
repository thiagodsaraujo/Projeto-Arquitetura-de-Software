package com.github.thg.bankapi.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.github.thg.bankapi.dto.ContaDto;
import com.github.thg.bankapi.entities.Conta;

//@FeignClient(name = "bank-simulation-api", path = "/conta")
@FeignClient(value="conta", url = "http://localhost:8765/conta")
public interface ContaRequestTransfer {
	
	
	@GetMapping("/{id}")
	ContaDto findById(@PathVariable Long id);
	
	@GetMapping("/test")
	String getTest();
	
	@GetMapping("/listContas")
	ResponseEntity<List<Conta>> listContas();
	
	@PostMapping("/transferencia/{idContaOrigem}/{valor}/{idContaDestino}")
	public ResponseEntity<Conta> getTransfer(
			@PathVariable Long idContaOrigem, 
			@PathVariable Double valor, 
			@PathVariable Long idContaDestino);
	
	@PostMapping("/attTransfer/{idContaOrigem}/{valor}/{idContaDestino}")
	public String postTransfer(
			@PathVariable Long idContaOrigem, 
			@PathVariable Double valor, 
			@PathVariable Long idContaDestino); 
	
} 
