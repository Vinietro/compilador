////////////////////////////////////////////
// Vinícius De Vietro 191515141		 	  //	
// Geovanni Peixoto Silva 171151048  	  //
// Lucas Alves de Medeiros 162150020 	  //
// Maicon Parra da Silva 1821519513  	  //
// Lucas Gomes de Melo Bonafé 1921519487  //
////////////////////////////////////////////
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
