package br.sacredpunch.analisadores;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.FileLoader;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class Lexico {

	private FileLoader fl;
	// Define variavel "lexema"
	private StringBuilder lexema = new StringBuilder();

	
	
	public void getFileName(String filename) throws FileNotFoundException {
		this.fl = new FileLoader(filename);
	}
	
	public FileLoader setFile() {
		return this.fl;
	}

	public Token nextToken() throws IOException {
		while(true) {
			lexema = new StringBuilder();
			try {
				Token t = null;
				// Verifica fim de arquivo: caso em que retornamos um "Token" EOF
				char c;
				try {
					c = this.fl.getNextChar();
				} catch (EOFException e) {
					return new Token(TokenType.EOF, "");
				}
		
				// Descarte de espa�os em branco
				while (Character.isWhitespace(c)) {
					c = this.fl.getNextChar();
				}
		
				// Eliminar coment�rios: {# .. #}
		
				lexema.append(c);
		
				// Busca token
				switch (c) {				
				case '+':
					t = new Token(TokenType.ARIT_AS, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case '-':
					// Retorna token do tipo ARIT_AS
					t = new Token(TokenType.ARIT_AS, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case '*':
					t = new Token(TokenType.ARIT_MD, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case '/':
					t = new Token(TokenType.ARIT_MD, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case '<':
					t = new Token(TokenType.ASSIGN, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "<<") != null) {
						return t;
					}
					break;
				case '.':
					t = new Token(TokenType.TERM, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case '(':
					t = new Token(TokenType.L_PAR, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case ')':
					t = new Token(TokenType.L_PAR, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
				case 'v':
					t = new Token(TokenType.LOGIC_VAL, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "verdadeiro") != null) {
						return t;
					}
					break;
				case 'f':
					t = new Token(TokenType.LOGIC_VAL, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "falso") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.TYPE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "float") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.END, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "fim") != null) {
						return t;
					}
					break;
				case 'n':
					t = new Token(TokenType.LOGIC_OP, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "nao") != null) {
						return t;
					}
					break;
				case 'e':					
					t = new Token(TokenType.END_PROG, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "end_prog") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.THEN, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "entao") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.WHILE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "enquanto") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.LOGIC_OP, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "e") != null) {
						return t;
					}
					break;
				case 'o':
					t = new Token(TokenType.LOGIC_OP, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "ou") != null) {
						return t;
					}
					break;	
				case 'b':
					t = new Token(TokenType.TYPE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "bool") != null) {
						return t;
					}
					break;	
				case 't':
					t = new Token(TokenType.TYPE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "text") != null) {
						return t;
					}
					break;
				case 'i':
					t = new Token(TokenType.TYPE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "int") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.BEGIN, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "inicio") != null) {
						return t;
					}
					break;
				case 'p':
					t = new Token(TokenType.PROGRAM, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "programa") != null) {
						return t;
					}
					retornaPalavra();
					t = new Token(TokenType.FOR, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "para") != null) {
						return t;
					}
					break;
				case 's':
					t = new Token(TokenType.ELSE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "senao") != null) {
						return t;
					}					
					retornaPalavra();
					t = new Token(TokenType.IF, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "se") != null) {
						return t;
					}					
					break;
				case 'd':
					t = new Token(TokenType.DECLARE, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "declare") != null) {
						return t;
					}
					break;	
				case 'a':
					t = new Token(TokenType.TO, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					if(processaPalavra(t, "ate") != null) {
						return t;
					}
					break;
					
		
				default:
					if (Character.isLetter(c)) {
						return processaID();
					} else if (Character.isDigit(c)) {
						return processaNUM();
					} else {					
						throw new ErroLexicoException();
					}
				}
			} catch (IOException ioe) {
				// FALLBACK: erro de leitura, imterromper processamento
				return new Token(TokenType.EOF, "<Mensagem de Erro>");
			} catch (ErroLexicoException ele) {
				// Trata o erro l�xico (registra)
				ErrorHandler.getInstance().printErrorReport(ele);
			}
		}
	}
  
	
	
	private Token processaPalavra(Token t, String palavra) throws IOException {
		char c;
		while(palavra.contains(lexema.toString())) {
			if(palavra.equals(lexema.toString())) {
				t.setLexema(lexema.toString());
				return t;
			}
			try {
				c = this.fl.getNextChar();
				lexema.append(c);							
			} catch (EOFException e) {
				return new Token(TokenType.EOF, "");
			}
		}
		return null;
	}
	
	public void retornaPalavra() throws IOException {		
		for(int i = 0; i < lexema.length(); i++) {
			fl.resetLastChar();
		}	
		char c = lexema.charAt(0);
		lexema = new StringBuilder();
		lexema.append(c);
	}
	
	private Token processaRELOP() {
		return null;
	}

	private Token processaID() {
		return null;
	}

	private Token processaNUM() {
		return null;
	}
	

}
