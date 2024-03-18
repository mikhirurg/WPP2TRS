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
		WHILE=12, DO=13, SEMICOLON=14, INT_TYPE=15, BOOL_TYPE=16, STRING_TYPE=17, 
		PLUS=18, MINUS=19, MULT=20, DIV=21, MOD=22, INT=23, STRING=24, TRUE=25, 
		FALSE=26, NOT=27, AND=28, OR=29, EQ=30, LT=31, GT=32, LE=33, GE=34, LPAREN=35, 
		RPAREN=36, BLOCKCOMMENT=37, VAR=38, WS=39;
	public static final int
		RULE_prog = 0, RULE_stm = 1, RULE_nestedStm = 2, RULE_condition = 3, RULE_unaryStm = 4, 
		RULE_skipStm = 5, RULE_printIntStm = 6, RULE_printStringStm = 7, RULE_printBoolStm = 8, 
		RULE_readIntStm = 9, RULE_readStringStm = 10, RULE_readBoolStm = 11, RULE_ifStm = 12, 
		RULE_whileStm = 13, RULE_blockStm = 14, RULE_declareStm = 15, RULE_assignStm = 16, 
		RULE_expr = 17, RULE_untypedexpr = 18, RULE_typedexpr = 19, RULE_aexp = 20, 
		RULE_aexpatom = 21, RULE_bexp = 22, RULE_bexpatom = 23, RULE_strexpr = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stm", "nestedStm", "condition", "unaryStm", "skipStm", "printIntStm", 
			"printStringStm", "printBoolStm", "readIntStm", "readStringStm", "readBoolStm", 
			"ifStm", "whileStm", "blockStm", "declareStm", "assignStm", "expr", "untypedexpr", 
			"typedexpr", "aexp", "aexpatom", "bexp", "bexpatom", "strexpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'skip'", "'printInt'", "'printString'", "'printBool'", 
			"'readInt'", "'readString'", "'readBool'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "';'", "'int'", "'bool'", "'string'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", null, null, "'true'", "'false'", "'not'", "'and'", 
			"'or'", "'='", "'<'", "'>'", "'<='", "'>='", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "SKIP_STM", "PRINT_INT_STM", "PRINT_STRING_STM", "PRINT_BOOL_STM", 
			"READ_INT_STM", "READ_STRING_STM", "READ_BOOL_STM", "IF", "THEN", "ELSE", 
			"WHILE", "DO", "SEMICOLON", "INT_TYPE", "BOOL_TYPE", "STRING_TYPE", "PLUS", 
			"MINUS", "MULT", "DIV", "MOD", "INT", "STRING", "TRUE", "FALSE", "NOT", 
			"AND", "OR", "EQ", "LT", "GT", "LE", "GE", "LPAREN", "RPAREN", "BLOCKCOMMENT", 
			"VAR", "WS"
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
			setState(50);
			stm(0);
			setState(51);
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
			setState(56);
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
			case INT_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case VAR:
				{
				setState(54);
				unaryStm();
				}
				break;
			case LPAREN:
				{
				setState(55);
				blockStm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
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
					setState(58);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(59);
					match(SEMICOLON);
					setState(60);
					stm(2);
					}
					} 
				}
				setState(65);
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
	public static class NestedStmContext extends ParserRuleContext {
		public UnaryStmContext unaryStm() {
			return getRuleContext(UnaryStmContext.class,0);
		}
		public BlockStmContext blockStm() {
			return getRuleContext(BlockStmContext.class,0);
		}
		public NestedStmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedStm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterNestedStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitNestedStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitNestedStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedStmContext nestedStm() throws RecognitionException {
		NestedStmContext _localctx = new NestedStmContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nestedStm);
		try {
			setState(68);
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
			case INT_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				unaryStm();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
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
		enterRule(_localctx, 6, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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
	public static class UnaryStmContext extends ParserRuleContext {
		public SkipStmContext skipStm() {
			return getRuleContext(SkipStmContext.class,0);
		}
		public DeclareStmContext declareStm() {
			return getRuleContext(DeclareStmContext.class,0);
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
		public AssignStmContext assignStm() {
			return getRuleContext(AssignStmContext.class,0);
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
		enterRule(_localctx, 8, RULE_unaryStm);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STM:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				skipStm();
				}
				break;
			case INT_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				declareStm();
				}
				break;
			case PRINT_INT_STM:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				printIntStm();
				}
				break;
			case PRINT_STRING_STM:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				printStringStm();
				}
				break;
			case PRINT_BOOL_STM:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				printBoolStm();
				}
				break;
			case READ_INT_STM:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				readIntStm();
				}
				break;
			case READ_STRING_STM:
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				readStringStm();
				}
				break;
			case READ_BOOL_STM:
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				readBoolStm();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 9);
				{
				setState(80);
				ifStm();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 10);
				{
				setState(81);
				whileStm();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 11);
				{
				setState(82);
				assignStm();
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
			setState(85);
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
			setState(87);
			match(PRINT_INT_STM);
			setState(88);
			match(LPAREN);
			setState(89);
			aexp(0);
			setState(90);
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
			setState(92);
			match(PRINT_STRING_STM);
			setState(93);
			match(LPAREN);
			setState(94);
			strexpr();
			setState(95);
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
			setState(97);
			match(PRINT_BOOL_STM);
			setState(98);
			match(LPAREN);
			setState(99);
			bexp(0);
			setState(100);
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
			setState(102);
			match(READ_INT_STM);
			setState(103);
			match(LPAREN);
			setState(104);
			match(VAR);
			setState(105);
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
			setState(107);
			match(READ_STRING_STM);
			setState(108);
			match(LPAREN);
			setState(109);
			match(VAR);
			setState(110);
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
			setState(112);
			match(READ_BOOL_STM);
			setState(113);
			match(LPAREN);
			setState(114);
			match(VAR);
			setState(115);
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
		public List<NestedStmContext> nestedStm() {
			return getRuleContexts(NestedStmContext.class);
		}
		public NestedStmContext nestedStm(int i) {
			return getRuleContext(NestedStmContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(WhileParser.ELSE, 0); }
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
			setState(117);
			match(IF);
			setState(118);
			condition();
			setState(119);
			match(THEN);
			setState(120);
			nestedStm();
			setState(121);
			match(ELSE);
			setState(122);
			nestedStm();
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
		public NestedStmContext nestedStm() {
			return getRuleContext(NestedStmContext.class,0);
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
		enterRule(_localctx, 26, RULE_whileStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(WHILE);
			setState(125);
			condition();
			setState(126);
			match(DO);
			setState(127);
			nestedStm();
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
		enterRule(_localctx, 28, RULE_blockStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(LPAREN);
			setState(130);
			stm(0);
			setState(131);
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
	public static class DeclareStmContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(WhileParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INT_TYPE() { return getToken(WhileParser.INT_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(WhileParser.BOOL_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(WhileParser.STRING_TYPE, 0); }
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
		enterRule(_localctx, 30, RULE_declareStm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(134);
			match(VAR);
			setState(135);
			match(ASSIGN);
			setState(136);
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
		enterRule(_localctx, 32, RULE_assignStm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(VAR);
			setState(139);
			match(ASSIGN);
			setState(140);
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
		enterRule(_localctx, 34, RULE_expr);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				untypedexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
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
		enterRule(_localctx, 36, RULE_untypedexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
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
		enterRule(_localctx, 38, RULE_typedexpr);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				strexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				aexp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_aexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			aexpatom();
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(162);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(156);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(157);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(158);
						aexp(4);
						}
						break;
					case 2:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(159);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(160);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						aexp(3);
						}
						break;
					}
					} 
				}
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 42, RULE_aexpatom);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(LPAREN);
				setState(168);
				aexp(0);
				setState(169);
				match(RPAREN);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(INT);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_bexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(176);
				match(NOT);
				setState(177);
				bexp(8);
				}
				break;
			case 2:
				{
				setState(178);
				aexp(0);
				setState(179);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33285996544L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(180);
				aexp(0);
				}
				break;
			case 3:
				{
				setState(182);
				strexpr();
				setState(183);
				match(EQ);
				setState(184);
				strexpr();
				}
				break;
			case 4:
				{
				setState(186);
				match(LPAREN);
				setState(187);
				bexp(0);
				setState(188);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(190);
				bexpatom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(193);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(194);
						match(AND);
						setState(195);
						bexp(8);
						}
						break;
					case 2:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(197);
						match(OR);
						setState(198);
						bexp(7);
						}
						break;
					case 3:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(199);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(200);
						match(EQ);
						setState(201);
						bexp(6);
						}
						break;
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 46, RULE_bexpatom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 274978570240L) != 0)) ) {
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
		enterRule(_localctx, 48, RULE_strexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
		case 20:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 22:
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
		"\u0004\u0001\'\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00019\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		">\b\u0001\n\u0001\f\u0001A\t\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004T\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0091\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0098\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u00a3\b\u0014\n\u0014\f\u0014\u00a6\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00ae"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00c0"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00cb\b\u0016\n"+
		"\u0016\f\u0016\u00ce\t\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0000\u0003\u0002(,\u0019\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000"+
		"\u0006\u0001\u0000\u000f\u0011\u0001\u0000\u0014\u0016\u0001\u0000\u0012"+
		"\u0013\u0001\u0000\u001e\"\u0002\u0000\u0019\u001a&&\u0002\u0000\u0018"+
		"\u0018&&\u00d5\u00002\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000"+
		"\u0000\u0004D\u0001\u0000\u0000\u0000\u0006F\u0001\u0000\u0000\u0000\b"+
		"S\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000\fW\u0001\u0000\u0000"+
		"\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010a\u0001\u0000\u0000\u0000"+
		"\u0012f\u0001\u0000\u0000\u0000\u0014k\u0001\u0000\u0000\u0000\u0016p"+
		"\u0001\u0000\u0000\u0000\u0018u\u0001\u0000\u0000\u0000\u001a|\u0001\u0000"+
		"\u0000\u0000\u001c\u0081\u0001\u0000\u0000\u0000\u001e\u0085\u0001\u0000"+
		"\u0000\u0000 \u008a\u0001\u0000\u0000\u0000\"\u0090\u0001\u0000\u0000"+
		"\u0000$\u0092\u0001\u0000\u0000\u0000&\u0097\u0001\u0000\u0000\u0000("+
		"\u0099\u0001\u0000\u0000\u0000*\u00ad\u0001\u0000\u0000\u0000,\u00bf\u0001"+
		"\u0000\u0000\u0000.\u00cf\u0001\u0000\u0000\u00000\u00d1\u0001\u0000\u0000"+
		"\u000023\u0003\u0002\u0001\u000034\u0005\u0000\u0000\u00014\u0001\u0001"+
		"\u0000\u0000\u000056\u0006\u0001\uffff\uffff\u000069\u0003\b\u0004\u0000"+
		"79\u0003\u001c\u000e\u000085\u0001\u0000\u0000\u000087\u0001\u0000\u0000"+
		"\u00009?\u0001\u0000\u0000\u0000:;\n\u0001\u0000\u0000;<\u0005\u000e\u0000"+
		"\u0000<>\u0003\u0002\u0001\u0002=:\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0003"+
		"\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BE\u0003\b\u0004\u0000"+
		"CE\u0003\u001c\u000e\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000"+
		"\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0003,\u0016\u0000G\u0007\u0001"+
		"\u0000\u0000\u0000HT\u0003\n\u0005\u0000IT\u0003\u001e\u000f\u0000JT\u0003"+
		"\f\u0006\u0000KT\u0003\u000e\u0007\u0000LT\u0003\u0010\b\u0000MT\u0003"+
		"\u0012\t\u0000NT\u0003\u0014\n\u0000OT\u0003\u0016\u000b\u0000PT\u0003"+
		"\u0018\f\u0000QT\u0003\u001a\r\u0000RT\u0003 \u0010\u0000SH\u0001\u0000"+
		"\u0000\u0000SI\u0001\u0000\u0000\u0000SJ\u0001\u0000\u0000\u0000SK\u0001"+
		"\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000"+
		"SN\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\t\u0001\u0000"+
		"\u0000\u0000UV\u0005\u0002\u0000\u0000V\u000b\u0001\u0000\u0000\u0000"+
		"WX\u0005\u0003\u0000\u0000XY\u0005#\u0000\u0000YZ\u0003(\u0014\u0000Z"+
		"[\u0005$\u0000\u0000[\r\u0001\u0000\u0000\u0000\\]\u0005\u0004\u0000\u0000"+
		"]^\u0005#\u0000\u0000^_\u00030\u0018\u0000_`\u0005$\u0000\u0000`\u000f"+
		"\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000\u0000bc\u0005#\u0000\u0000"+
		"cd\u0003,\u0016\u0000de\u0005$\u0000\u0000e\u0011\u0001\u0000\u0000\u0000"+
		"fg\u0005\u0006\u0000\u0000gh\u0005#\u0000\u0000hi\u0005&\u0000\u0000i"+
		"j\u0005$\u0000\u0000j\u0013\u0001\u0000\u0000\u0000kl\u0005\u0007\u0000"+
		"\u0000lm\u0005#\u0000\u0000mn\u0005&\u0000\u0000no\u0005$\u0000\u0000"+
		"o\u0015\u0001\u0000\u0000\u0000pq\u0005\b\u0000\u0000qr\u0005#\u0000\u0000"+
		"rs\u0005&\u0000\u0000st\u0005$\u0000\u0000t\u0017\u0001\u0000\u0000\u0000"+
		"uv\u0005\t\u0000\u0000vw\u0003\u0006\u0003\u0000wx\u0005\n\u0000\u0000"+
		"xy\u0003\u0004\u0002\u0000yz\u0005\u000b\u0000\u0000z{\u0003\u0004\u0002"+
		"\u0000{\u0019\u0001\u0000\u0000\u0000|}\u0005\f\u0000\u0000}~\u0003\u0006"+
		"\u0003\u0000~\u007f\u0005\r\u0000\u0000\u007f\u0080\u0003\u0004\u0002"+
		"\u0000\u0080\u001b\u0001\u0000\u0000\u0000\u0081\u0082\u0005#\u0000\u0000"+
		"\u0082\u0083\u0003\u0002\u0001\u0000\u0083\u0084\u0005$\u0000\u0000\u0084"+
		"\u001d\u0001\u0000\u0000\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086"+
		"\u0087\u0005&\u0000\u0000\u0087\u0088\u0005\u0001\u0000\u0000\u0088\u0089"+
		"\u0003\"\u0011\u0000\u0089\u001f\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"&\u0000\u0000\u008b\u008c\u0005\u0001\u0000\u0000\u008c\u008d\u0003\""+
		"\u0011\u0000\u008d!\u0001\u0000\u0000\u0000\u008e\u0091\u0003$\u0012\u0000"+
		"\u008f\u0091\u0003&\u0013\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090"+
		"\u008f\u0001\u0000\u0000\u0000\u0091#\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005&\u0000\u0000\u0093%\u0001\u0000\u0000\u0000\u0094\u0098\u00030"+
		"\u0018\u0000\u0095\u0098\u0003(\u0014\u0000\u0096\u0098\u0003,\u0016\u0000"+
		"\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\'\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0006\u0014\uffff\uffff\u0000\u009a\u009b\u0003*\u0015\u0000\u009b"+
		"\u00a4\u0001\u0000\u0000\u0000\u009c\u009d\n\u0003\u0000\u0000\u009d\u009e"+
		"\u0007\u0001\u0000\u0000\u009e\u00a3\u0003(\u0014\u0004\u009f\u00a0\n"+
		"\u0002\u0000\u0000\u00a0\u00a1\u0007\u0002\u0000\u0000\u00a1\u00a3\u0003"+
		"(\u0014\u0003\u00a2\u009c\u0001\u0000\u0000\u0000\u00a2\u009f\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5)\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005#\u0000\u0000"+
		"\u00a8\u00a9\u0003(\u0014\u0000\u00a9\u00aa\u0005$\u0000\u0000\u00aa\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ae\u0005\u0017\u0000\u0000\u00ac\u00ae"+
		"\u0005&\u0000\u0000\u00ad\u00a7\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae+\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0006\u0016\uffff\uffff\u0000\u00b0\u00b1\u0005"+
		"\u001b\u0000\u0000\u00b1\u00c0\u0003,\u0016\b\u00b2\u00b3\u0003(\u0014"+
		"\u0000\u00b3\u00b4\u0007\u0003\u0000\u0000\u00b4\u00b5\u0003(\u0014\u0000"+
		"\u00b5\u00c0\u0001\u0000\u0000\u0000\u00b6\u00b7\u00030\u0018\u0000\u00b7"+
		"\u00b8\u0005\u001e\u0000\u0000\u00b8\u00b9\u00030\u0018\u0000\u00b9\u00c0"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005#\u0000\u0000\u00bb\u00bc\u0003"+
		",\u0016\u0000\u00bc\u00bd\u0005$\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000"+
		"\u0000\u00be\u00c0\u0003.\u0017\u0000\u00bf\u00af\u0001\u0000\u0000\u0000"+
		"\u00bf\u00b2\u0001\u0000\u0000\u0000\u00bf\u00b6\u0001\u0000\u0000\u0000"+
		"\u00bf\u00ba\u0001\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000"+
		"\u00c0\u00cc\u0001\u0000\u0000\u0000\u00c1\u00c2\n\u0007\u0000\u0000\u00c2"+
		"\u00c3\u0005\u001c\u0000\u0000\u00c3\u00cb\u0003,\u0016\b\u00c4\u00c5"+
		"\n\u0006\u0000\u0000\u00c5\u00c6\u0005\u001d\u0000\u0000\u00c6\u00cb\u0003"+
		",\u0016\u0007\u00c7\u00c8\n\u0005\u0000\u0000\u00c8\u00c9\u0005\u001e"+
		"\u0000\u0000\u00c9\u00cb\u0003,\u0016\u0006\u00ca\u00c1\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c4\u0001\u0000\u0000\u0000\u00ca\u00c7\u0001\u0000\u0000"+
		"\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd-\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0007\u0004\u0000\u0000"+
		"\u00d0/\u0001\u0000\u0000\u0000\u00d1\u00d2\u0007\u0005\u0000\u0000\u00d2"+
		"1\u0001\u0000\u0000\u0000\f8?DS\u0090\u0097\u00a2\u00a4\u00ad\u00bf\u00ca"+
		"\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}