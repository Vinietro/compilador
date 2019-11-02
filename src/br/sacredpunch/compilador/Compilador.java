package br.sacredpunch.compilador;


import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.analisadores.Sintatico;
import br.sacredpunch.analisadores.ErroLexicoException;
import br.sacredpunch.analisadores.Lexico;

public class Compilador {

	public static void main(String[] args) throws ErroLexicoException, IOException {

		Sintatico s = new Sintatico();
		
		//Receber nome do arquivo a ser compliado
		Lexico lex = new Lexico();
		lex.getFileName(args[0]);
		//chamar função de atribução de Tokens
		
		lex.nextToken();
		
		if (args.length != 1) {
			//Imprimir o "usage" do programa
			System.out.println("Passar arquivo correto. ");
		}

		//ola
		else {
			//Cria inst�ncia do Sintatico e o executa
			try {
			
				s.processar();
			}catch(FileNotFoundException fnf) {
				//Imprimir mensagem apropriada
				System.out.println("Arquivo n�o encontrado.");
			}
			
			
		}
	

	}
}