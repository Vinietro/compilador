package br.sacredpunch.analisadores;

import java.io.FileNotFoundException;

import br.sacredpunch.units.FileLoader;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;

public class Lexico {

	private FileLoader fl;
	
	public Lexico(String filename) throws FileNotFoundException{
		this.fl = new FileLoader(filename);
	}
	
	public Token nextToken() {
		//TODO: implementar este método
		return new Token(TokenType.EOF, "");
	}
}
