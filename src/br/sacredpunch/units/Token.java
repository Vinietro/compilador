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
		
		System.out.println(this.getLin() + "     " + this.getCol() + "      | " 
				+ this.getTokenType() + " | " + this.lexema.toString());
	}
	
}
