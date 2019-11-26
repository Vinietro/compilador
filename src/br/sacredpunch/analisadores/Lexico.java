package br.sacredpunch.analisadores;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.FileLoader;
import br.sacredpunch.units.TabSimbolos;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class Lexico {

	private FileLoader fl;
	// Define variavel "lexema"
	private StringBuilder lexema = new StringBuilder();

	private TabSimbolos tab = TabSimbolos.getInstance();
	
	public void getFileName(String filename) throws FileNotFoundException {
		this.fl = new FileLoader(filename);
	}
	
	public FileLoader setFile() {
		return this.fl;
	}

	public Token nextToken() throws IOException {
		int lin;
		int col;
		while(true) {
			lexema = new StringBuilder();
			try {
				Token t = null;
				// Verifica fim de arquivo: caso em que retornamos um "Token" EOF
				char c;
				try {
					c = this.fl.getNextChar();
				} catch (EOFException e) {
					return new Token(TokenType.EOF, "", this.fl.getLine(), this.fl.getColumn());
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
					lin = this.fl.getLine();
					t = new Token(TokenType.ARIT_AS, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '-':
					// Retorna token do tipo ARIT_AS
					t = new Token(TokenType.ARIT_AS, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '*':
					t = new Token(TokenType.ARIT_MD, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '/':
					t = new Token(TokenType.ARIT_MD, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '<':
					while(c == '<') {
						lexema.append(c);
						c = this.fl.getNextChar();
					}
					t = new Token(TokenType.ASSIGN, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '.':
					t = new Token(TokenType.TERM, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '(':
					t = new Token(TokenType.L_PAR, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case ')':
					t = new Token(TokenType.L_PAR, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				case '&':
					while(!Character.isWhitespace(c)) {
						
						c = this.fl.getNextChar();
						if(c == 'l' || c == 'g' || c == 'e' || c == 'd') {
							lexema.append(c);
							c = this.fl.getNextChar();
							if(c == 't' || c == 'e' || c == 'q' || c == 'f') {
								lexema.append(c);
								c = this.fl.getNextChar();
								if(c == ';') {
									lexema.append(c);
								} else {
									if(c != ';') {
										throw new ErroLexicoException(c , lexema.toString());
									}
								}
							}else {
									while(Character.isLetter(c) || c == ';') {
										lexema.append(c);
										c = this.fl.getNextChar();
									}
								throw new ErroLexicoException(c , lexema.toString());
							}
						} 
						
					}
					
					t = new Token(TokenType.RELOP, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					
					return t;

				case '\'':
					c = this.fl.getNextChar();
					while(Character.isLetter(c) || Character.isDigit(c) || c == '_' || c == '-' || c == ':') {
						lexema.append(c);
						c = this.fl.getNextChar();
					}
					if(c == '\'') {
						lexema.append(c);
					}
					t = new Token(TokenType.LITERAL, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					return t;
				default:
					if (Character.isLetter(c) || c == '$') {
						//lexema.append(c);
						return  processaID();
					} else if (Character.isDigit(c)) {
						return processaNUM(c, t);
					} else {					
						throw new ErroLexicoException(c , lexema.toString());
					}
				}
			} catch (IOException ioe) {
				// FALLBACK: erro de leitura, imterromper processamento
				return new Token(TokenType.EOF, "<Mensagem de Erro>", this.fl.getLine(), this.fl.getColumn());
			} catch (ErroLexicoException ele) {
				// Trata o erro l�xico (registra)
				ErrorHandler.getInstance().printErrorReport(ele);
				ele.printStackTrace();
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
	

	private Token processaID() throws EOFException, IOException {
		
		char c = this.fl.getNextChar();
		
		while(Character.isLetter(c) || Character.isDigit(c) || c == '$') {
			lexema.append(c);
			c = this.fl.getNextChar();
			
		}
		//t = new Token(TokenType.ID, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
		
		Token t = tab.comparaID(lexema.toString(),this.fl.getLine(), this.fl.getColumn());
		
		return t;
	}

	private Token processaNUM(char c, Token t) throws EOFException, IOException, ErroLexicoException {
		
		
		while(Character.isDigit(c) || c == 'E' || c == '+') {
			c = this.fl.getNextChar();
			lexema.append(c);
			if(c == '.') {
				while(Character.isDigit(c) || c == '.' || c == 'E' || c == '+') {
					c = this.fl.getNextChar();
					lexema.append(c);
					t = new Token(TokenType.NUM_FLOAT, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
					if(c == '.' || (Character.isLetter(c) && c != 'E' )) {
						while(Character.isLetter(c) || c == '.' || Character.isDigit(c)) {
							c = this.fl.getNextChar();
							lexema.append(c);
						}
						throw new ErroLexicoException(c, lexema.toString());
					}
				}
			}else {
				t = new Token(TokenType.NUM_INT, lexema.toString(), this.fl.getLine(), this.fl.getColumn());
			}
		}
		
		return t;
	}
	
	

}
