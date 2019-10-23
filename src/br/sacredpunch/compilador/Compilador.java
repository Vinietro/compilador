package br.sacredpunch.compilador;

import java.io.FileNotFoundException;

import br.sacredpunch.analisadores.Sintatico;
import br.sacredpunch.analisadores.Lexico;

public class Compilador {

	public static void main(String[] args) {
		
		//Receber nome do arquivo a ser compliado
		Lexico lex = new Lexico(args);
		//chamar função de atribução de Tokens
		lex.nextToken();

		if (args.length != 1) {
			//Imprimir o "usage" do programa
			System.out.println("Passar arquivo correto. ");
		}
		else {
			//Cria inst�ncia do Sintatico e o executa
			try {
				Sintatico s = new Sintatico(args[0]);
				s.processar();
			}catch(FileNotFoundException fnf) {
				//Imprimir mensagem apropriada
				
			}
			
			
		}
	

	}
}