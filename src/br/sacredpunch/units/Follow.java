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
		token = new ArrayList<TokenType>();

		// declare if for while id end end_prog else
		this.rule = RuleType.BLOCO;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.CMDS;
		token.add(TokenType.END);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.CMD;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.DECL;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.COND;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.CNDB;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.ATRIB;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.EXP;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FID;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FOPNUM;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FEXPNUM_1;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FNUM;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FLPAR;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FEXPNUM;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FRPAR;
		token.add(TokenType.TERM);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.EXPLO;
		token.add(TokenType.TERM);
		token.add(TokenType.R_PAR);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FID_1;
		token.add(TokenType.TERM);
		token.add(TokenType.R_PAR);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.FVALLOG;
		token.add(TokenType.TERM);
		token.add(TokenType.R_PAR);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.EXPNUM;
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

		this.token.clear();
		this.rule = RuleType.XEXPNUM;
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

		this.token.clear();
		this.rule = RuleType.OPNUM;
		token.add(TokenType.L_PAR);
		token.add(TokenType.ID);
		token.add(TokenType.NUM_INT);
		token.add(TokenType.NUM_FLOAT);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.VAL;
		token.add(TokenType.ARIT_AS);
		token.add(TokenType.ARIT_MD);
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

		this.token.clear();
		this.rule = RuleType.REP;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.REPF;
		token.add(TokenType.DECLARE);
		token.add(TokenType.IF);
		token.add(TokenType.FOR);
		token.add(TokenType.WHILE);
		token.add(TokenType.ID);
		token.add(TokenType.END);
		token.add(TokenType.END_PROG);
		token.add(TokenType.ELSE);
		tabela.put(this.rule, token);

		this.token.clear();
		this.rule = RuleType.REPW;
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

	public Boolean isFollowOf(RuleType rule, TokenType token) {
		return tabela.get(rule).contains(token);
	}

	public static Follow getInstance() {

		return instance;
	}
}