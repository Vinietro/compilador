package br.sacredpunch.analisadores;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.sacredpunch.units.ErrorHandler;
import br.sacredpunch.units.Follow;
import br.sacredpunch.units.RuleType;
import br.sacredpunch.units.TabSimbolos;
import br.sacredpunch.units.Token;
import br.sacredpunch.units.TokenType;
import br.sacredpunch.analisadores.ErroLexicoException;
import br.sacredpunch.analisadores.ErroSintaticoException;

public class Sintatico {
	private Lexico lex;
	
	
	private ErroLexicoException ele;
	
	Follow follow;
	
	public Sintatico(String filename) throws FileNotFoundException {
		this.lex = new Lexico();
		this.lex.getFileName(filename);
	}
	
	public void processar() throws IOException, ErroSintaticoException {
		//imprimir o cabeçalho de saída
		//--------------------------------
		//(lin, col) | Token   |Lexema
		//Chama nextToken até que um EOF ocorra
		Token t = lex.nextToken();
		while(t.getTokenType() != TokenType.EOF) {
			loadS(t);
			t.printToken();
			t = lex.nextToken();
		}
		
		
		//Imprimir a tabela de símbolos
		TabSimbolos.getInstance().printTabela();
		
		
		//imprimir relatorio de erros
		//ErrorHandler.getInstance().printErrorReport();
		
		
	}

	public void loadS(Token t) throws IOException, ErroSintaticoException {
		if(t.getTokenType() == TokenType.PROGRAM) {
			t = lex.nextToken();
			if(t.getTokenType() == TokenType.ID) {
				t = lex.nextToken();
				if(t.getTokenType() == TokenType.TERM) {
					loadBLOCO();
					t = lex.nextToken();
					if(t.getTokenType() == TokenType.END_PROG) {
						
						t = lex.nextToken();
						
						if(t.getTokenType() == TokenType.TERM) {
							
						}else {
							ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
						}
						
					}else {
						ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
					}
					
				}else {
					ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
				}
				
			}else {
				ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
			}
			
		}else {
			ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
		}
	}
	
	public void loadBLOCO() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		
		if(t.getTokenType() == TokenType.BEGIN) {
			// Regra 2
			loadCMDS();
			t = lex.nextToken();
			if (t.getTokenType() != TokenType.END) {
				// ERRO
				ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
			}else if((t.getTokenType() != TokenType.FOR) ||
					 (t.getTokenType() != TokenType.WHILE) || 
					 (t.getTokenType() != TokenType.ID) ||
					 (t.getTokenType() != TokenType.DECLARE )){
				// Regra 3
				storageToken(RuleType.BLOCO,t.getTokenType());
				loadCMD();
								
			}
		}else {
			// ERRO
			ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
			
		}
		
	}
	
	private void storageToken(RuleType bloco, TokenType token) {
		
		
	}

	public void loadCMDS() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		
		if(t.getTokenType() == TokenType.DECLARE) {
			loadDECL();
			loadCMDS();
		}else if(t.getTokenType() == TokenType.IF) {
			loadCOND();
			loadCMDS();
		}else if(t.getTokenType() == TokenType.FOR) {
			loadREPF();
			loadCMDS();
		}else if(t.getTokenType() == TokenType.WHILE) {
			loadREPW();
			loadCMDS();
		}else if(t.getTokenType() == TokenType.ID) {
			loadATRIB();
			loadCMDS();
		}else if(follow.isFollowOf(RuleType.CMDS, t.getTokenType())) {
			storageToken(RuleType.CMDS, t.getTokenType());
		}else {
			throw new ErroSintaticoException(t.getTokenType());
		}

	}
	
	public void loadCMD() {
		
	}
	
	public void loadDECL() {
		
	}
	
	public void loadCOND() {
		
	}
	
	public void loadCNDB() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if(t.getTokenType() == TokenType.ELSE) {
			// Regra 16
			loadBLOCO();
		}else if(follow.isFollowOf(RuleType.BLOCO, t.getTokenType())) {
			storageToken(RuleType.CNDB, t.getTokenType());
		}else {
			throw new ErroSintaticoException(t.getTokenType());
		}
		
		
	}
	
	public void loadATRIB() throws IOException {
		Token t = lex.nextToken();
		if(t.getTokenType() == TokenType.ID) {
			t = lex.nextToken();
			if(t.getTokenType() == TokenType.ASSIGN) {
				loadEXP();
				t = lex.nextToken();
				if(t.getTokenType() == TokenType.TERM) {
					t = lex.nextToken();
					storageToken(RuleType.ATRIB ,t.getTokenType());
				}
			}
		}
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
