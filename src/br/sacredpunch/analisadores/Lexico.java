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
					while(c == '<') {
						lexema.append(c);
						c = this.fl.getNextChar();
					}
					t = new Token(TokenType.ASSIGN, lexema.toString());
					t.setLin(this.fl.getLine());
					t.setCol(this.fl.getColumn());
					return t;
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
				case '&':
					processaRELOP(c, t);
				default:
					if (Character.isLetter(c)) {
						return processaID(c, t);
					} else if (Character.isDigit(c)) {
						return processaNUM(c, t);
					} else {					
						throw new ErroLexicoException(c);
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
  
	
	
	/*private Token processaPalavra(Token t, String palavra) throws IOException {
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
	}*/
	
	/*public void retornaPalavra() throws IOException {		
		for(int i = 0; i < lexema.length(); i++) {
			fl.resetLastChar();
		}	
		char c = lexema.charAt(0);
		lexema = new StringBuilder();
		lexema.append(c);
	}*/
	
	private Token processaRELOP(char c, Token t) throws EOFException, IOException {
		lexema.append(c);
		c = this.fl.getNextChar();
		if(c == 'l') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 't') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}else if(c == 'g') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 't') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}else if(c == 'g') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 'e') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}else if(c == 'l') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 'e') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}else if(c == 'e') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 'q') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}else if(c == 'd') {
			lexema.append(c);
			c= this.fl.getNextChar();
			if(c == 'f') {
				lexema.append(c);
				c = this.fl.getNextChar();
				if(c == ';') {
					lexema.append(c);
				}
			}
		}
		
		t = new Token(TokenType.RELOP, lexema.toString());
		t.setLin(this.fl.getLine());
		t.setCol(this.fl.getColumn());
		
		return t;
	}

	private Token processaID(char c, Token t) throws EOFException, IOException {
		while(Character.isLetter(c) || c == '_') {
			lexema.append(c);
			c = this.fl.getNextChar();
		}
		t = new Token(TokenType.ID, lexema.toString());
		t.setLin(this.fl.getLine());
		t.setCol(this.fl.getColumn());
		return t;
	}

	private Token processaNUM(char c, Token t) throws EOFException, IOException {
		while(Character.isDigit(c)) {
			lexema.append(c);
			c = this.fl.getNextChar();
		}
		t = new Token(TokenType.ID, lexema.toString());
		t.setLin(this.fl.getLine());
		t.setCol(this.fl.getColumn());
		return t;
	}
	

}
