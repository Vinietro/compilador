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
		}
	
	}
	
	
	public Boolean isFollowOf(RuleType rule, TokenType token) {
		
		this.rule = rule;
		
		
	  return null;
	}

}
