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
		return "H� um erro Sint�tico neste c�digo: " + " >> ("
				+ this.token.getLin() + ", " + this.token.getCol() + ") " + this.token.getLexema().toString();
	}

}
