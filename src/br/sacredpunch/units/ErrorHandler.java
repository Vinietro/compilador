////////////////////////////////////////////
// Vinícius De Vietro 191515141		 	  //	
// Geovanni Peixoto Silva 171151048  	  //
// Lucas Alves de Medeiros 162150020 	  //
// Maicon Parra da Silva 1821519513  	  //
// Lucas Gomes de Melo Bonafé 1921519487  //
////////////////////////////////////////////
package br.sacredpunch.units;

import br.sacredpunch.analisadores.ErroLexicoException;
import br.sacredpunch.analisadores.ErroSintaticoException;

public class ErrorHandler {
	private  static ErrorHandler instance = new ErrorHandler();	
	
	public static ErrorHandler getInstance() {
		return instance;
	}
	public void printErrorReport(ErroLexicoException ele) {
		System.out.println(ele);		
	}
	
	public void printErrorSintatic(ErroSintaticoException sin) {
		System.out.println("Erro Sintatico: " + sin.toString() + " | " );
	}
	public void printErrorSintDefault(TokenType token, String lexema) {
		// TODO Auto-generated method stub
		System.out.println(" | " + token.toString() + "Valor incorreto: " + lexema);
	}
	
}
