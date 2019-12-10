////////////////////////////////////////////
// Vinícius De Vietro 191515141		 	  //	
// Geovanni Peixoto Silva 171151048  	  //
// Lucas Alves de Medeiros 162150020 	  //
// Maicon Parra da Silva 1821519513  	  //
// Lucas Gomes de Melo Bonafé 1921519487  //
////////////////////////////////////////////
package br.sacredpunch.compilador;


import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.analisadores.Sintatico;
import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.analisadores.ErroLexicoException;
import br.sacredpunch.analisadores.ErroSintaticoException;
import br.sacredpunch.analisadores.Lexico;

public class Compilador {

	public static void main(String[] args) throws ErroLexicoException, IOException {
		if (args.length != 1) {
			// Imprimir o "usage" do programa
			System.out.println("Passar arquivo correto. ");
		}
		//ola
		else {			
			//Cria instï¿½ncia do Sintatico e o executa
			Sintatico s = new Sintatico(args[0]);
			try {			
				s.processar();
			}catch(FileNotFoundException fnf) {
				//Imprimir mensagem apropriada
				System.out.println("Arquivo não encontrado.");
			}catch(ErroSintaticoException sin) {
				
				ErrorHandler.getInstance().printErrorSintatic(sin);
				
			}
			
			
		}
	

	}
}