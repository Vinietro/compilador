package br.sacredpunch.units;

import java.util.HashMap;
import java.util.Map;

//Esta classe � criada como um singleton

public class TabSimbolos {
	private  static TabSimbolos instance = new TabSimbolos();
	
	
	private Map<String, Token> tabela;
	
	
	private TabSimbolos() {
		tabela = new HashMap<String, Token>();
		//Pr�-carregar a tabela com todas as PALAVRAS RESERVADAS
		//tab.put ou add ("for", new Token(TokenType.FOR, "for"<-lexema)); Pr�-carregar
	}
	
	public static TabSimbolos getInstance() {
		return instance;
	}
	
	public void printTabela() {
		
	}
	
}
