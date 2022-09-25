package com.github.thg.bankapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.thg.bankapi.dto.ContaDto;
import com.github.thg.bankapi.dto.PaymentSlipDto;
import com.github.thg.bankapi.entities.Conta;
import com.github.thg.bankapi.entities.PaymentSlip;
import com.github.thg.bankapi.enun.EnumStatus;
import com.github.thg.bankapi.repositories.PaymentSlipRepository;
import com.github.thg.bankapi.request.ContaRequest;


@Service
public class PaymentSlipService {
	
	@Autowired
	ContaRequest contaRequest;
	
	@Autowired
	PaymentSlipRepository repository;
	
	public PaymentSlip findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	public Long findById3(Long id) {
		return repository.findById(id).get().getId();
	}
	
	public Optional<PaymentSlip> findById2(Long id) {
		return repository.findById(id);
	}
	
	public List<PaymentSlip> findAll() {
		return repository.findAll();
	}
	
	public PaymentSlip getPayment(long contaId, Double valueSlip, String codeSlip) {
		ContaDto conta = contaRequest.findById(contaId);
		return new PaymentSlip(codeSlip, EnumStatus.PAGO, valueSlip, conta.getId());
	}
	
	// jogar o id do boleto e identificar o boleto
	public PaymentSlip getPaymentNew(long idBoleto, long contaId, Double valor, String codeSlip) {
		PaymentSlip boleto = repository.findById(idBoleto).get();
		
		Double valorBoleto = boleto.setValueSlip(valor);
		
		ContaDto conta = contaRequest.findById(contaId);
		
		return new PaymentSlip(codeSlip, EnumStatus.PAGO, valorBoleto, conta.getId());
	}

}
