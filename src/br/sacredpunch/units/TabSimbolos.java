package br.sacredpunch.units;

import java.util.HashMap;
import java.util.Map;

//Esta classe é criada como um singleton

public class TabSimbolos {
	private  static TabSimbolos instance = new TabSimbolos();
	
	
	private Map<String, Token> tabela;
	
	
	private TabSimbolos() {
		tabela = new HashMap<String, Token>();
		//Pré-carregar a tabela com todas as PALAVRAS RESERVADAS
		//tab.put ou add ("for", new Token(TokenType.FOR, "for"<-lexema)); Pré-carregar
		tabela.put("for", new Token(TokenType.FOR, "for"));//para todas as palavras reservadas
		tabela.put("verdadeiro", new Token(TokenType.LOGIC_VAL, "verdadeiro"));	
		tabela.put("falso", new Token(TokenType.LOGIC_VAL, "falso"));	
		tabela.put("nao", new Token(TokenType.LOGIC_OP, "nao"));	
		tabela.put("e", new Token(TokenType.LOGIC_OP, "e"));
		tabela.put("ou", new Token(TokenType.LOGIC_OP, "ou"));
		tabela.put("bool", new Token(TokenType.TYPE, "bool"));
		tabela.put("text", new Token(TokenType.TYPE, "text"));
		tabela.put("int", new Token(TokenType.TYPE, "int"));
		tabela.put("float", new Token(TokenType.TYPE, "float"));
		tabela.put("programa", new Token(TokenType.PROGRAM, "programa"));
		tabela.put("end_prog", new Token(TokenType.END_PROG, "end_prog"));
		tabela.put("inicio", new Token(TokenType.BEGIN, "inicio"));
		tabela.put("fim", new Token(TokenType.END, "fim"));
		tabela.put("se", new Token(TokenType.IF, "se"));
		tabela.put("entao", new Token(TokenType.THEN, "entao"));
		tabela.put("senao", new Token(TokenType.ELSE, "senao"));
		tabela.put("para", new Token(TokenType.FOR, "para"));
		tabela.put("enquanto", new Token(TokenType.WHILE, "enquanto"));
		tabela.put("declare", new Token(TokenType.DECLARE, "declare"));
		tabela.put("ate", new Token(TokenType.TO, "ate"));		
		
	}
	
	public static TabSimbolos getInstance() {
		return instance;
	}
	
	public void printTabela() {
		
	}
	
}
