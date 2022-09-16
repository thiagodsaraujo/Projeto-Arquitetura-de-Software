package br.com.olimposistema.aipa.auth.token;

import br.com.olimposistema.aipa.auth.User;

import java.util.Date;

public interface GeradorToken {
	String gerarToken(User userPayload);
	String gerarToken(String usuario);
	boolean validaToken(String token);
	Date getDataValidadeTokenStartingNow();
}
