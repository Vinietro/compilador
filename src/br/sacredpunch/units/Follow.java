package br.sacredpunch.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import br.sacredpunch.units.TokenType;

public class Follow {
	
	private static Follow instance = new Follow();
	
	public ArrayList<String> token;
	
	private TokenType tokenType;
	
	private String[] strCarga = new String[this.token.size()];
	
	public Follow() {
		
	}
	
	
	private void putToken(RuleType rule) {
		if(rule == RuleType.BLOCO) {
			this.token.add(TokenType.DECLARE.toString());
			this.token.add(TokenType.IF.toString());
			this.token.add(TokenType.FOR.toString());
			this.token.add(TokenType.WHILE.toString());
			this.token.add(TokenType.ID.toString());
			this.token.add(TokenType.END.toString());
			this.token.add(TokenType.END_PROG.toString());
			this.token.add(TokenType.ELSE.toString());
			
			}else if(rule == RuleType.CMDS) {
				this.token.add(TokenType.END.toString());
				
			}else if(rule == RuleType.CMD) {
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
			}else if(rule == RuleType.DECL){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
			}else if(rule == RuleType.COND){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
			}else if(rule == RuleType.CNDB){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
				
			}else if(rule == RuleType.ATRIB){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
			}else if(rule == RuleType.EXP){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.FID){
				//term		
				
				this.token.add(TokenType.TERM.toString());
				
			}else if(rule == RuleType.FOPNUM){
				//term
				this.token.add(TokenType.TERM.toString());			
				
				
			}else if(rule == RuleType.FEXPNUM_1){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.FNUM){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.FLPAR){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.FEXPNUM){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.FRPAR){
				//term
				this.token.add(TokenType.TERM.toString());			
				
			}else if(rule == RuleType.EXPLO){
				//term rpar
				this.token.add(TokenType.TERM.toString());			
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.FID_1){
				//term rpar
				this.token.add(TokenType.TERM.toString());			
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.FVALLOG){
				//term rpar
				this.token.add(TokenType.TERM.toString());			
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.EXPNUM){
				//relop to begin declare if id for while term rpar
				this.token.add(TokenType.RELOP.toString());			
				this.token.add(TokenType.TO.toString());
				this.token.add(TokenType.BEGIN.toString());
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.TERM.toString());
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.XEXPNUM){
				//relop to begin declare if id for while term rpar
				this.token.add(TokenType.RELOP.toString());			
				this.token.add(TokenType.TO.toString());
				this.token.add(TokenType.BEGIN.toString());
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.TERM.toString());
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.OPNUM){
				//lpar id num_int num_float
				this.token.add(TokenType.L_PAR.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.NUM_INT.toString());
				this.token.add(TokenType.NUM_FLOAT.toString());
				
			}else if(rule == RuleType.VAL){
				//relop to begin declare if id for while term rpar
				this.token.add(TokenType.ARIT_AS.toString());
				this.token.add(TokenType.ARIT_MD.toString());
				this.token.add(TokenType.RELOP.toString());
				this.token.add(TokenType.TO.toString());
				this.token.add(TokenType.BEGIN.toString());
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.TERM.toString());
				this.token.add(TokenType.R_PAR.toString());
				
			}else if(rule == RuleType.REP){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());			
				
			}else if(rule == RuleType.REPF){
				//declare if for while id end end_prog else 
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());
				
			}else if(rule == RuleType.REPW){
				//declare if for while id end end_prog else
				this.token.add(TokenType.DECLARE.toString());
				this.token.add(TokenType.IF.toString());
				this.token.add(TokenType.FOR.toString());
				this.token.add(TokenType.WHILE.toString());
				this.token.add(TokenType.ID.toString());
				this.token.add(TokenType.END.toString());
				this.token.add(TokenType.END_PROG.toString());
				this.token.add(TokenType.ELSE.toString());			
			}
	
	}
	
	
	public static Follow getInstance() {
		return instance;
	}
	
	
	private void ordenaTokens() {
		for(int i = 0; i < this.token.size(); i++) {
			for(int j = 1; j < this.token.size(); j++) {
				
				if(this.token.get(i).length() < this.token.get(j).length()) {
					this.strCarga[i] = this.token.get(j);
					this.strCarga[j] = this.token.get(i);
				}
			}
		}
	}
	
	
	public Boolean isFollowOf(RuleType rule) {	
		
		putToken(rule);
		
		ordenaTokens();
		
		buscaTokens();
		
		if(buscaTokens()) {
			return true;
		}else {
			return false;
		}
		
	}


	private boolean buscaTokens() {
		
		/*int meio;
	int inicio = 0;
	int fim = dados.length-1;
	while (inicio <= fim) {
	         meio = (inicio + fim)/2;
	         if (x == dados[meio])
	                  return true;
	         if (x < dados[meio])
	                  fim = meio - 1;
	         else
	                  inicio = meio + 1;
	}*/
		int x = 0;
		int meio;
		int inicio = 0;
		int fim = this.strCarga.length;	
		while(inicio <= fim) {
			meio = (inicio + fim)/2;
			if(this.strCarga[x] == this.strCarga[meio]) {
				return true;
			}else if(this.strCarga[x].length() < this.strCarga[meio].length()) {
				fim = meio - 1;
			}else if(this.strCarga[x].length() > this.strCarga[meio].length()){
				inicio = meio + 1;
			}
				
		}
		return false;
	}

}
