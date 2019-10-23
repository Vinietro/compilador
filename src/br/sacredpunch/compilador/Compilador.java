package br.sacredpunch.compilador;

import java.util.*;

import java.io.FileNotFoundException;

import br.sacredpunch.analisadores.Sintatico;
import br.sacredpunch.analisadores.Lexico;

public class Compilador {

	public static void main(String[] args) throws FileNotFoundException {


		if(args.length > 1 && args.length < 1){
			System.out.println("Quantidade de arquivos excede o aceito");
		}else if(args.length < 1){
			System.out.println("É necessario informar o arquivo a ser analisado");
		}
		
		//Receber nome do arquivo a ser compliado
		Lexico lex = new Lexico();
		//chamar função de atribução de Tokens
		
		lex.getFileName(args[0]);
		
		if (args.length != 1) {
			//Imprimir o "usage" do programa
			System.out.println("Passar arquivo correto. ");
		}

		//ola
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