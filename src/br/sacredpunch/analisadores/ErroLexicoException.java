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
