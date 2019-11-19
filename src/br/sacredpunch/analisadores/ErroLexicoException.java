package br.sacredpunch.analisadores;

import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class ErroLexicoException extends Exception {
	
	// Criar metodos para testar os lexemas
	
	private char c;
	
	

	ErroLexicoException(char c2) {
		this.c = c2;
	}


	@Override
	public String toString() {
		return this.c + ": " + "Não é um valor valido";
	}
	
	

}
