// Generated from GyhRepaginadoLanguage.g4 by ANTLR 4.7.2

	//importar libs
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GyhRepaginadoLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, FimDelim=7, IniDelim=8, 
		Atrib=9, Opbooleano=10, OpBoolE=11, OpBoolOu=12, OpRel=13, PCProg=14, 
		PCDec=15, VarTipo=16, PCInt=17, PCReal=18, PCLer=19, PCImprimir=20, PCSe=21, 
		PCSenao=22, PCEntao=23, PCEnqto=24, PCIni=25, PCFim=26, Var=27, Cadeia=28, 
		NumInt=29, NumReal=30, WS=31, Comentario=32;
	public static final int
		RULE_programa = 0, RULE_listaDeclaracoes = 1, RULE_declaracao = 2, RULE_expressaoAritmetica = 3, 
		RULE_expressaoAritmeticaLinha = 4, RULE_termoAritmetico = 5, RULE_termoAritmeticoLinha = 6, 
		RULE_fatorAritmetico = 7, RULE_expressaoRelacional = 8, RULE_expressaoRelacionalLinha = 9, 
		RULE_termoRelacional = 10, RULE_listaComandos = 11, RULE_comando = 12, 
		RULE_comandoSaida = 13, RULE_comandoAtribuicao = 14, RULE_comandoEntrada = 15, 
		RULE_comandoCondicao = 16, RULE_comandoRepeticao = 17, RULE_subAlgoritmo = 18, 
		RULE_varUse = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaDeclaracoes", "declaracao", "expressaoAritmetica", 
			"expressaoAritmeticaLinha", "termoAritmetico", "termoAritmeticoLinha", 
			"fatorAritmetico", "expressaoRelacional", "expressaoRelacionalLinha", 
			"termoRelacional", "listaComandos", "comando", "comandoSaida", "comandoAtribuicao", 
			"comandoEntrada", "comandoCondicao", "comandoRepeticao", "subAlgoritmo", 
			"varUse"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'('", "')'", "']'", "'['", "'<<'", 
			null, "'and'", "'or'", null, "'prog'", "'dec'", null, "'integer'", "'float'", 
			"'read'", "'print'", "'if'", "'else'", "'then'", "'while'", "'start'", 
			"'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "FimDelim", "IniDelim", "Atrib", 
			"Opbooleano", "OpBoolE", "OpBoolOu", "OpRel", "PCProg", "PCDec", "VarTipo", 
			"PCInt", "PCReal", "PCLer", "PCImprimir", "PCSe", "PCSenao", "PCEntao", 
			"PCEnqto", "PCIni", "PCFim", "Var", "Cadeia", "NumInt", "NumReal", "WS", 
			"Comentario"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GyhRepaginadoLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private String _nomeVar;
		private String _tipoVar;
		private String _valorVar;
		private String _expressao = "";
		private String _condicao = "";
		private String _condicaoIf = "";
		private String _condicaoWhile = "";

		private ArrayList<ArrayList<Comando>> listIf = new ArrayList<>();
		private ArrayList<ArrayList<Comando>> listElse = new ArrayList<>();
		private ArrayList<ArrayList<Comando>> listWhile = new ArrayList<>();

		private GeraCodigo _codigo = new GeraCodigo();

		private Simbolo _simboloVar;

		private TabelaSimbolos _tabelaSimbolo=new TabelaSimbolos();

		private ArrayList<Comando> listCmd = new ArrayList<>();
		private Stack<ArrayList<Comando>> _stackComandos = new Stack<ArrayList<Comando>>();
		private Stack<String> _stackCondicoes = new Stack<String>();

		public TabelaSimbolos getTabelaSimbolo(){
			return _tabelaSimbolo;
		}

	public GyhRepaginadoLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public List<TerminalNode> IniDelim() { return getTokens(GyhRepaginadoLanguageParser.IniDelim); }
		public TerminalNode IniDelim(int i) {
			return getToken(GyhRepaginadoLanguageParser.IniDelim, i);
		}
		public TerminalNode PCDec() { return getToken(GyhRepaginadoLanguageParser.PCDec, 0); }
		public List<TerminalNode> FimDelim() { return getTokens(GyhRepaginadoLanguageParser.FimDelim); }
		public TerminalNode FimDelim(int i) {
			return getToken(GyhRepaginadoLanguageParser.FimDelim, i);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public TerminalNode PCProg() { return getToken(GyhRepaginadoLanguageParser.PCProg, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GyhRepaginadoLanguageParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(IniDelim);
			setState(41);
			match(PCDec);
			setState(42);
			match(FimDelim);
			setState(43);
			listaDeclaracoes();
			setState(44);
			match(IniDelim);
			setState(45);
			match(PCProg);
			setState(46);
			match(FimDelim);
			setState(47);
			listaComandos();

						_codigo.setTabela(_tabelaSimbolo);
						_codigo.setComandos(_stackComandos.pop());
						_codigo.geradorCodigo();
					
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaDeclaracoesContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public ListaDeclaracoesContext listaDeclaracoes() {
			return getRuleContext(ListaDeclaracoesContext.class,0);
		}
		public ListaDeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaDeclaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterListaDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitListaDeclaracoes(this);
		}
	}

	public final ListaDeclaracoesContext listaDeclaracoes() throws RecognitionException {
		ListaDeclaracoesContext _localctx = new ListaDeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listaDeclaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			declaracao();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(52);
				listaDeclaracoes();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public TerminalNode IniDelim() { return getToken(GyhRepaginadoLanguageParser.IniDelim, 0); }
		public TerminalNode VarTipo() { return getToken(GyhRepaginadoLanguageParser.VarTipo, 0); }
		public TerminalNode FimDelim() { return getToken(GyhRepaginadoLanguageParser.FimDelim, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(Var);
			setState(56);
			match(IniDelim);
			setState(57);
			match(VarTipo);
			setState(58);
			match(FimDelim);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticaLinhaContext expressaoAritmeticaLinha() {
			return getRuleContext(ExpressaoAritmeticaLinhaContext.class,0);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoAritmetica(this);
		}
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expressaoAritmetica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			termoAritmetico();
			setState(61);
			expressaoAritmeticaLinha();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoAritmeticaLinhaContext extends ParserRuleContext {
		public TermoAritmeticoContext termoAritmetico() {
			return getRuleContext(TermoAritmeticoContext.class,0);
		}
		public ExpressaoAritmeticaLinhaContext expressaoAritmeticaLinha() {
			return getRuleContext(ExpressaoAritmeticaLinhaContext.class,0);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ExpressaoAritmeticaLinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmeticaLinha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoAritmeticaLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoAritmeticaLinha(this);
		}
	}

	public final ExpressaoAritmeticaLinhaContext expressaoAritmeticaLinha() throws RecognitionException {
		ExpressaoAritmeticaLinhaContext _localctx = new ExpressaoAritmeticaLinhaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressaoAritmeticaLinha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(63);
				match(T__0);

											_expressao += " + ";
										
				setState(65);
				termoAritmetico();
				setState(66);
				expressaoAritmeticaLinha();
				}
				break;
			case T__1:
				{
				setState(68);
				match(T__1);

											_expressao += " - ";
										
				setState(70);
				termoAritmetico();
				setState(71);
				expressaoAritmetica();
				}
				break;
			case EOF:
			case T__5:
			case Opbooleano:
			case OpRel:
			case PCLer:
			case PCImprimir:
			case PCSe:
			case PCSenao:
			case PCEntao:
			case PCEnqto:
			case PCIni:
			case PCFim:
			case Var:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoAritmeticoContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticoLinhaContext termoAritmeticoLinha() {
			return getRuleContext(TermoAritmeticoLinhaContext.class,0);
		}
		public TermoAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoAritmetico(this);
		}
	}

	public final TermoAritmeticoContext termoAritmetico() throws RecognitionException {
		TermoAritmeticoContext _localctx = new TermoAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_termoAritmetico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			fatorAritmetico();
			setState(76);
			termoAritmeticoLinha();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoAritmeticoLinhaContext extends ParserRuleContext {
		public FatorAritmeticoContext fatorAritmetico() {
			return getRuleContext(FatorAritmeticoContext.class,0);
		}
		public TermoAritmeticoLinhaContext termoAritmeticoLinha() {
			return getRuleContext(TermoAritmeticoLinhaContext.class,0);
		}
		public TermoAritmeticoLinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoAritmeticoLinha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoAritmeticoLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoAritmeticoLinha(this);
		}
	}

	public final TermoAritmeticoLinhaContext termoAritmeticoLinha() throws RecognitionException {
		TermoAritmeticoLinhaContext _localctx = new TermoAritmeticoLinhaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_termoAritmeticoLinha);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(78);
				match(T__2);

										_expressao += " * ";
									
				setState(80);
				fatorAritmetico();
				setState(81);
				termoAritmeticoLinha();
				}
				break;
			case T__3:
				{
				setState(83);
				match(T__3);

										_expressao += " / ";
									
				setState(85);
				fatorAritmetico();
				setState(86);
				termoAritmeticoLinha();
				}
				break;
			case EOF:
			case T__0:
			case T__1:
			case T__4:
			case T__5:
			case Opbooleano:
			case OpRel:
			case PCLer:
			case PCImprimir:
			case PCSe:
			case PCSenao:
			case PCEntao:
			case PCEnqto:
			case PCIni:
			case PCFim:
			case Var:
			case NumInt:
			case NumReal:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorAritmeticoContext extends ParserRuleContext {
		public TerminalNode NumInt() { return getToken(GyhRepaginadoLanguageParser.NumInt, 0); }
		public TerminalNode NumReal() { return getToken(GyhRepaginadoLanguageParser.NumReal, 0); }
		public VarUseContext varUse() {
			return getRuleContext(VarUseContext.class,0);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public FatorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterFatorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitFatorAritmetico(this);
		}
	}

	public final FatorAritmeticoContext fatorAritmetico() throws RecognitionException {
		FatorAritmeticoContext _localctx = new FatorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fatorAritmetico);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NumInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(NumInt);

									_expressao += _input.LT(-1).getText();
								
				}
				break;
			case NumReal:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(NumReal);

									_expressao += _input.LT(-1).getText();
								
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				varUse();

									_expressao += _input.LT(-1).getText();
								
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(T__4);

									_expressao += "(";
								
				setState(99);
				expressaoAritmetica();

									_expressao += ")";
								
				setState(101);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoRelacionalContext extends ParserRuleContext {
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacionalLinhaContext expressaoRelacionalLinha() {
			return getRuleContext(ExpressaoRelacionalLinhaContext.class,0);
		}
		public ExpressaoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoRelacional(this);
		}
	}

	public final ExpressaoRelacionalContext expressaoRelacional() throws RecognitionException {
		ExpressaoRelacionalContext _localctx = new ExpressaoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressaoRelacional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			termoRelacional();
			setState(106);
			expressaoRelacionalLinha();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoRelacionalLinhaContext extends ParserRuleContext {
		public TerminalNode Opbooleano() { return getToken(GyhRepaginadoLanguageParser.Opbooleano, 0); }
		public TermoRelacionalContext termoRelacional() {
			return getRuleContext(TermoRelacionalContext.class,0);
		}
		public ExpressaoRelacionalLinhaContext expressaoRelacionalLinha() {
			return getRuleContext(ExpressaoRelacionalLinhaContext.class,0);
		}
		public ExpressaoRelacionalLinhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRelacionalLinha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterExpressaoRelacionalLinha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitExpressaoRelacionalLinha(this);
		}
	}

	public final ExpressaoRelacionalLinhaContext expressaoRelacionalLinha() throws RecognitionException {
		ExpressaoRelacionalLinhaContext _localctx = new ExpressaoRelacionalLinhaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressaoRelacionalLinha);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Opbooleano) {
				{
				setState(108);
				match(Opbooleano);

														switch(_input.LT(-1).getText()){
															case "and":
																_expressao += " && ";
																break;
															case "or":
																_expressao += " || ";
																break;
															default:
																break;
														}
													
				setState(110);
				termoRelacional();
				setState(111);
				expressaoRelacionalLinha();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoRelacionalContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public TerminalNode OpRel() { return getToken(GyhRepaginadoLanguageParser.OpRel, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TermoRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoRelacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterTermoRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitTermoRelacional(this);
		}
	}

	public final TermoRelacionalContext termoRelacional() throws RecognitionException {
		TermoRelacionalContext _localctx = new TermoRelacionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termoRelacional);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				expressaoAritmetica();

									_condicao += _expressao;
									_expressao = "";
								
				setState(117);
				match(OpRel);

									if (_input.LT(-1).getText().equals("<>")) {
										_expressao += " != ";
									} else {
										_expressao += " "+_input.LT(-1).getText()+" ";
									}
								
				setState(119);
				expressaoAritmetica();

									_condicao += _expressao;
									_expressao = "";
								
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__4);

									_condicao += "(";
								
				setState(124);
				expressaoRelacional();

									_condicao += ")";
								
				setState(126);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitListaComandos(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

								listCmd = new ArrayList<Comando>();
								_stackComandos.push(listCmd);
							
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				comando();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << Var))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public ComandoAtribuicaoContext comandoAtribuicao() {
			return getRuleContext(ComandoAtribuicaoContext.class,0);
		}
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoCondicaoContext comandoCondicao() {
			return getRuleContext(ComandoCondicaoContext.class,0);
		}
		public SubAlgoritmoContext subAlgoritmo() {
			return getRuleContext(SubAlgoritmoContext.class,0);
		}
		public ComandoRepeticaoContext comandoRepeticao() {
			return getRuleContext(ComandoRepeticaoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comando);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				comandoAtribuicao();
				}
				break;
			case PCLer:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				comandoEntrada();
				}
				break;
			case PCImprimir:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				comandoSaida();
				}
				break;
			case PCSe:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				comandoCondicao();
				}
				break;
			case PCIni:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				subAlgoritmo();
				}
				break;
			case PCEnqto:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				comandoRepeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode PCImprimir() { return getToken(GyhRepaginadoLanguageParser.PCImprimir, 0); }
		public VarUseContext varUse() {
			return getRuleContext(VarUseContext.class,0);
		}
		public TerminalNode Cadeia() { return getToken(GyhRepaginadoLanguageParser.Cadeia, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoSaida(this);
		}
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comandoSaida);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(PCImprimir);
				setState(145);
				varUse();

												_nomeVar =_input.LT(-1).getText();

												ComandoSaida cmd = new ComandoSaida();
												cmd.setVariavel(_nomeVar);
												cmd.setTipo(_tabelaSimbolo.getSimbolo(_nomeVar).getTipo().toString());
												_stackComandos.peek().add(cmd);
											
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(PCImprimir);
				setState(149);
				match(Cadeia);
				 // String

												ComandoSaida cmd = new ComandoSaida();
												cmd.setVariavel(_input.LT(-1).getText());
												cmd.setTipo("string");
												_stackComandos.peek().add(cmd);
											
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoAtribuicaoContext extends ParserRuleContext {
		public VarUseContext varUse() {
			return getRuleContext(VarUseContext.class,0);
		}
		public TerminalNode Atrib() { return getToken(GyhRepaginadoLanguageParser.Atrib, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public ComandoAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoAtribuicao(this);
		}
	}

	public final ComandoAtribuicaoContext comandoAtribuicao() throws RecognitionException {
		ComandoAtribuicaoContext _localctx = new ComandoAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoAtribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{

									_tabelaSimbolo.getSimbolo(_input.LT(1).getText()).setWarning(true);
								
			setState(154);
			varUse();

									_nomeVar = _input.LT(-1).getText();
								
			setState(156);
			match(Atrib);
			setState(157);
			expressaoAritmetica();


									ComandoAtribuicao cmd = new ComandoAtribuicao();
									cmd.setVariavel(_nomeVar);
									cmd.setAtribuicao(_expressao);
									_stackComandos.peek().add(cmd);
									_expressao="";
								
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode PCLer() { return getToken(GyhRepaginadoLanguageParser.PCLer, 0); }
		public VarUseContext varUse() {
			return getRuleContext(VarUseContext.class,0);
		}
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoEntrada(this);
		}
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(PCLer);
			setState(161);
			varUse();

										_nomeVar = _input.LT(-1).getText();

										ComandoLeitura cmd = new ComandoLeitura();
										cmd.setVariavel(_nomeVar);
										cmd.setTipo(_tabelaSimbolo.getSimbolo(_nomeVar).getTipo().toString());
										_stackComandos.peek().add(cmd);
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoCondicaoContext extends ParserRuleContext {
		public TerminalNode PCSe() { return getToken(GyhRepaginadoLanguageParser.PCSe, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GyhRepaginadoLanguageParser.PCEntao, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode PCSenao() { return getToken(GyhRepaginadoLanguageParser.PCSenao, 0); }
		public ComandoCondicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoCondicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoCondicao(this);
		}
	}

	public final ComandoCondicaoContext comandoCondicao() throws RecognitionException {
		ComandoCondicaoContext _localctx = new ComandoCondicaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoCondicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(PCSe);

									_condicao = "";
									_expressao = "";
								
			setState(166);
			expressaoRelacional();
			setState(167);
			match(PCEntao);

									listCmd = new ArrayList<Comando>();
									_stackComandos.push(listCmd);
									_stackCondicoes.push(_condicao);
								
			setState(169);
			comando();

									listIf.add(_stackComandos.pop());
									//_condicaoIf = _stackCondicoes.pop();
								
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(171);
				match(PCSenao);

										listCmd = new ArrayList<Comando>();
										_stackComandos.push(listCmd);
									
				setState(173);
				comando();

										listElse.add(_stackComandos.pop());
									
				}
				break;
			}

									ComandoCondicao cmd = new ComandoCondicao();
									cmd.setCondicao(_stackCondicoes.pop());
									if (listIf.size() > 0)
										cmd.setListIf(listIf.remove(listIf.size()-1));
									if (listElse.size() > 0)
										cmd.setListElse(listElse.remove(listElse.size()-1));
									_stackComandos.peek().add(cmd);
								
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoRepeticaoContext extends ParserRuleContext {
		public TerminalNode PCEnqto() { return getToken(GyhRepaginadoLanguageParser.PCEnqto, 0); }
		public ExpressaoRelacionalContext expressaoRelacional() {
			return getRuleContext(ExpressaoRelacionalContext.class,0);
		}
		public TerminalNode PCEntao() { return getToken(GyhRepaginadoLanguageParser.PCEntao, 0); }
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public ComandoRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterComandoRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitComandoRepeticao(this);
		}
	}

	public final ComandoRepeticaoContext comandoRepeticao() throws RecognitionException {
		ComandoRepeticaoContext _localctx = new ComandoRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comandoRepeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(PCEnqto);

										_condicao = "";
										_expressao = "";
									
			setState(182);
			expressaoRelacional();
			setState(183);
			match(PCEntao);

										listCmd = new ArrayList<Comando>();
										_stackComandos.push(listCmd);
										_stackCondicoes.push(_condicao);
									
			setState(185);
			comando();

										listWhile.add(_stackComandos.pop());
										//_condicaoWhile = _stackCondicoes.pop();

										ComandoRepeticao cmd = new ComandoRepeticao();
										cmd.setCondicao(_stackCondicoes.pop());
										if (listWhile.size() > 0)
											cmd.setListWhile(listWhile.remove(listWhile.size()-1));
										_stackComandos.peek().add(cmd);
									
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubAlgoritmoContext extends ParserRuleContext {
		public TerminalNode PCIni() { return getToken(GyhRepaginadoLanguageParser.PCIni, 0); }
		public TerminalNode PCFim() { return getToken(GyhRepaginadoLanguageParser.PCFim, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SubAlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAlgoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterSubAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitSubAlgoritmo(this);
		}
	}

	public final SubAlgoritmoContext subAlgoritmo() throws RecognitionException {
		SubAlgoritmoContext _localctx = new SubAlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subAlgoritmo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(PCIni);
			setState(190); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(189);
				comando();
				}
				}
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PCLer) | (1L << PCImprimir) | (1L << PCSe) | (1L << PCEnqto) | (1L << PCIni) | (1L << Var))) != 0) );
			setState(194);
			match(PCFim);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarUseContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(GyhRepaginadoLanguageParser.Var, 0); }
		public VarUseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varUse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).enterVarUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GyhRepaginadoLanguageListener ) ((GyhRepaginadoLanguageListener)listener).exitVarUse(this);
		}
	}

	public final VarUseContext varUse() throws RecognitionException {
		VarUseContext _localctx = new VarUseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varUse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(Var);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\5\38\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b[\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\tj\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13t\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0083\n\f\3\r\3\r"+
		"\6\r\u0087\n\r\r\r\16\r\u0088\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0091"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u009a\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\6\24\u00c1\n\24\r\24\16\24\u00c2\3"+
		"\24\3\24\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(\2\2\2\u00c7\2*\3\2\2\2\4\65\3\2\2\2\69\3\2\2\2\b>\3\2\2\2\nK\3"+
		"\2\2\2\fM\3\2\2\2\16Z\3\2\2\2\20i\3\2\2\2\22k\3\2\2\2\24s\3\2\2\2\26\u0082"+
		"\3\2\2\2\30\u0084\3\2\2\2\32\u0090\3\2\2\2\34\u0099\3\2\2\2\36\u009b\3"+
		"\2\2\2 \u00a2\3\2\2\2\"\u00a6\3\2\2\2$\u00b6\3\2\2\2&\u00be\3\2\2\2(\u00c6"+
		"\3\2\2\2*+\7\n\2\2+,\7\21\2\2,-\7\t\2\2-.\5\4\3\2./\7\n\2\2/\60\7\20\2"+
		"\2\60\61\7\t\2\2\61\62\5\30\r\2\62\63\b\2\1\2\63\64\7\2\2\3\64\3\3\2\2"+
		"\2\65\67\5\6\4\2\668\5\4\3\2\67\66\3\2\2\2\678\3\2\2\28\5\3\2\2\29:\7"+
		"\35\2\2:;\7\n\2\2;<\7\22\2\2<=\7\t\2\2=\7\3\2\2\2>?\5\f\7\2?@\5\n\6\2"+
		"@\t\3\2\2\2AB\7\3\2\2BC\b\6\1\2CD\5\f\7\2DE\5\n\6\2EL\3\2\2\2FG\7\4\2"+
		"\2GH\b\6\1\2HI\5\f\7\2IJ\5\b\5\2JL\3\2\2\2KA\3\2\2\2KF\3\2\2\2KL\3\2\2"+
		"\2L\13\3\2\2\2MN\5\20\t\2NO\5\16\b\2O\r\3\2\2\2PQ\7\5\2\2QR\b\b\1\2RS"+
		"\5\20\t\2ST\5\16\b\2T[\3\2\2\2UV\7\6\2\2VW\b\b\1\2WX\5\20\t\2XY\5\16\b"+
		"\2Y[\3\2\2\2ZP\3\2\2\2ZU\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\]\7\37\2\2]j\b"+
		"\t\1\2^_\7 \2\2_j\b\t\1\2`a\5(\25\2ab\b\t\1\2bj\3\2\2\2cd\7\7\2\2de\b"+
		"\t\1\2ef\5\b\5\2fg\b\t\1\2gh\7\b\2\2hj\3\2\2\2i\\\3\2\2\2i^\3\2\2\2i`"+
		"\3\2\2\2ic\3\2\2\2j\21\3\2\2\2kl\5\26\f\2lm\5\24\13\2m\23\3\2\2\2no\7"+
		"\f\2\2op\b\13\1\2pq\5\26\f\2qr\5\24\13\2rt\3\2\2\2sn\3\2\2\2st\3\2\2\2"+
		"t\25\3\2\2\2uv\5\b\5\2vw\b\f\1\2wx\7\17\2\2xy\b\f\1\2yz\5\b\5\2z{\b\f"+
		"\1\2{\u0083\3\2\2\2|}\7\7\2\2}~\b\f\1\2~\177\5\22\n\2\177\u0080\b\f\1"+
		"\2\u0080\u0081\7\b\2\2\u0081\u0083\3\2\2\2\u0082u\3\2\2\2\u0082|\3\2\2"+
		"\2\u0083\27\3\2\2\2\u0084\u0086\b\r\1\2\u0085\u0087\5\32\16\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\31\3\2\2\2\u008a\u0091\5\36\20\2\u008b\u0091\5 \21\2\u008c\u0091\5\34"+
		"\17\2\u008d\u0091\5\"\22\2\u008e\u0091\5&\24\2\u008f\u0091\5$\23\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\33\3\2\2\2\u0092\u0093"+
		"\7\26\2\2\u0093\u0094\5(\25\2\u0094\u0095\b\17\1\2\u0095\u009a\3\2\2\2"+
		"\u0096\u0097\7\26\2\2\u0097\u0098\7\36\2\2\u0098\u009a\b\17\1\2\u0099"+
		"\u0092\3\2\2\2\u0099\u0096\3\2\2\2\u009a\35\3\2\2\2\u009b\u009c\b\20\1"+
		"\2\u009c\u009d\5(\25\2\u009d\u009e\b\20\1\2\u009e\u009f\7\13\2\2\u009f"+
		"\u00a0\5\b\5\2\u00a0\u00a1\b\20\1\2\u00a1\37\3\2\2\2\u00a2\u00a3\7\25"+
		"\2\2\u00a3\u00a4\5(\25\2\u00a4\u00a5\b\21\1\2\u00a5!\3\2\2\2\u00a6\u00a7"+
		"\7\27\2\2\u00a7\u00a8\b\22\1\2\u00a8\u00a9\5\22\n\2\u00a9\u00aa\7\31\2"+
		"\2\u00aa\u00ab\b\22\1\2\u00ab\u00ac\5\32\16\2\u00ac\u00b2\b\22\1\2\u00ad"+
		"\u00ae\7\30\2\2\u00ae\u00af\b\22\1\2\u00af\u00b0\5\32\16\2\u00b0\u00b1"+
		"\b\22\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00b3\3\2\2\2"+
		"\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\22\1\2\u00b5#\3\2\2\2\u00b6\u00b7\7"+
		"\32\2\2\u00b7\u00b8\b\23\1\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\7\31\2\2"+
		"\u00ba\u00bb\b\23\1\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\b\23\1\2\u00bd"+
		"%\3\2\2\2\u00be\u00c0\7\33\2\2\u00bf\u00c1\5\32\16\2\u00c0\u00bf\3\2\2"+
		"\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\7\34\2\2\u00c5\'\3\2\2\2\u00c6\u00c7\7\35\2\2\u00c7"+
		")\3\2\2\2\r\67KZis\u0082\u0088\u0090\u0099\u00b2\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}