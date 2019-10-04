package br.sacredpunch.units;

public class ErrorHandler {
	private  static ErrorHandler instance = new ErrorHandler();	
	
	public static ErrorHandler getInstance() {
		return instance;
	}
	public void printErrorReport(String erro) {
		System.out.println(erro);		
	}
}
