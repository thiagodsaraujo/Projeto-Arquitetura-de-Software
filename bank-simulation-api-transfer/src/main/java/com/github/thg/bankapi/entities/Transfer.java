package com.github.thg.bankapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long numContaDestino;
	private Double valorTransferencia;
	private long numContaOrigem;

	
	
	public Transfer() {
		
	}
	
	public Transfer(long numContaOrigem, Double valorTransferencia, long numContaDestino) {
		super();
		this.numContaDestino = numContaDestino;
		this.valorTransferencia = valorTransferencia;
		this.numContaOrigem = numContaOrigem;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getNumContaDestino() {
		return numContaDestino;
	}

	public void setNumContaDestino(long numContaDestino) {
		this.numContaDestino = numContaDestino;
	}

	public long getNumContaOrigem() {
		return numContaOrigem;
	}

	public void setNumContaOrigem(long numContaOrigem) {
		this.numContaOrigem = numContaOrigem;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	
	
	
	
	

}
