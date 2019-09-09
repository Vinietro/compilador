package br.sacredpunch.analisadores;

import java.io.FileNotFoundException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.TabSimbolos;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class Sintatico {
	private Lexico lex;
	
	public Sintatico(String filename) throws FileNotFoundException {
		this.lex = new Lexico(filename);
	}
	
	public void processar() {
		//imprimir o cabeçalho de saída
		//--------------------------------
		//(lin, col) | Token   |Lexema
		
		//Chama nextToken até que um EOF ocorra
		Token t = lex.nextToken();
		while (t.getTokenType() != TokenType.EOF) {
			t.printToken();
			t = lex.nextToken();
		}
		
		//Imprimir a tabela de símbolos
		TabSimbolos.getInstance().printTabela();
		
		//imprimir relatorio de erros
		ErrorHandler.getInstance().printErrorReport();
	}
}
