package com.github.thg.bankapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.thg.bankapi.dto.ContaDto;
import com.github.thg.bankapi.entities.Transfer;
import com.github.thg.bankapi.repositories.TransferRepository;
import com.github.thg.bankapi.request.ContaRequestTransfer;


@Service
public class TransferService {
	
	@Autowired
	ContaRequestTransfer contaRequestTransfer;
	
	@Autowired
	TransferRepository repository;
	
	public ContaDto findById(Long id) {
		return contaRequestTransfer.findById(id);
	}
	
	
	public Optional<Transfer> findById2(Long id) {
		return repository.findById(id);
	}
	
	public List<Transfer> findAll() {
		return repository.findAll();
	}
	
//	public Transfer getPayment(long contaId, Double valueSlip, String codeSlip) throws FeignException {
//		ContaDto conta = contaRequest.findById(contaId);
//		return new PaymentSlip(codeSlip, EnumStatus.PAGO, valueSlip, conta.getId());
//	}
//	
//	
//	
//	// jogar o id do boleto e identificar o boleto
//	public Transfer getPaymentNew(long idBoleto, long contaId, Double valor, String codeSlip) {
//		Transfer boleto = repository.findById(idBoleto).get();
//		
//		Double valorBoleto = boleto.setValueSlip(valor);
//		
//		ContaDto conta = contaRequestTransfer.findById(contaId);
//		
//		return new PaymentSlip(codeSlip, EnumStatus.PAGO, valorBoleto, conta.getId());
//	}

}
