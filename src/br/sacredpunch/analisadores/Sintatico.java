////////////////////////////////////////////
// Vinícius De Vietro 191515141		 	  //	
// Geovanni Peixoto Silva 171151048  	  //
// Lucas Alves de Medeiros 162150020 	  //
// Maicon Parra da Silva 1821519513  	  //
// Lucas Gomes de Melo Bonafé 1921519487  //
////////////////////////////////////////////
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
	
	private Token t;
	private RuleType bloco;

	Follow follow = Follow.getInstance();

	public Sintatico(String filename) throws FileNotFoundException {
		this.lex = new Lexico();
		this.lex.getFileName(filename);
		
	}

	public void processar() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		while (t.getTokenType() != TokenType.EOF) {
			loadS(t);
			t = lex.nextToken();
		}	
	}

	private void storageToken(RuleType bloco, Token token) {
		this.t = token;
		this.bloco = bloco;
	}

	private Token getStorageToken() {
		return this.t;
	}

	public void loadS(Token t) throws IOException, ErroSintaticoException {
		if (t.getTokenType() == TokenType.PROGRAM) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.ID) {
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.TERM) {
					loadBLOCO();
					t = lex.nextToken();
					if (t.getTokenType() == TokenType.END_PROG) {
						t = lex.nextToken();
						if (t.getTokenType() == TokenType.TERM) {
							System.out.printf("Programa compilado com sucesso!");
						} else {
							ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
						}

					} else {
						ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
					}

				} else {
					ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
				}

			} else {
				ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
			}

		} else {
			ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
		}
	}

	public void loadBLOCO() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();

		if (t.getTokenType() == TokenType.BEGIN) {
			// Regra 2
			lex.nextToken();
			storageToken(RuleType.BLOCO, t);
			loadCMDS();
			t = lex.nextToken();
			if (t.getTokenType() != TokenType.END) {
				// ERRO
				ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());
			}
		} else if ((t.getTokenType() == TokenType.ID) || (t.getTokenType() == TokenType.IF)
				|| (t.getTokenType() == TokenType.FOR) || (t.getTokenType() == TokenType.WHILE)
				|| (t.getTokenType() == TokenType.DECLARE)) {
			// Regra 3
			storageToken(RuleType.BLOCO, t);
			loadCMD();
		} else {
			// ERRO
			ErrorHandler.getInstance().printErrorSintDefault(t.getTokenType(), t.getLexema());

		}

	}

	public void loadCMDS() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.DECLARE) {
			storageToken(RuleType.CMDS, t);
			loadDECL();
			loadCMDS();
		} else if (t.getTokenType() == TokenType.IF) {
			storageToken(RuleType.CMDS, t);
			loadCOND();
			loadCMDS();
		} else if (t.getTokenType() == TokenType.FOR) {
			storageToken(RuleType.CMDS, t);
			loadREPF();
			loadCMDS();
		} else if (t.getTokenType() == TokenType.WHILE) {
			storageToken(RuleType.CMDS, t);
			loadREPW();
			loadCMDS();
		} else if (t.getTokenType() == TokenType.ID) {
			storageToken(RuleType.CMDS, t);
			loadATRIB();
			loadCMDS();
		} else if (follow.isFollowOf(RuleType.CMDS, t.getTokenType())) {
			storageToken(RuleType.CMDS, t);
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadCMD() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.DECLARE) {
			storageToken(RuleType.CMD, t);
			loadDECL();
		} else if (t.getTokenType() == TokenType.IF) {
			storageToken(RuleType.CMD, t);
			loadCOND();
		} else if ((t.getTokenType() == TokenType.FOR) || (t.getTokenType() == TokenType.WHILE)) {
			storageToken(RuleType.CMD, t);
			loadREP();
		} else if (t.getTokenType() == TokenType.ID) {
			storageToken(RuleType.CMD, t);
			loadATRIB();
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadDECL() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.DECLARE) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.ID) {
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.TYPE) {
					t = lex.nextToken();
					if (t.getTokenType() == TokenType.TERM) {
						storageToken(RuleType.DECL, t);
					} else {
						throw new ErroSintaticoException(t);
					}
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadCOND() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.IF) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.L_PAR) {
				storageToken(RuleType.COND, t);
				loadEXPLO();
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.R_PAR) {
					t = lex.nextToken();
					if (t.getTokenType() == TokenType.THEN) {
						storageToken(RuleType.COND, t);
						loadBLOCO();
						loadCNDB();
					} else {
						throw new ErroSintaticoException(t);
					}
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadCNDB() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.ELSE) {
			loadBLOCO();
		} else if (follow.isFollowOf(RuleType.CNDB, t.getTokenType())) {
			storageToken(RuleType.CNDB, t);
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadATRIB() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.ID) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.ASSIGN) {
				storageToken(RuleType.ATRIB, t);
				loadEXP();
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.TERM) {
					storageToken(RuleType.ATRIB, t);
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadEXP() throws ErroSintaticoException, IOException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.LOGIC_VAL) {
			storageToken(RuleType.EXP, t);
			loadFVALLOG();
		} else if (t.getTokenType() == TokenType.ID) {
			storageToken(RuleType.EXP, t);
			loadFID();
		} else if ((t.getTokenType() == TokenType.NUM_INT) || (t.getTokenType() == TokenType.NUM_FLOAT)) {
			storageToken(RuleType.EXP, t);
			loadFNUM();
		} else if (t.getTokenType() == TokenType.L_PAR) {
			storageToken(RuleType.EXP, t);
			loadFLPAR();
		} else if (t.getTokenType() == TokenType.LITERAL) {
			storageToken(RuleType.EXP, t);
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadFID() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.LOGIC_OP) {
			storageToken(RuleType.FID, t);
			loadFVALLOG();
		} else if ((t.getTokenType() == TokenType.ARIT_AS) || (t.getTokenType() == TokenType.ARIT_MD)) {
			storageToken(RuleType.FID, t);
			loadOPNUM();
			loadFOPNUM();
		}else if (follow.isFollowOf(RuleType.FID, t.getTokenType())) {
			storageToken(RuleType.FID, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFOPNUM() throws ErroSintaticoException, IOException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.NUM_INT) || (t.getTokenType() == TokenType.NUM_FLOAT)
				|| (t.getTokenType() == TokenType.ID) || (t.getTokenType() == TokenType.L_PAR)) {
			storageToken(RuleType.FOPNUM, t);
			loadEXPNUM();
			loadFEXPNUM_1();
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadFEXPNUM_1() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.RELOP) {
			storageToken(RuleType.FEXPNUM_1, t);
			loadEXPNUM();
		} else if (t.getTokenType() == TokenType.TERM) {
			storageToken(RuleType.FEXPNUM_1, t);
		}else if (follow.isFollowOf(RuleType.FEXPNUM_1, t.getTokenType())) {
			storageToken(RuleType.FEXPNUM_1, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFNUM() throws ErroSintaticoException, IOException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.ARIT_AS) || (t.getTokenType() == TokenType.ARIT_MD)) {
			storageToken(RuleType.FNUM, t);
			loadOPNUM();
			loadFOPNUM();
		} else if (t.getTokenType() == TokenType.TERM) {
			storageToken(RuleType.FNUM, t);
		}else if (follow.isFollowOf(RuleType.FNUM, t.getTokenType())) {
			storageToken(RuleType.FNUM, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFLPAR() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.NUM_INT) || (t.getTokenType() == TokenType.NUM_FLOAT)
				|| (t.getTokenType() == TokenType.ID) || (t.getTokenType() == TokenType.L_PAR)) {
			storageToken(RuleType.FLPAR, t);
			loadEXPNUM();
			loadFEXPNUM();
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFEXPNUM() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.R_PAR) {
			storageToken(RuleType.FEXPNUM, t);
			loadFRPAR();
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFRPAR() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.RELOP) {
			storageToken(RuleType.FRPAR, t);
			loadEXPNUM();
		} else if (t.getTokenType() == TokenType.TERM) {
			storageToken(RuleType.FRPAR, t);
		}else if (follow.isFollowOf(RuleType.FRPAR, t.getTokenType())) {
			storageToken(RuleType.FRPAR, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadEXPLO() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.LOGIC_VAL) {
			storageToken(RuleType.EXPLO, t);
			loadFVALLOG();
		} else if (t.getTokenType() == TokenType.ID) {
			storageToken(RuleType.EXPLO, t);
			loadFID_1();
		} else if ((t.getTokenType() == TokenType.NUM_INT) || (t.getTokenType() == TokenType.NUM_FLOAT)) {
			storageToken(RuleType.EXPLO, t);
			loadOPNUM();
			loadEXPNUM();
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.RELOP) {
				storageToken(RuleType.EXPLO, t);
				loadEXPNUM();
			} else {
				throw new ErroSintaticoException(t);
			}
		} else if (t.getTokenType() == TokenType.L_PAR) {
			storageToken(RuleType.EXPLO, t);
			loadEXPNUM();
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.R_PAR) {
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.RELOP) {
					storageToken(RuleType.EXPLO, t);
					loadEXPNUM();
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}

	}

	public void loadFID_1() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.LOGIC_OP) {
			storageToken(RuleType.FID_1, t);
			loadFVALLOG();
		} else if (t.getTokenType() == TokenType.RELOP) {
			storageToken(RuleType.FID_1, t);
			loadEXPNUM();
		} else if ((t.getTokenType() == TokenType.ARIT_AS) || (t.getTokenType() == TokenType.ARIT_MD)) {
			storageToken(RuleType.FID_1, t);
			loadOPNUM();
			loadEXPNUM();
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.RELOP) {
				storageToken(RuleType.FID_1, t);
				loadEXPNUM();
			} else {
				throw new ErroSintaticoException(t);
			}
		}else if (follow.isFollowOf(RuleType.FID_1, t.getTokenType())) {
			storageToken(RuleType.FID_1, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadFVALLOG() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.LOGIC_OP) {
			storageToken(RuleType.FVALLOG, t);
			loadEXPLO();
		} else if ((t.getTokenType() == TokenType.R_PAR) || (t.getTokenType() == TokenType.TERM)) {
			storageToken(RuleType.FVALLOG, t);
		}else if (follow.isFollowOf(RuleType.FVALLOG, t.getTokenType())) {
			storageToken(RuleType.FVALLOG, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadEXPNUM() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.NUM_INT) || (t.getTokenType() == TokenType.NUM_FLOAT)
				|| (t.getTokenType() == TokenType.ID)) {
			storageToken(RuleType.EXPNUM, t);
			loadVAL();
			loadXEXPNUM();
		} else if (t.getTokenType() == TokenType.L_PAR) {
			storageToken(RuleType.EXPNUM, t);
			loadEXPNUM();
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.R_PAR) {
				storageToken(RuleType.EXPNUM, t);
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadXEXPNUM() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.ARIT_AS) || (t.getTokenType() == TokenType.ARIT_MD)) {
			storageToken(RuleType.XEXPNUM, t);
			loadOPNUM();
			loadEXPNUM();
		} else if ((t.getTokenType() == TokenType.ID) || (t.getTokenType() == TokenType.RELOP)
				|| (t.getTokenType() == TokenType.TERM) || (t.getTokenType() == TokenType.R_PAR)
				|| (t.getTokenType() == TokenType.BEGIN) || (t.getTokenType() == TokenType.IF)
				|| (t.getTokenType() == TokenType.FOR) || (t.getTokenType() == TokenType.WHILE)
				|| (t.getTokenType() == TokenType.DECLARE) || (t.getTokenType() == TokenType.TO)) {
			storageToken(RuleType.XEXPNUM, t);
		}else if (follow.isFollowOf(RuleType.XEXPNUM, t.getTokenType())) {
			storageToken(RuleType.XEXPNUM, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadOPNUM() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.ARIT_AS) || (t.getTokenType() == TokenType.ARIT_MD)) {
			storageToken(RuleType.OPNUM, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadVAL() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if ((t.getTokenType() == TokenType.ID) || (t.getTokenType() == TokenType.NUM_INT)
				|| (t.getTokenType() == TokenType.NUM_FLOAT)) {
			storageToken(RuleType.VAL, t);
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadREP() throws IOException, ErroSintaticoException {
		Token t = lex.nextToken();
		if (t.getTokenType() == TokenType.FOR) {
			storageToken(RuleType.REP, t);
			loadREPF();
		} else if (t.getTokenType() == TokenType.WHILE) {
			storageToken(RuleType.REP, t);
			loadREPW();
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadREPF() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.FOR) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.ID) {
				storageToken(RuleType.REPF, t);
				loadEXPNUM();
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.TO) {
					storageToken(RuleType.REPF, t);
					loadEXPNUM();
					loadBLOCO();
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}
	}

	public void loadREPW() throws IOException, ErroSintaticoException {
		Token t = getStorageToken();
		if (t.getTokenType() == TokenType.WHILE) {
			t = lex.nextToken();
			if (t.getTokenType() == TokenType.L_PAR) {
				storageToken(RuleType.REPW, t);
				loadEXPLO();
				t = lex.nextToken();
				if (t.getTokenType() == TokenType.R_PAR) {
					storageToken(RuleType.REPW, t);
					loadBLOCO();
				} else {
					throw new ErroSintaticoException(t);
				}
			} else {
				throw new ErroSintaticoException(t);
			}
		} else {
			throw new ErroSintaticoException(t);
		}
	}

}
