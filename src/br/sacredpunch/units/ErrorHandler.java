package br.sacredpunch.units;

import br.sacredpunch.analisadores.ErroLexicoException;

public class ErrorHandler {
	private  static ErrorHandler instance = new ErrorHandler();	
	
	public static ErrorHandler getInstance() {
		return instance;
	}
	public void printErrorReport(ErroLexicoException ele) {
		System.out.println(ele);		
	}
}
