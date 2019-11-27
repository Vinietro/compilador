package br.sacredpunch.analisadores;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.TabSimbolos;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;
import br.sacredpunch.analisadores.ErroLexicoException;

public class Sintatico {
	private Lexico lex;
	
	private ErroLexicoException ele;
	
	public Sintatico(String filename) throws FileNotFoundException {
		this.lex = new Lexico();
		this.lex.getFileName(filename);
	}
	
	public void processar() throws IOException {
		//imprimir o cabeçalho de saída
		//--------------------------------
		//(lin, col) | Token   |Lexema
		System.out.println("LINHA COLUNA | Token | Lexema");
		//Chama nextToken até que um EOF ocorra
		Token t = lex.nextToken();
		while (t.getTokenType() != TokenType.EOF) {
			t.printToken();
			t = lex.nextToken();
		}
		
		//Imprimir a tabela de símbolos
		TabSimbolos.getInstance().printTabela();
		
		
		//imprimir relatorio de erros
		//ErrorHandler.getInstance().printErrorReport();
		
		
	}

	public void loadS() {
		
	}
	
	public void loadBLOCO() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		
		if(t.getTokenType() == TokenType.BEGIN) {
			loadCMDS();
			t = lex.nextToken();
			if (t.getTokenType() != TokenType.END) {
				throw new ErroSintaticoException(t.getTokenType());
			}else if((t.getTokenType() != TokenType.FOR) ||
					 (t.getTokenType() != TokenType.WHILE) || 
					 (t.getTokenType() != TokenType.ID) ||
					 (t.getTokenType() != TokenType.DECLARE )){
				
				storageToken();
				loadCMD();
								
			}
		}else {
			throw new ErroSintaticoException(t.getTokenType());
		}
		
	}
	
	private void storageToken() {
		// TODO Auto-generated method stub
		
	}

	public void loadCMDS() {
		
	}
	
	public void loadCMD() {
		
	}
	
	public void loadDECL() {
		
	}
	
	public void loadCOND() {
		
	}
	
	public void loadCNDB() {
		
	}
	
	public void loadATRIB() {
		
	}
	
	public void loadEXP() {
		
	}
	
	public void loadFID() {
		
	}
	
	public void loadFOPNUM() {
		
	}
	
	public void loadFEXPNUM_1() {
		
	}
	
	public void loadFNUM() {
		
	}
	
	public void loadFLPAR() {
		
	}
	
	public void loadFEXPNUM() {
		
	}
	
	public void loadFRPAR() {
		
	}
	
	public void loadEXPLO() {
		
	}
	
	public void loadFID_1() {
		
	}
	
	public void loadFVALLOG() {
		
	}
	
	public void loadEXPNUM() {
		
	}
	
	public void loadXEXPNUM() {
		
	}
	
	public void loadOPNUM() {
		
	}
	
	public void loadVAL() {
		
	}
	
	public void loadREP() {
		
	}
	
	public void loadREPF() {
		
	}
	
	public void loadREPW() {
		
	}
	
}
