package br.sacredpunch.compilador;

import java.io.FileNotFoundException;

import br.sacredpunch.analisadores.Sintatico;

public class Compilador {

	public static void main(String[] args) {
		
		//Receber nome do arquivo a ser compliado
		if (args.length != 1) {
			//Imprimir o "usage" do programa
			System.out.println("Passar arquivo correto. ");
		}
		else {
			//Cria instância do Sintatico e o executa
			try {
				Sintatico s = new Sintatico(args[0]);
				s.processar();
			}catch(FileNotFoundException fnf) {
				//Imprimir mensagem apropriada
				
			}
			
			
		}
	

	}
}