package io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen;// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class WhileParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, SKIP_STM=2, PRINT_INT_STM=3, PRINT_STRING_STM=4, PRINT_BOOL_STM=5, 
		READ_INT_STM=6, READ_STRING_STM=7, READ_BOOL_STM=8, IF=9, THEN=10, ELSE=11, 
		WHILE=12, DO=13, SEMICOLON=14, TYPE=15, INT_TYPE=16, BOOL_TYPE=17, STRING_TYPE=18, 
		PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, INT=24, STRING=25, TRUE=26, 
		FALSE=27, NOT=28, AND=29, OR=30, EQ=31, LT=32, GT=33, LE=34, GE=35, LPAREN=36, 
		RPAREN=37, BLOCKCOMMENT=38, VAR=39, WS=40;
	public static final int
		RULE_prog = 0, RULE_stm = 1, RULE_unaryStm = 2, RULE_declareStm = 3, RULE_assignStm = 4, 
		RULE_skipStm = 5, RULE_printIntStm = 6, RULE_printStringStm = 7, RULE_printBoolStm = 8, 
		RULE_readIntStm = 9, RULE_readStringStm = 10, RULE_readBoolStm = 11, RULE_ifStm = 12, 
		RULE_branchOne = 13, RULE_branchTwo = 14, RULE_whileStm = 15, RULE_whileBody = 16, 
		RULE_condition = 17, RULE_blockStm = 18, RULE_expr = 19, RULE_untypedexpr = 20, 
		RULE_typedexpr = 21, RULE_aexp = 22, RULE_aexpatom = 23, RULE_bexp = 24, 
		RULE_bexpatom = 25, RULE_strexpr = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stm", "unaryStm", "declareStm", "assignStm", "skipStm", "printIntStm", 
			"printStringStm", "printBoolStm", "readIntStm", "readStringStm", "readBoolStm", 
			"ifStm", "branchOne", "branchTwo", "whileStm", "whileBody", "condition", 
			"blockStm", "expr", "untypedexpr", "typedexpr", "aexp", "aexpatom", "bexp", 
			"bexpatom", "strexpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'skip'", "'printInt'", "'printString'", "'printBool'", 
			"'readInt'", "'readString'", "'readBool'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "';'", null, "'int'", "'bool'", "'string'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", null, null, "'true'", "'false'", "'not'", 
			"'and'", "'or'", "'='", "'<'", "'>'", "'<='", "'>='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "SKIP_STM", "PRINT_INT_STM", "PRINT_STRING_STM", "PRINT_BOOL_STM", 
			"READ_INT_STM", "READ_STRING_STM", "READ_BOOL_STM", "IF", "THEN", "ELSE", 
			"WHILE", "DO", "SEMICOLON", "TYPE", "INT_TYPE", "BOOL_TYPE", "STRING_TYPE", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "INT", "STRING", "TRUE", "FALSE", 
			"NOT", "AND", "OR", "EQ", "LT", "GT", "LE", "GE", "LPAREN", "RPAREN", 
			"BLOCKCOMMENT", "VAR", "WS"
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
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WhileParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public TerminalNode EOF() { return getToken(WhileParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			stm(0);
			setState(55);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmContext extends ParserRuleContext {
		public UnaryStmContext unaryStm() {
			return getRuleContext(UnaryStmContext.class,0);
		}
		public BlockStmContext blockStm() {
			return getRuleContext(BlockStmContext.class,0);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(WhileParser.SEMICOLON, 0); }
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		return stm(0);
	}

	private StmContext stm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmContext _localctx = new StmContext(_ctx, _parentState);
		StmContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_stm, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STM:
			case PRINT_INT_STM:
			case PRINT_STRING_STM:
			case PRINT_BOOL_STM:
			case READ_INT_STM:
			case READ_STRING_STM:
			case READ_BOOL_STM:
			case IF:
			case WHILE:
			case TYPE:
			case VAR:
				{
				setState(58);
				unaryStm();
				}
				break;
			case LPAREN:
				{
				setState(59);
				blockStm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stm);
					setState(62);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(63);
					match(SEMICOLON);
					setState(64);
					stm(2);
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryStmContext extends ParserRuleContext {
		public DeclareStmContext declareStm() {
			return getRuleContext(DeclareStmContext.class,0);
		}
		public AssignStmContext assignStm() {
			return getRuleContext(AssignStmContext.class,0);
		}
		public SkipStmContext skipStm() {
			return getRuleContext(SkipStmContext.class,0);
		}
		public PrintIntStmContext printIntStm() {
			return getRuleContext(PrintIntStmContext.class,0);
		}
		public PrintStringStmContext printStringStm() {
			return getRuleContext(PrintStringStmContext.class,0);
		}
		public PrintBoolStmContext printBoolStm() {
			return getRuleContext(PrintBoolStmContext.class,0);
		}
		public ReadIntStmContext readIntStm() {
			return getRuleContext(ReadIntStmContext.class,0);
		}
		public ReadStringStmContext readStringStm() {
			return getRuleContext(ReadStringStmContext.class,0);
		}
		public ReadBoolStmContext readBoolStm() {
			return getRuleContext(ReadBoolStmContext.class,0);
		}
		public IfStmContext ifStm() {
			return getRuleContext(IfStmContext.class,0);
		}
		public WhileStmContext whileStm() {
			return getRuleContext(WhileStmContext.class,0);
		}
		public UnaryStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterUnaryStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitUnaryStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitUnaryStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryStmContext unaryStm() throws RecognitionException {
		UnaryStmContext _localctx = new UnaryStmContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unaryStm);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				declareStm();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				assignStm();
				}
				break;
			case SKIP_STM:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				skipStm();
				}
				break;
			case PRINT_INT_STM:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				printIntStm();
				}
				break;
			case PRINT_STRING_STM:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				printStringStm();
				}
				break;
			case PRINT_BOOL_STM:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				printBoolStm();
				}
				break;
			case READ_INT_STM:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				readIntStm();
				}
				break;
			case READ_STRING_STM:
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
				readStringStm();
				}
				break;
			case READ_BOOL_STM:
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				readBoolStm();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 10);
				{
				setState(79);
				ifStm();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 11);
				{
				setState(80);
				whileStm();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareStmContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(WhileParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(WhileParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclareStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterDeclareStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitDeclareStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitDeclareStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareStmContext declareStm() throws RecognitionException {
		DeclareStmContext _localctx = new DeclareStmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declareStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(TYPE);
			setState(84);
			match(VAR);
			setState(85);
			match(ASSIGN);
			setState(86);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(WhileParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterAssignStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitAssignStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitAssignStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmContext assignStm() throws RecognitionException {
		AssignStmContext _localctx = new AssignStmContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(VAR);
			setState(89);
			match(ASSIGN);
			setState(90);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SkipStmContext extends ParserRuleContext {
		public TerminalNode SKIP_STM() { return getToken(WhileParser.SKIP_STM, 0); }
		public SkipStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterSkipStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitSkipStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitSkipStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipStmContext skipStm() throws RecognitionException {
		SkipStmContext _localctx = new SkipStmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_skipStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(SKIP_STM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintIntStmContext extends ParserRuleContext {
		public TerminalNode PRINT_INT_STM() { return getToken(WhileParser.PRINT_INT_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public PrintIntStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printIntStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterPrintIntStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitPrintIntStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitPrintIntStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintIntStmContext printIntStm() throws RecognitionException {
		PrintIntStmContext _localctx = new PrintIntStmContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printIntStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(PRINT_INT_STM);
			setState(95);
			match(LPAREN);
			setState(96);
			aexp(0);
			setState(97);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStringStmContext extends ParserRuleContext {
		public TerminalNode PRINT_STRING_STM() { return getToken(WhileParser.PRINT_STRING_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public StrexprContext strexpr() {
			return getRuleContext(StrexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public PrintStringStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStringStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterPrintStringStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitPrintStringStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitPrintStringStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStringStmContext printStringStm() throws RecognitionException {
		PrintStringStmContext _localctx = new PrintStringStmContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_printStringStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(PRINT_STRING_STM);
			setState(100);
			match(LPAREN);
			setState(101);
			strexpr();
			setState(102);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintBoolStmContext extends ParserRuleContext {
		public TerminalNode PRINT_BOOL_STM() { return getToken(WhileParser.PRINT_BOOL_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public PrintBoolStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printBoolStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterPrintBoolStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitPrintBoolStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitPrintBoolStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintBoolStmContext printBoolStm() throws RecognitionException {
		PrintBoolStmContext _localctx = new PrintBoolStmContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printBoolStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(PRINT_BOOL_STM);
			setState(105);
			match(LPAREN);
			setState(106);
			bexp(0);
			setState(107);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadIntStmContext extends ParserRuleContext {
		public TerminalNode READ_INT_STM() { return getToken(WhileParser.READ_INT_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public ReadIntStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readIntStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterReadIntStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitReadIntStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitReadIntStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadIntStmContext readIntStm() throws RecognitionException {
		ReadIntStmContext _localctx = new ReadIntStmContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_readIntStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(READ_INT_STM);
			setState(110);
			match(LPAREN);
			setState(111);
			match(VAR);
			setState(112);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStringStmContext extends ParserRuleContext {
		public TerminalNode READ_STRING_STM() { return getToken(WhileParser.READ_STRING_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public ReadStringStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStringStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterReadStringStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitReadStringStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitReadStringStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStringStmContext readStringStm() throws RecognitionException {
		ReadStringStmContext _localctx = new ReadStringStmContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_readStringStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(READ_STRING_STM);
			setState(115);
			match(LPAREN);
			setState(116);
			match(VAR);
			setState(117);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadBoolStmContext extends ParserRuleContext {
		public TerminalNode READ_BOOL_STM() { return getToken(WhileParser.READ_BOOL_STM, 0); }
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public ReadBoolStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readBoolStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterReadBoolStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitReadBoolStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitReadBoolStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadBoolStmContext readBoolStm() throws RecognitionException {
		ReadBoolStmContext _localctx = new ReadBoolStmContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_readBoolStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(READ_BOOL_STM);
			setState(120);
			match(LPAREN);
			setState(121);
			match(VAR);
			setState(122);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(WhileParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(WhileParser.THEN, 0); }
		public BranchOneContext branchOne() {
			return getRuleContext(BranchOneContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(WhileParser.ELSE, 0); }
		public BranchTwoContext branchTwo() {
			return getRuleContext(BranchTwoContext.class,0);
		}
		public IfStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterIfStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitIfStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIfStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmContext ifStm() throws RecognitionException {
		IfStmContext _localctx = new IfStmContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(IF);
			setState(125);
			condition();
			setState(126);
			match(THEN);
			setState(127);
			branchOne();
			setState(128);
			match(ELSE);
			setState(129);
			branchTwo();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BranchOneContext extends ParserRuleContext {
		public UnaryStmContext unaryStm() {
			return getRuleContext(UnaryStmContext.class,0);
		}
		public BlockStmContext blockStm() {
			return getRuleContext(BlockStmContext.class,0);
		}
		public BranchOneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchOne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterBranchOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitBranchOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBranchOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchOneContext branchOne() throws RecognitionException {
		BranchOneContext _localctx = new BranchOneContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_branchOne);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STM:
			case PRINT_INT_STM:
			case PRINT_STRING_STM:
			case PRINT_BOOL_STM:
			case READ_INT_STM:
			case READ_STRING_STM:
			case READ_BOOL_STM:
			case IF:
			case WHILE:
			case TYPE:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				unaryStm();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				blockStm();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BranchTwoContext extends ParserRuleContext {
		public UnaryStmContext unaryStm() {
			return getRuleContext(UnaryStmContext.class,0);
		}
		public BlockStmContext blockStm() {
			return getRuleContext(BlockStmContext.class,0);
		}
		public BranchTwoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchTwo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterBranchTwo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitBranchTwo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBranchTwo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchTwoContext branchTwo() throws RecognitionException {
		BranchTwoContext _localctx = new BranchTwoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_branchTwo);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STM:
			case PRINT_INT_STM:
			case PRINT_STRING_STM:
			case PRINT_BOOL_STM:
			case READ_INT_STM:
			case READ_STRING_STM:
			case READ_BOOL_STM:
			case IF:
			case WHILE:
			case TYPE:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				unaryStm();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				blockStm();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(WhileParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode DO() { return getToken(WhileParser.DO, 0); }
		public WhileBodyContext whileBody() {
			return getRuleContext(WhileBodyContext.class,0);
		}
		public WhileStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterWhileStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitWhileStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitWhileStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmContext whileStm() throws RecognitionException {
		WhileStmContext _localctx = new WhileStmContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(WHILE);
			setState(140);
			condition();
			setState(141);
			match(DO);
			setState(142);
			whileBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileBodyContext extends ParserRuleContext {
		public UnaryStmContext unaryStm() {
			return getRuleContext(UnaryStmContext.class,0);
		}
		public BlockStmContext blockStm() {
			return getRuleContext(BlockStmContext.class,0);
		}
		public WhileBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterWhileBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitWhileBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitWhileBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileBodyContext whileBody() throws RecognitionException {
		WhileBodyContext _localctx = new WhileBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileBody);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STM:
			case PRINT_INT_STM:
			case PRINT_STRING_STM:
			case PRINT_BOOL_STM:
			case READ_INT_STM:
			case READ_STRING_STM:
			case READ_BOOL_STM:
			case IF:
			case WHILE:
			case TYPE:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				unaryStm();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				blockStm();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			bexp(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public BlockStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterBlockStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitBlockStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBlockStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmContext blockStm() throws RecognitionException {
		BlockStmContext _localctx = new BlockStmContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_blockStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(LPAREN);
			setState(151);
			stm(0);
			setState(152);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public UntypedexprContext untypedexpr() {
			return getRuleContext(UntypedexprContext.class,0);
		}
		public TypedexprContext typedexpr() {
			return getRuleContext(TypedexprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expr);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				untypedexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				typedexpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UntypedexprContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public UntypedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untypedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterUntypedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitUntypedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitUntypedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntypedexprContext untypedexpr() throws RecognitionException {
		UntypedexprContext _localctx = new UntypedexprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_untypedexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(VAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypedexprContext extends ParserRuleContext {
		public StrexprContext strexpr() {
			return getRuleContext(StrexprContext.class,0);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public TypedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterTypedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitTypedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitTypedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedexprContext typedexpr() throws RecognitionException {
		TypedexprContext _localctx = new TypedexprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typedexpr);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				strexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				aexp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				bexp(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AexpContext extends ParserRuleContext {
		public AexpatomContext aexpatom() {
			return getRuleContext(AexpatomContext.class,0);
		}
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public TerminalNode MULT() { return getToken(WhileParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(WhileParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(WhileParser.MOD, 0); }
		public TerminalNode MINUS() { return getToken(WhileParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(WhileParser.PLUS, 0); }
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterAexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitAexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitAexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_aexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(166);
			aexpatom();
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(168);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(169);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						aexp(4);
						}
						break;
					case 2:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(171);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(172);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(173);
						aexp(3);
						}
						break;
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AexpatomContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public TerminalNode INT() { return getToken(WhileParser.INT, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public AexpatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpatom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterAexpatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitAexpatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitAexpatom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpatomContext aexpatom() throws RecognitionException {
		AexpatomContext _localctx = new AexpatomContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_aexpatom);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(LPAREN);
				setState(180);
				aexp(0);
				setState(181);
				match(RPAREN);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(INT);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(VAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BexpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(WhileParser.NOT, 0); }
		public List<BexpContext> bexp() {
			return getRuleContexts(BexpContext.class);
		}
		public BexpContext bexp(int i) {
			return getRuleContext(BexpContext.class,i);
		}
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public TerminalNode EQ() { return getToken(WhileParser.EQ, 0); }
		public TerminalNode GT() { return getToken(WhileParser.GT, 0); }
		public TerminalNode LT() { return getToken(WhileParser.LT, 0); }
		public TerminalNode GE() { return getToken(WhileParser.GE, 0); }
		public TerminalNode LE() { return getToken(WhileParser.LE, 0); }
		public List<StrexprContext> strexpr() {
			return getRuleContexts(StrexprContext.class);
		}
		public StrexprContext strexpr(int i) {
			return getRuleContext(StrexprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(WhileParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(WhileParser.RPAREN, 0); }
		public BexpatomContext bexpatom() {
			return getRuleContext(BexpatomContext.class,0);
		}
		public TerminalNode AND() { return getToken(WhileParser.AND, 0); }
		public TerminalNode OR() { return getToken(WhileParser.OR, 0); }
		public BexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterBexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitBexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexpContext bexp() throws RecognitionException {
		return bexp(0);
	}

	private BexpContext bexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BexpContext _localctx = new BexpContext(_ctx, _parentState);
		BexpContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_bexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(188);
				match(NOT);
				setState(189);
				bexp(8);
				}
				break;
			case 2:
				{
				setState(190);
				aexp(0);
				setState(191);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66571993088L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				aexp(0);
				}
				break;
			case 3:
				{
				setState(194);
				strexpr();
				setState(195);
				match(EQ);
				setState(196);
				strexpr();
				}
				break;
			case 4:
				{
				setState(198);
				match(LPAREN);
				setState(199);
				bexp(0);
				setState(200);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(202);
				bexpatom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(205);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(206);
						match(AND);
						setState(207);
						bexp(8);
						}
						break;
					case 2:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(208);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(209);
						match(OR);
						setState(210);
						bexp(7);
						}
						break;
					case 3:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(211);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(212);
						match(EQ);
						setState(213);
						bexp(6);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BexpatomContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(WhileParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(WhileParser.FALSE, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public BexpatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpatom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterBexpatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitBexpatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBexpatom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexpatomContext bexpatom() throws RecognitionException {
		BexpatomContext _localctx = new BexpatomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bexpatom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 549957140480L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StrexprContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(WhileParser.STRING, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public StrexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterStrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitStrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitStrexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrexprContext strexpr() throws RecognitionException {
		StrexprContext _localctx = new StrexprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_strexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return stm_sempred((StmContext)_localctx, predIndex);
		case 22:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 24:
			return bexp_sempred((BexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stm_sempred(StmContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bexp_sempred(BexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00e0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001B\b\u0001\n\u0001\f\u0001"+
		"E\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002R\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0003\r\u0086\b\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u008a\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u0093\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u009d\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00a4\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u00af\b\u0016\n\u0016\f\u0016\u00b2\t\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u00ba\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u00cc\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00d7\b\u0018"+
		"\n\u0018\f\u0018\u00da\t\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0000\u0003\u0002,0\u001b\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"4\u0000\u0005\u0001\u0000\u0015\u0017\u0001\u0000\u0013\u0014\u0001\u0000"+
		"\u001f#\u0002\u0000\u001a\u001b\'\'\u0002\u0000\u0019\u0019\'\'\u00e1"+
		"\u00006\u0001\u0000\u0000\u0000\u0002<\u0001\u0000\u0000\u0000\u0004Q"+
		"\u0001\u0000\u0000\u0000\u0006S\u0001\u0000\u0000\u0000\bX\u0001\u0000"+
		"\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f^\u0001\u0000\u0000\u0000\u000e"+
		"c\u0001\u0000\u0000\u0000\u0010h\u0001\u0000\u0000\u0000\u0012m\u0001"+
		"\u0000\u0000\u0000\u0014r\u0001\u0000\u0000\u0000\u0016w\u0001\u0000\u0000"+
		"\u0000\u0018|\u0001\u0000\u0000\u0000\u001a\u0085\u0001\u0000\u0000\u0000"+
		"\u001c\u0089\u0001\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000"+
		" \u0092\u0001\u0000\u0000\u0000\"\u0094\u0001\u0000\u0000\u0000$\u0096"+
		"\u0001\u0000\u0000\u0000&\u009c\u0001\u0000\u0000\u0000(\u009e\u0001\u0000"+
		"\u0000\u0000*\u00a3\u0001\u0000\u0000\u0000,\u00a5\u0001\u0000\u0000\u0000"+
		".\u00b9\u0001\u0000\u0000\u00000\u00cb\u0001\u0000\u0000\u00002\u00db"+
		"\u0001\u0000\u0000\u00004\u00dd\u0001\u0000\u0000\u000067\u0003\u0002"+
		"\u0001\u000078\u0005\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u0000"+
		"9:\u0006\u0001\uffff\uffff\u0000:=\u0003\u0004\u0002\u0000;=\u0003$\u0012"+
		"\u0000<9\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=C\u0001\u0000"+
		"\u0000\u0000>?\n\u0001\u0000\u0000?@\u0005\u000e\u0000\u0000@B\u0003\u0002"+
		"\u0001\u0002A>\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000D\u0003\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000FR\u0003\u0006\u0003\u0000GR\u0003\b\u0004"+
		"\u0000HR\u0003\n\u0005\u0000IR\u0003\f\u0006\u0000JR\u0003\u000e\u0007"+
		"\u0000KR\u0003\u0010\b\u0000LR\u0003\u0012\t\u0000MR\u0003\u0014\n\u0000"+
		"NR\u0003\u0016\u000b\u0000OR\u0003\u0018\f\u0000PR\u0003\u001e\u000f\u0000"+
		"QF\u0001\u0000\u0000\u0000QG\u0001\u0000\u0000\u0000QH\u0001\u0000\u0000"+
		"\u0000QI\u0001\u0000\u0000\u0000QJ\u0001\u0000\u0000\u0000QK\u0001\u0000"+
		"\u0000\u0000QL\u0001\u0000\u0000\u0000QM\u0001\u0000\u0000\u0000QN\u0001"+
		"\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000"+
		"R\u0005\u0001\u0000\u0000\u0000ST\u0005\u000f\u0000\u0000TU\u0005\'\u0000"+
		"\u0000UV\u0005\u0001\u0000\u0000VW\u0003&\u0013\u0000W\u0007\u0001\u0000"+
		"\u0000\u0000XY\u0005\'\u0000\u0000YZ\u0005\u0001\u0000\u0000Z[\u0003&"+
		"\u0013\u0000[\t\u0001\u0000\u0000\u0000\\]\u0005\u0002\u0000\u0000]\u000b"+
		"\u0001\u0000\u0000\u0000^_\u0005\u0003\u0000\u0000_`\u0005$\u0000\u0000"+
		"`a\u0003,\u0016\u0000ab\u0005%\u0000\u0000b\r\u0001\u0000\u0000\u0000"+
		"cd\u0005\u0004\u0000\u0000de\u0005$\u0000\u0000ef\u00034\u001a\u0000f"+
		"g\u0005%\u0000\u0000g\u000f\u0001\u0000\u0000\u0000hi\u0005\u0005\u0000"+
		"\u0000ij\u0005$\u0000\u0000jk\u00030\u0018\u0000kl\u0005%\u0000\u0000"+
		"l\u0011\u0001\u0000\u0000\u0000mn\u0005\u0006\u0000\u0000no\u0005$\u0000"+
		"\u0000op\u0005\'\u0000\u0000pq\u0005%\u0000\u0000q\u0013\u0001\u0000\u0000"+
		"\u0000rs\u0005\u0007\u0000\u0000st\u0005$\u0000\u0000tu\u0005\'\u0000"+
		"\u0000uv\u0005%\u0000\u0000v\u0015\u0001\u0000\u0000\u0000wx\u0005\b\u0000"+
		"\u0000xy\u0005$\u0000\u0000yz\u0005\'\u0000\u0000z{\u0005%\u0000\u0000"+
		"{\u0017\u0001\u0000\u0000\u0000|}\u0005\t\u0000\u0000}~\u0003\"\u0011"+
		"\u0000~\u007f\u0005\n\u0000\u0000\u007f\u0080\u0003\u001a\r\u0000\u0080"+
		"\u0081\u0005\u000b\u0000\u0000\u0081\u0082\u0003\u001c\u000e\u0000\u0082"+
		"\u0019\u0001\u0000\u0000\u0000\u0083\u0086\u0003\u0004\u0002\u0000\u0084"+
		"\u0086\u0003$\u0012\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u001b\u0001\u0000\u0000\u0000\u0087\u008a"+
		"\u0003\u0004\u0002\u0000\u0088\u008a\u0003$\u0012\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u001d\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005\f\u0000\u0000\u008c\u008d\u0003\""+
		"\u0011\u0000\u008d\u008e\u0005\r\u0000\u0000\u008e\u008f\u0003 \u0010"+
		"\u0000\u008f\u001f\u0001\u0000\u0000\u0000\u0090\u0093\u0003\u0004\u0002"+
		"\u0000\u0091\u0093\u0003$\u0012\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0091\u0001\u0000\u0000\u0000\u0093!\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u00030\u0018\u0000\u0095#\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"$\u0000\u0000\u0097\u0098\u0003\u0002\u0001\u0000\u0098\u0099\u0005%\u0000"+
		"\u0000\u0099%\u0001\u0000\u0000\u0000\u009a\u009d\u0003(\u0014\u0000\u009b"+
		"\u009d\u0003*\u0015\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009d\'\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\'\u0000\u0000\u009f)\u0001\u0000\u0000\u0000\u00a0\u00a4\u00034\u001a"+
		"\u0000\u00a1\u00a4\u0003,\u0016\u0000\u00a2\u00a4\u00030\u0018\u0000\u00a3"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4+\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0006\u0016\uffff\uffff\u0000\u00a6\u00a7\u0003.\u0017\u0000\u00a7\u00b0"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0003\u0000\u0000\u00a9\u00aa\u0007"+
		"\u0000\u0000\u0000\u00aa\u00af\u0003,\u0016\u0004\u00ab\u00ac\n\u0002"+
		"\u0000\u0000\u00ac\u00ad\u0007\u0001\u0000\u0000\u00ad\u00af\u0003,\u0016"+
		"\u0003\u00ae\u00a8\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001\u0000\u0000"+
		"\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1-\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005$\u0000\u0000\u00b4"+
		"\u00b5\u0003,\u0016\u0000\u00b5\u00b6\u0005%\u0000\u0000\u00b6\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b7\u00ba\u0005\u0018\u0000\u0000\u00b8\u00ba\u0005"+
		"\'\u0000\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba/\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0006\u0018\uffff\uffff\u0000\u00bc\u00bd\u0005\u001c"+
		"\u0000\u0000\u00bd\u00cc\u00030\u0018\b\u00be\u00bf\u0003,\u0016\u0000"+
		"\u00bf\u00c0\u0007\u0002\u0000\u0000\u00c0\u00c1\u0003,\u0016\u0000\u00c1"+
		"\u00cc\u0001\u0000\u0000\u0000\u00c2\u00c3\u00034\u001a\u0000\u00c3\u00c4"+
		"\u0005\u001f\u0000\u0000\u00c4\u00c5\u00034\u001a\u0000\u00c5\u00cc\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005$\u0000\u0000\u00c7\u00c8\u00030\u0018"+
		"\u0000\u00c8\u00c9\u0005%\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cc\u00032\u0019\u0000\u00cb\u00bb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00be\u0001\u0000\u0000\u0000\u00cb\u00c2\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c6\u0001\u0000\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc"+
		"\u00d8\u0001\u0000\u0000\u0000\u00cd\u00ce\n\u0007\u0000\u0000\u00ce\u00cf"+
		"\u0005\u001d\u0000\u0000\u00cf\u00d7\u00030\u0018\b\u00d0\u00d1\n\u0006"+
		"\u0000\u0000\u00d1\u00d2\u0005\u001e\u0000\u0000\u00d2\u00d7\u00030\u0018"+
		"\u0007\u00d3\u00d4\n\u0005\u0000\u0000\u00d4\u00d5\u0005\u001f\u0000\u0000"+
		"\u00d5\u00d7\u00030\u0018\u0006\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d7"+
		"\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d91\u0001\u0000\u0000\u0000\u00da\u00d8"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0007\u0003\u0000\u0000\u00dc3\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0007\u0004\u0000\u0000\u00de5\u0001\u0000"+
		"\u0000\u0000\u000e<CQ\u0085\u0089\u0092\u009c\u00a3\u00ae\u00b0\u00b9"+
		"\u00cb\u00d6\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}