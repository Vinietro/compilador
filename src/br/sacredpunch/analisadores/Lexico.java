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

	public Lexico(String filename) throws FileNotFoundException {
		this.fl = new FileLoader(filename);
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
					t.setLin(this.f1.getLine());
					t.setCol(this.f1.getColumn());
					return t;
				case '/':
					t = new Token(TokenType.ARIT_MD, lexema.toString());
					t.setLin(this.f1.getLine());
					t.setCol(this.f1.getColumn());
					return t;
				case '&':
					t = new Token(TokenType.LOGITC_OP, lexema.toString());
					t.setLin(this.f1.getLine());
					t.setCol(this.f1.getColumn());
					return processaRELOP();
				case '|':
					t = new Token(TokenType.LOGITC_OP, lexema.toString());
					t.setLin(this.f1.getLine);
					t.setCol(this.f1.getColumn);
					return processaRELOP();
				// ...
		
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
