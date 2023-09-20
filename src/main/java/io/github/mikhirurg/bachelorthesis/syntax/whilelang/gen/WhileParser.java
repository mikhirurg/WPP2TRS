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
		T__17=18, T__18=19, TYPE=20, INT_TYPE=21, BOOL_TYPE=22, STRING_TYPE=23, 
		VAR=24, INT=25, NOT=26, AND=27, OR=28, WS=29;
	public static final int
		RULE_prog = 0, RULE_stm = 1, RULE_aexp = 2, RULE_multExpr = 3, RULE_atom = 4, 
		RULE_bexp = 5, RULE_strexp = 6, RULE_expr = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stm", "aexp", "multExpr", "atom", "bexp", "strexp", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'skip'", "';'", "'if'", "'then'", "'else'", "'while'", 
			"'do'", "'print('", "')'", "'('", "'+'", "'-'", "'*'", "'true'", "'false'", 
			"'='", "'<='", "'\"'", null, "'int'", "'bool'", "'string'", null, null, 
			"'not'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "TYPE", "INT_TYPE", "BOOL_TYPE", 
			"STRING_TYPE", "VAR", "INT", "NOT", "AND", "OR", "WS"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17828500L) != 0) );
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
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(22);
				match(TYPE);
				setState(23);
				match(VAR);
				setState(24);
				match(T__0);
				setState(25);
				expr();
				}
				break;
			case VAR:
				{
				setState(26);
				match(VAR);
				setState(27);
				match(T__0);
				setState(28);
				expr();
				}
				break;
			case T__1:
				{
				setState(29);
				match(T__1);
				}
				break;
			case T__3:
				{
				setState(30);
				match(T__3);
				setState(31);
				bexp(0);
				setState(32);
				match(T__4);
				setState(33);
				stm(0);
				setState(34);
				match(T__5);
				setState(35);
				stm(4);
				}
				break;
			case T__6:
				{
				setState(37);
				match(T__6);
				setState(38);
				bexp(0);
				setState(39);
				match(T__7);
				setState(40);
				stm(3);
				}
				break;
			case T__8:
				{
				setState(42);
				match(T__8);
				setState(43);
				expr();
				setState(44);
				match(T__9);
				}
				break;
			case T__10:
				{
				setState(46);
				match(T__10);
				setState(47);
				stm(0);
				setState(48);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(57);
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
					setState(52);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(53);
					match(T__2);
					setState(54);
					stm(6);
					}
					} 
				}
				setState(59);
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
			setState(60);
			multExpr();
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					_la = _input.LA(1);
					if ( !(_la==T__11 || _la==T__12) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(62);
					multExpr();
					}
					} 
				}
				setState(67);
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
			setState(68);
			atom();
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					match(T__13);
					setState(70);
					atom();
					}
					} 
				}
				setState(75);
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(INT);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(VAR);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(T__10);
				setState(79);
				aexp();
				setState(80);
				match(T__9);
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
		public TerminalNode VAR() { return getToken(WhileParser.VAR, 0); }
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public List<StrexpContext> strexp() {
			return getRuleContexts(StrexpContext.class);
		}
		public StrexpContext strexp(int i) {
			return getRuleContext(StrexpContext.class,i);
		}
		public TerminalNode NOT() { return getToken(WhileParser.NOT, 0); }
		public List<BexpContext> bexp() {
			return getRuleContexts(BexpContext.class);
		}
		public BexpContext bexp(int i) {
			return getRuleContext(BexpContext.class,i);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(85);
				match(T__14);
				}
				break;
			case 2:
				{
				setState(86);
				match(T__15);
				}
				break;
			case 3:
				{
				setState(87);
				match(VAR);
				}
				break;
			case 4:
				{
				setState(88);
				aexp();
				setState(89);
				match(T__16);
				setState(90);
				aexp();
				}
				break;
			case 5:
				{
				setState(92);
				aexp();
				setState(93);
				match(T__17);
				setState(94);
				aexp();
				}
				break;
			case 6:
				{
				setState(96);
				strexp();
				setState(97);
				match(T__16);
				setState(98);
				strexp();
				}
				break;
			case 7:
				{
				setState(100);
				match(NOT);
				setState(101);
				match(T__10);
				setState(102);
				bexp(0);
				setState(103);
				match(T__9);
				}
				break;
			case 8:
				{
				setState(105);
				match(T__10);
				setState(106);
				bexp(0);
				setState(107);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(111);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(112);
						match(T__16);
						setState(113);
						bexp(7);
						}
						break;
					case 2:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(114);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(115);
						match(AND);
						setState(116);
						bexp(4);
						}
						break;
					case 3:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(117);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(118);
						match(OR);
						setState(119);
						bexp(3);
						}
						break;
					}
					} 
				}
				setState(124);
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
	public static class StrexpContext extends ParserRuleContext {
		public StrexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).enterStrexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileListener ) ((WhileListener)listener).exitStrexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitStrexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrexpContext strexp() throws RecognitionException {
		StrexpContext _localctx = new StrexpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_strexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__18);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__18) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1073217534L) != 0) );
			setState(131);
			match(T__18);
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
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public StrexpContext strexp() {
			return getRuleContext(StrexpContext.class,0);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				aexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				bexp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				strexp();
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
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean bexp_sempred(BexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u008b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0001\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00013\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00018\b\u0001\n\u0001"+
		"\f\u0001;\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002@\b\u0002"+
		"\n\u0002\f\u0002C\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"H\b\u0003\n\u0003\f\u0003K\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004S\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005n\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"y\b\u0005\n\u0005\f\u0005|\t\u0005\u0001\u0006\u0001\u0006\u0004\u0006"+
		"\u0080\b\u0006\u000b\u0006\f\u0006\u0081\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0089\b\u0007\u0001\u0007\u0000"+
		"\u0002\u0002\n\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0002\u0001"+
		"\u0000\f\r\u0001\u0000\u0013\u0013\u009b\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u00022\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006"+
		"D\u0001\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\nm\u0001\u0000\u0000"+
		"\u0000\f}\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000\u0000\u0000"+
		"\u0010\u0012\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000"+
		"\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0006\u0001\uffff\uffff\u0000\u0016\u0017\u0005\u0014\u0000"+
		"\u0000\u0017\u0018\u0005\u0018\u0000\u0000\u0018\u0019\u0005\u0001\u0000"+
		"\u0000\u00193\u0003\u000e\u0007\u0000\u001a\u001b\u0005\u0018\u0000\u0000"+
		"\u001b\u001c\u0005\u0001\u0000\u0000\u001c3\u0003\u000e\u0007\u0000\u001d"+
		"3\u0005\u0002\u0000\u0000\u001e\u001f\u0005\u0004\u0000\u0000\u001f \u0003"+
		"\n\u0005\u0000 !\u0005\u0005\u0000\u0000!\"\u0003\u0002\u0001\u0000\""+
		"#\u0005\u0006\u0000\u0000#$\u0003\u0002\u0001\u0004$3\u0001\u0000\u0000"+
		"\u0000%&\u0005\u0007\u0000\u0000&\'\u0003\n\u0005\u0000\'(\u0005\b\u0000"+
		"\u0000()\u0003\u0002\u0001\u0003)3\u0001\u0000\u0000\u0000*+\u0005\t\u0000"+
		"\u0000+,\u0003\u000e\u0007\u0000,-\u0005\n\u0000\u0000-3\u0001\u0000\u0000"+
		"\u0000./\u0005\u000b\u0000\u0000/0\u0003\u0002\u0001\u000001\u0005\n\u0000"+
		"\u000013\u0001\u0000\u0000\u00002\u0015\u0001\u0000\u0000\u00002\u001a"+
		"\u0001\u0000\u0000\u00002\u001d\u0001\u0000\u0000\u00002\u001e\u0001\u0000"+
		"\u0000\u00002%\u0001\u0000\u0000\u00002*\u0001\u0000\u0000\u00002.\u0001"+
		"\u0000\u0000\u000039\u0001\u0000\u0000\u000045\n\u0005\u0000\u000056\u0005"+
		"\u0003\u0000\u000068\u0003\u0002\u0001\u000674\u0001\u0000\u0000\u0000"+
		"8;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:\u0003\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<A\u0003"+
		"\u0006\u0003\u0000=>\u0007\u0000\u0000\u0000>@\u0003\u0006\u0003\u0000"+
		"?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000B\u0005\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000DI\u0003\b\u0004\u0000EF\u0005\u000e\u0000\u0000FH\u0003"+
		"\b\u0004\u0000GE\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0007\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LS\u0005\u0019\u0000\u0000MS\u0005\u0018"+
		"\u0000\u0000NO\u0005\u000b\u0000\u0000OP\u0003\u0004\u0002\u0000PQ\u0005"+
		"\n\u0000\u0000QS\u0001\u0000\u0000\u0000RL\u0001\u0000\u0000\u0000RM\u0001"+
		"\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000S\t\u0001\u0000\u0000\u0000"+
		"TU\u0006\u0005\uffff\uffff\u0000Un\u0005\u000f\u0000\u0000Vn\u0005\u0010"+
		"\u0000\u0000Wn\u0005\u0018\u0000\u0000XY\u0003\u0004\u0002\u0000YZ\u0005"+
		"\u0011\u0000\u0000Z[\u0003\u0004\u0002\u0000[n\u0001\u0000\u0000\u0000"+
		"\\]\u0003\u0004\u0002\u0000]^\u0005\u0012\u0000\u0000^_\u0003\u0004\u0002"+
		"\u0000_n\u0001\u0000\u0000\u0000`a\u0003\f\u0006\u0000ab\u0005\u0011\u0000"+
		"\u0000bc\u0003\f\u0006\u0000cn\u0001\u0000\u0000\u0000de\u0005\u001a\u0000"+
		"\u0000ef\u0005\u000b\u0000\u0000fg\u0003\n\u0005\u0000gh\u0005\n\u0000"+
		"\u0000hn\u0001\u0000\u0000\u0000ij\u0005\u000b\u0000\u0000jk\u0003\n\u0005"+
		"\u0000kl\u0005\n\u0000\u0000ln\u0001\u0000\u0000\u0000mT\u0001\u0000\u0000"+
		"\u0000mV\u0001\u0000\u0000\u0000mW\u0001\u0000\u0000\u0000mX\u0001\u0000"+
		"\u0000\u0000m\\\u0001\u0000\u0000\u0000m`\u0001\u0000\u0000\u0000md\u0001"+
		"\u0000\u0000\u0000mi\u0001\u0000\u0000\u0000nz\u0001\u0000\u0000\u0000"+
		"op\n\u0006\u0000\u0000pq\u0005\u0011\u0000\u0000qy\u0003\n\u0005\u0007"+
		"rs\n\u0003\u0000\u0000st\u0005\u001b\u0000\u0000ty\u0003\n\u0005\u0004"+
		"uv\n\u0002\u0000\u0000vw\u0005\u001c\u0000\u0000wy\u0003\n\u0005\u0003"+
		"xo\u0001\u0000\u0000\u0000xr\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000"+
		"\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{\u000b\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"}\u007f\u0005\u0013\u0000\u0000~\u0080\b\u0001\u0000\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005\u0013\u0000\u0000\u0084\r\u0001\u0000"+
		"\u0000\u0000\u0085\u0089\u0003\u0004\u0002\u0000\u0086\u0089\u0003\n\u0005"+
		"\u0000\u0087\u0089\u0003\f\u0006\u0000\u0088\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u000f\u0001\u0000\u0000\u0000\u000b\u001329AIRmxz\u0081\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}