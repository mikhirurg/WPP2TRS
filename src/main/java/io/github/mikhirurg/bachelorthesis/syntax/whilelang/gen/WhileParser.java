package io.github.mikhirurg.bachelorthesis.syntax.whilelang.gen;// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.12.0
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
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TYPE=21, INT_TYPE=22, BOOL_TYPE=23, STRING_TYPE=24, 
		INT=25, STRING=26, NOT=27, AND=28, OR=29, VAR=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_stm = 1, RULE_aexp = 2, RULE_multExpr = 3, RULE_atom = 4, 
		RULE_bexp = 5, RULE_strexpr = 6, RULE_expr = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stm", "aexp", "multExpr", "atom", "bexp", "strexpr", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'skip'", "';'", "'if'", "'then'", "'else'", "'while'", 
			"'do'", "'printInt'", "'('", "')'", "'printString'", "'printBool'", "'+'", 
			"'-'", "'*'", "'true'", "'false'", "'='", "'<='", null, "'int'", "'bool'", 
			"'string'", null, null, "'not'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TYPE", "INT_TYPE", 
			"BOOL_TYPE", "STRING_TYPE", "INT", "STRING", "NOT", "AND", "OR", "VAR", 
			"WS"
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
		public TerminalNode EOF() { return getToken(WhileParser.EOF, 0); }
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				stm(0);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1075852948L) != 0) );
			setState(21);
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
		public TerminalNode TYPE() { return getToken(WhileParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public StrexprContext strexpr() {
			return getRuleContext(StrexprContext.class,0);
		}
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitStm(this);
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
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(24);
				match(TYPE);
				setState(25);
				match(VAR);
				setState(26);
				match(T__0);
				setState(27);
				expr();
				}
				break;
			case VAR:
				{
				setState(28);
				match(VAR);
				setState(29);
				match(T__0);
				setState(30);
				expr();
				}
				break;
			case T__1:
				{
				setState(31);
				match(T__1);
				}
				break;
			case T__3:
				{
				setState(32);
				match(T__3);
				setState(33);
				bexp(0);
				setState(34);
				match(T__4);
				setState(35);
				stm(0);
				setState(36);
				match(T__5);
				setState(37);
				stm(6);
				}
				break;
			case T__6:
				{
				setState(39);
				match(T__6);
				setState(40);
				bexp(0);
				setState(41);
				match(T__7);
				setState(42);
				stm(5);
				}
				break;
			case T__8:
				{
				setState(44);
				match(T__8);
				setState(45);
				match(T__9);
				setState(46);
				aexp();
				setState(47);
				match(T__10);
				}
				break;
			case T__11:
				{
				setState(49);
				match(T__11);
				setState(50);
				match(T__9);
				setState(51);
				strexpr();
				setState(52);
				match(T__10);
				}
				break;
			case T__12:
				{
				setState(54);
				match(T__12);
				setState(55);
				match(T__9);
				setState(56);
				bexp(0);
				setState(57);
				match(T__10);
				}
				break;
			case T__9:
				{
				setState(59);
				match(T__9);
				setState(60);
				stm(0);
				setState(61);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stm);
					setState(65);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(66);
					match(T__2);
					setState(67);
					stm(8);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class AexpContext extends ParserRuleContext {
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitAexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		AexpContext _localctx = new AexpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aexp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			multExpr();
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(74);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(75);
					multExpr();
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class MultExprContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_multExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			atom();
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(82);
					match(T__15);
					setState(83);
					atom();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(WhileParser.INT, 0); }
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(INT);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(VAR);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(T__9);
				setState(92);
				aexp();
				setState(93);
				match(T__10);
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
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public List<StrexprContext> strexpr() {
			return getRuleContexts(StrexprContext.class);
		}
		public StrexprContext strexpr(int i) {
			return getRuleContext(StrexprContext.class,i);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitBexp(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_bexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(98);
				match(T__16);
				}
				break;
			case 2:
				{
				setState(99);
				match(T__17);
				}
				break;
			case 3:
				{
				setState(100);
				match(NOT);
				setState(101);
				match(T__9);
				setState(102);
				bexp(0);
				setState(103);
				match(T__10);
				}
				break;
			case 4:
				{
				setState(105);
				match(VAR);
				}
				break;
			case 5:
				{
				setState(106);
				aexp();
				setState(107);
				match(T__18);
				setState(108);
				aexp();
				}
				break;
			case 6:
				{
				setState(110);
				aexp();
				setState(111);
				match(T__19);
				setState(112);
				aexp();
				}
				break;
			case 7:
				{
				setState(114);
				strexpr();
				setState(115);
				match(T__18);
				setState(116);
				strexpr();
				}
				break;
			case 8:
				{
				setState(118);
				match(T__9);
				setState(119);
				bexp(0);
				setState(120);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						match(T__18);
						setState(126);
						bexp(6);
						}
						break;
					case 2:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(127);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(128);
						match(AND);
						setState(129);
						bexp(4);
						}
						break;
					case 3:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(131);
						match(OR);
						setState(132);
						bexp(3);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitStrexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrexprContext strexpr() throws RecognitionException {
		StrexprContext _localctx = new StrexprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_strexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public StrexprContext strexpr() {
			return getRuleContext(StrexprContext.class,0);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				strexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				aexp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return stm_sempred((StmContext)_localctx, predIndex);
		case 5:
			return bexp_sempred((BexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stm_sempred(StmContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean bexp_sempred(BexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0092\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0001\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001E\b\u0001"+
		"\n\u0001\f\u0001H\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"M\b\u0002\n\u0002\f\u0002P\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003U\b\u0003\n\u0003\f\u0003X\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004`\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005{\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0086\b\u0005\n\u0005\f\u0005\u0089\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0090\b\u0007\u0001"+
		"\u0007\u0000\u0002\u0002\n\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0002\u0001\u0000\u000e\u000f\u0002\u0000\u001a\u001a\u001e\u001e\u00a3"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004"+
		"I\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\b_\u0001\u0000"+
		"\u0000\u0000\nz\u0001\u0000\u0000\u0000\f\u008a\u0001\u0000\u0000\u0000"+
		"\u000e\u008f\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000"+
		"\u0011\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000"+
		"\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0000\u0000\u0001"+
		"\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u0018\u0006\u0001\uffff\uffff"+
		"\u0000\u0018\u0019\u0005\u0015\u0000\u0000\u0019\u001a\u0005\u001e\u0000"+
		"\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b@\u0003\u000e\u0007\u0000"+
		"\u001c\u001d\u0005\u001e\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000"+
		"\u001e@\u0003\u000e\u0007\u0000\u001f@\u0005\u0002\u0000\u0000 !\u0005"+
		"\u0004\u0000\u0000!\"\u0003\n\u0005\u0000\"#\u0005\u0005\u0000\u0000#"+
		"$\u0003\u0002\u0001\u0000$%\u0005\u0006\u0000\u0000%&\u0003\u0002\u0001"+
		"\u0006&@\u0001\u0000\u0000\u0000\'(\u0005\u0007\u0000\u0000()\u0003\n"+
		"\u0005\u0000)*\u0005\b\u0000\u0000*+\u0003\u0002\u0001\u0005+@\u0001\u0000"+
		"\u0000\u0000,-\u0005\t\u0000\u0000-.\u0005\n\u0000\u0000./\u0003\u0004"+
		"\u0002\u0000/0\u0005\u000b\u0000\u00000@\u0001\u0000\u0000\u000012\u0005"+
		"\f\u0000\u000023\u0005\n\u0000\u000034\u0003\f\u0006\u000045\u0005\u000b"+
		"\u0000\u00005@\u0001\u0000\u0000\u000067\u0005\r\u0000\u000078\u0005\n"+
		"\u0000\u000089\u0003\n\u0005\u00009:\u0005\u000b\u0000\u0000:@\u0001\u0000"+
		"\u0000\u0000;<\u0005\n\u0000\u0000<=\u0003\u0002\u0001\u0000=>\u0005\u000b"+
		"\u0000\u0000>@\u0001\u0000\u0000\u0000?\u0017\u0001\u0000\u0000\u0000"+
		"?\u001c\u0001\u0000\u0000\u0000?\u001f\u0001\u0000\u0000\u0000? \u0001"+
		"\u0000\u0000\u0000?\'\u0001\u0000\u0000\u0000?,\u0001\u0000\u0000\u0000"+
		"?1\u0001\u0000\u0000\u0000?6\u0001\u0000\u0000\u0000?;\u0001\u0000\u0000"+
		"\u0000@F\u0001\u0000\u0000\u0000AB\n\u0007\u0000\u0000BC\u0005\u0003\u0000"+
		"\u0000CE\u0003\u0002\u0001\bDA\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0003\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IN\u0003\u0006\u0003\u0000"+
		"JK\u0007\u0000\u0000\u0000KM\u0003\u0006\u0003\u0000LJ\u0001\u0000\u0000"+
		"\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000O\u0005\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"QV\u0003\b\u0004\u0000RS\u0005\u0010\u0000\u0000SU\u0003\b\u0004\u0000"+
		"TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000W\u0007\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000Y`\u0005\u0019\u0000\u0000Z`\u0005\u001e\u0000\u0000"+
		"[\\\u0005\n\u0000\u0000\\]\u0003\u0004\u0002\u0000]^\u0005\u000b\u0000"+
		"\u0000^`\u0001\u0000\u0000\u0000_Y\u0001\u0000\u0000\u0000_Z\u0001\u0000"+
		"\u0000\u0000_[\u0001\u0000\u0000\u0000`\t\u0001\u0000\u0000\u0000ab\u0006"+
		"\u0005\uffff\uffff\u0000b{\u0005\u0011\u0000\u0000c{\u0005\u0012\u0000"+
		"\u0000de\u0005\u001b\u0000\u0000ef\u0005\n\u0000\u0000fg\u0003\n\u0005"+
		"\u0000gh\u0005\u000b\u0000\u0000h{\u0001\u0000\u0000\u0000i{\u0005\u001e"+
		"\u0000\u0000jk\u0003\u0004\u0002\u0000kl\u0005\u0013\u0000\u0000lm\u0003"+
		"\u0004\u0002\u0000m{\u0001\u0000\u0000\u0000no\u0003\u0004\u0002\u0000"+
		"op\u0005\u0014\u0000\u0000pq\u0003\u0004\u0002\u0000q{\u0001\u0000\u0000"+
		"\u0000rs\u0003\f\u0006\u0000st\u0005\u0013\u0000\u0000tu\u0003\f\u0006"+
		"\u0000u{\u0001\u0000\u0000\u0000vw\u0005\n\u0000\u0000wx\u0003\n\u0005"+
		"\u0000xy\u0005\u000b\u0000\u0000y{\u0001\u0000\u0000\u0000za\u0001\u0000"+
		"\u0000\u0000zc\u0001\u0000\u0000\u0000zd\u0001\u0000\u0000\u0000zi\u0001"+
		"\u0000\u0000\u0000zj\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000\u0000"+
		"zr\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000\u0000{\u0087\u0001\u0000"+
		"\u0000\u0000|}\n\u0005\u0000\u0000}~\u0005\u0013\u0000\u0000~\u0086\u0003"+
		"\n\u0005\u0006\u007f\u0080\n\u0003\u0000\u0000\u0080\u0081\u0005\u001c"+
		"\u0000\u0000\u0081\u0086\u0003\n\u0005\u0004\u0082\u0083\n\u0002\u0000"+
		"\u0000\u0083\u0084\u0005\u001d\u0000\u0000\u0084\u0086\u0003\n\u0005\u0003"+
		"\u0085|\u0001\u0000\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000\u0085"+
		"\u0082\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u000b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0007\u0001\u0000\u0000\u008b\r\u0001\u0000\u0000\u0000\u008c\u0090"+
		"\u0003\f\u0006\u0000\u008d\u0090\u0003\u0004\u0002\u0000\u008e\u0090\u0003"+
		"\n\u0005\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u000f\u0001\u0000"+
		"\u0000\u0000\n\u0013?FNV_z\u0085\u0087\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}