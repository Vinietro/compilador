package br.sacredpunch.units;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import br.sacredpunch.analisadores.Lexico;
import br.sacredpunch.units.Token;

//Esta classe é criada como um singleton

public class TabSimbolos {
	private  static TabSimbolos instance = new TabSimbolos();
	
	
	private Map<String, Token> tabela;
	
	
	private TabSimbolos() {
		tabela = new HashMap<String, Token>();
		//Pré-carregar a tabela com todas as PALAVRAS RESERVADAS
		//tab.put ou add ("for", new Token(TokenType.FOR, "for"<-lexema)); Pré-carregar
		tabela.put("for", new Token(TokenType.FOR, "for", 0, 0));//para todas as palavras reservadas
		tabela.put("verdadeiro", new Token(TokenType.LOGIC_VAL, "verdadeiro", 0, 0));	
		tabela.put("falso", new Token(TokenType.LOGIC_VAL, "falso", 0, 0));	
		tabela.put("nao", new Token(TokenType.LOGIC_OP, "nao", 0, 0));	
		tabela.put("end", new Token(TokenType.LOGIC_OP, "end", 0, 0));
		tabela.put("or", new Token(TokenType.LOGIC_OP, "or", 0, 0));
		tabela.put("bool", new Token(TokenType.TYPE, "bool", 0, 0));
		tabela.put("text", new Token(TokenType.TYPE, "text", 0, 0));
		tabela.put("int", new Token(TokenType.TYPE, "int", 0, 0));
		tabela.put("float", new Token(TokenType.TYPE, "float", 0, 0));
		tabela.put("programa", new Token(TokenType.PROGRAM, "programa", 0, 0));
		tabela.put("end_prog", new Token(TokenType.END_PROG, "end_prog", 0, 0));
		tabela.put("inicio", new Token(TokenType.BEGIN, "inicio", 0, 0));
		tabela.put("fim", new Token(TokenType.END, "fim", 0, 0));
		tabela.put("se", new Token(TokenType.IF, "se", 0, 0));
		tabela.put("entao", new Token(TokenType.THEN, "entao", 0, 0));
		tabela.put("senao", new Token(TokenType.ELSE, "senao", 0, 0));
		tabela.put("para", new Token(TokenType.FOR, "para", 0, 0));
		tabela.put("enquanto", new Token(TokenType.WHILE, "enquanto", 0, 0));
		tabela.put("declare", new Token(TokenType.DECLARE, "declare", 0, 0));
		tabela.put("ate", new Token(TokenType.TO, "ate", 0, 0));		
	}
	
	public static TabSimbolos getInstance() {
		
		
		return instance;
	}
	
	
	public void printTabela() {
		System.out.println(this.tabela.toString());		
	}


	public Token comparaID(String lex, int lin, int col) {
		Token t = tabela.get(lex);
		
		if(t != null) {
			t.setLin(lin);
			t.setCol(col);
		}else {
			t = new Token(TokenType.ID, lex, lin, col);
			tabela.put(lex, t);
		}
		
		return t;
		
	}

	
	
}
