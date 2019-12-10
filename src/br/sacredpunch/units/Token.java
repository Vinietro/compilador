////////////////////////////////////////////
// Vin�cius De Vietro 191515141		 	  //	
// Geovanni Peixoto Silva 171151048  	  //
// Lucas Alves de Medeiros 162150020 	  //
// Maicon Parra da Silva 1821519513  	  //
// Lucas Gomes de Melo Bonaf� 1921519487  //
////////////////////////////////////////////
package br.sacredpunch.units;

import br.sacredpunch.units.TabSimbolos;

public class Token {
	
	private String lexema;
	private int lin;
	private int col;
	private TokenType tokenType;

	TabSimbolos tab;
	
	public TokenType getTokenType() {
		
		TabSimbolos.getInstance();
		return tokenType;
	}
	
	
	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	public int getLin() {
		return lin;
	}
	public void setLin(int lin) {
		this.lin = lin;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public Token(TokenType tType, String lexema, int lin, int col) {
		
		setTokenType(tType);
		setLexema(lexema);
		setLin(lin);
		setCol(col);
		
	}
	
	
	public void printToken() {
		
		System.out.println("Linha: " + this.getLin() + " Coluna:" + this.getCol() + " Token: " 
				+ this.getTokenType() + " Lexema: " + this.lexema.toString());
	}
	
}
