package com.github.thg.bankapi.services.exceptions;

public class ValorInvalidoException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValorInvalidoException() {
    }

    public ValorInvalidoException(String message) {
        super(message);
    }
}
