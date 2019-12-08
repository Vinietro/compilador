package br.sacredpunch.units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import br.sacredpunch.units.TokenType;

public class Follow {
	
	private RuleType rule;
	
	private static Follow instance = new Follow();
	
	private ArrayList<TokenType> token;
	
	private Map<RuleType, ArrayList<TokenType>> tabela;
	
	private Follow() {
		tabela = new HashMap<RuleType, ArrayList<TokenType>>();
	
		//declare if for while id end end_prog else
		if(this.rule == RuleType.BLOCO) {
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		
		tabela.put(this.rule, token);
		
		}else if(this.rule == RuleType.CMDS) {
			token.add(TokenType.END);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.CMD) {
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.DECL){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.COND){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.CNDB){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.ATRIB){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.EXP){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FID){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FOPNUM){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FEXPNUM_1){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FNUM){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FLPAR){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FEXPNUM){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FRPAR){
			//term
			token.add(TokenType.TERM);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.EXPLO){
			//term rpar
			token.add(TokenType.TERM);			
			token.add(TokenType.R_PAR);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FID_1){
			//term rpar
			token.add(TokenType.TERM);			
			token.add(TokenType.R_PAR);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.FVALLOG){
			//term rpar
			token.add(TokenType.TERM);			
			token.add(TokenType.R_PAR);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.EXPNUM){
			//relop to begin declare if id for while term rpar
			token.add(TokenType.RELOP);			
			token.add(TokenType.TO);
			token.add(TokenType.BEGIN);
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.ID);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.TERM);
			token.add(TokenType.R_PAR);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.XEXPNUM){
			//relop to begin declare if id for while term rpar
			token.add(TokenType.RELOP);			
			token.add(TokenType.TO);
			token.add(TokenType.BEGIN);
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.ID);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.TERM);
			token.add(TokenType.R_PAR);
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.OPNUM){
			//lpar id num_int num_float
			token.add(TokenType.L_PAR);
			token.add(TokenType.ID);
			token.add(TokenType.NUM_INT);
			token.add(TokenType.NUM_FLOAT);
			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.VAL){
			//opAddSub opMultDiv?? relop to begin declare if id for while term rpar
			token.add(TokenType.RELOP);
			token.add(TokenType.TO);
			token.add(TokenType.BEGIN);
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.ID);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.TERM);
			token.add(TokenType.R_PAR);
			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.REP){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.REPF){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);			
			
			tabela.put(this.rule, token);
			
		}else if(this.rule == RuleType.REPW){
			//declare if for while id end end_prog else
			token.add(TokenType.DECLARE);
			token.add(TokenType.IF);
			token.add(TokenType.FOR);
			token.add(TokenType.WHILE);
			token.add(TokenType.ID);
			token.add(TokenType.END);
			token.add(TokenType.END_PROG);
			token.add(TokenType.ELSE);			
			
			tabela.put(this.rule, token);
			
		}
	}
	
	
	public Boolean isFollowOf(RuleType rule, TokenType token) {
		
		this.rule = rule;
		
		
	  return null;
	}

}
