package br.sacredpunch.analisadores;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.TabSimbolos;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;
import br.sacredpunch.analisadores.ErroLexicoException;

public class Sintatico {
	private Lexico lex;
	
	private ErroLexicoException ele;
	
	public Sintatico(String filename) throws FileNotFoundException {
		this.lex = new Lexico();
		this.lex.getFileName(filename);
	}
	
	public void processar() throws IOException {
		//imprimir o cabeçalho de saída
		//--------------------------------
		//(lin, col) | Token   |Lexema
		System.out.println("LINHA COLUNA | Token | Lexema");
		//Chama nextToken até que um EOF ocorra
		Token t = lex.nextToken();
		while (t.getTokenType() != TokenType.EOF) {
			t.printToken();
			t = lex.nextToken();
		}
		
		//Imprimir a tabela de símbolos
		TabSimbolos.getInstance().printTabela();
		
		//imprimir relatorio de erros
		//ErrorHandler.getInstance().printErrorReport();
	}
}
