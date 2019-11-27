package br.sacredpunch.analisadores;

import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class ErroSintaticoException extends Exception {
	
	private TokenType token;
	
	
	public ErroSintaticoException(TokenType tokenType) {
		this.token = tokenType;
	}

	@Override
	public String toString() {
		
		return "Há um erro Sintático neste código: " + " >> " + this.token.toString();
	}

}
