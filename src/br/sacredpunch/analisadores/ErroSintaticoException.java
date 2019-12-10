package br.sacredpunch.analisadores;

import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class ErroSintaticoException extends Exception {

	private Token token;

	public ErroSintaticoException(Token token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Há um erro Sintático neste código: " + " >> ("
				+ this.token.getLin() + ", " + this.token.getCol() + ") " + this.token.getLexema().toString();
	}

}
