package com.github.thg.bankapi.services.exceptions;

public class SaldoInsuficienteException extends Exception{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
