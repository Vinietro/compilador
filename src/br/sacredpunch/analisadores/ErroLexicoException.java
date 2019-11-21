package br.sacredpunch.analisadores;

import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class ErroLexicoException extends Exception {
	
	// Criar metodos para testar os lexemas
	
	private char c;
	private String lexema;
	
	
	public ErroLexicoException(char c2, String string) {
		this.c = c2;
		this.lexema = string;
	}

	@Override
	public String toString() {
		
		Token t = null;
		
		return this.c + ": " + "Não é um lexema valido" + " " + "--> " + "|" + this.lexema;
	}
	
	

}
