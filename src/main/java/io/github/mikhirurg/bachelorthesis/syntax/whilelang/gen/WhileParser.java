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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TYPE=21, INT_TYPE=22, BOOL_TYPE=23, STRING_TYPE=24, 
		INT=25, STRING=26, PLUS=27, MINUS=28, MULT=29, DIV=30, MOD=31, NOT=32, 
		AND=33, OR=34, VAR=35, WS=36;
	public static final int
		RULE_prog = 0, RULE_stm = 1, RULE_branchOne = 2, RULE_branchTwo = 3, RULE_aexp = 4, 
		RULE_atom = 5, RULE_bexp = 6, RULE_strexpr = 7, RULE_expr = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stm", "branchOne", "branchTwo", "aexp", "atom", "bexp", "strexpr", 
			"expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':='", "'skip'", "'printInt'", "'('", "')'", "'printString'", 
			"'printBool'", "'readInt'", "'readString'", "'readBool'", "'if'", "'then'", 
			"'else'", "'while'", "'do'", "';'", "'true'", "'false'", "'='", "'<='", 
			null, "'int'", "'bool'", "'string'", null, null, "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'not'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TYPE", "INT_TYPE", 
			"BOOL_TYPE", "STRING_TYPE", "INT", "STRING", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "NOT", "AND", "OR", "VAR", "WS"
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
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				stm(0);
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34361855964L) != 0) );
			setState(23);
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
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public StrexprContext strexpr() {
			return getRuleContext(StrexprContext.class,0);
		}
		public BexpContext bexp() {
			return getRuleContext(BexpContext.class,0);
		}
		public BranchOneContext branchOne() {
			return getRuleContext(BranchOneContext.class,0);
		}
		public BranchTwoContext branchTwo() {
			return getRuleContext(BranchTwoContext.class,0);
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(26);
				match(TYPE);
				setState(27);
				match(VAR);
				setState(28);
				match(T__0);
				setState(29);
				expr();
				}
				break;
			case VAR:
				{
				setState(30);
				match(VAR);
				setState(31);
				match(T__0);
				setState(32);
				expr();
				}
				break;
			case T__1:
				{
				setState(33);
				match(T__1);
				}
				break;
			case T__2:
				{
				setState(34);
				match(T__2);
				setState(35);
				match(T__3);
				setState(36);
				aexp(0);
				setState(37);
				match(T__4);
				}
				break;
			case T__5:
				{
				setState(39);
				match(T__5);
				setState(40);
				match(T__3);
				setState(41);
				strexpr();
				setState(42);
				match(T__4);
				}
				break;
			case T__6:
				{
				setState(44);
				match(T__6);
				setState(45);
				match(T__3);
				setState(46);
				bexp(0);
				setState(47);
				match(T__4);
				}
				break;
			case T__7:
				{
				setState(49);
				match(T__7);
				setState(50);
				match(T__3);
				setState(51);
				match(VAR);
				setState(52);
				match(T__4);
				}
				break;
			case T__8:
				{
				setState(53);
				match(T__8);
				setState(54);
				match(T__3);
				setState(55);
				match(VAR);
				setState(56);
				match(T__4);
				}
				break;
			case T__9:
				{
				setState(57);
				match(T__9);
				setState(58);
				match(T__3);
				setState(59);
				match(VAR);
				setState(60);
				match(T__4);
				}
				break;
			case T__10:
				{
				setState(61);
				match(T__10);
				setState(62);
				bexp(0);
				setState(63);
				match(T__11);
				setState(64);
				branchOne();
				setState(65);
				match(T__12);
				setState(66);
				branchTwo();
				}
				break;
			case T__13:
				{
				setState(68);
				match(T__13);
				setState(69);
				bexp(0);
				setState(70);
				match(T__14);
				setState(71);
				stm(3);
				}
				break;
			case T__3:
				{
				setState(73);
				match(T__3);
				setState(74);
				stm(0);
				setState(75);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
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
					setState(79);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(80);
					match(T__15);
					setState(81);
					stm(2);
					}
					} 
				}
				setState(86);
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
	public static class BranchOneContext extends ParserRuleContext {
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitBranchOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchOneContext branchOne() throws RecognitionException {
		BranchOneContext _localctx = new BranchOneContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_branchOne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__3);
			setState(88);
			stm(0);
			setState(89);
			match(T__4);
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
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitBranchTwo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchTwoContext branchTwo() throws RecognitionException {
		BranchTwoContext _localctx = new BranchTwoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_branchTwo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__3);
			setState(92);
			stm(0);
			setState(93);
			match(T__4);
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
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
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
			if ( visitor instanceof WhileVisitor) return ((WhileVisitor<? extends T>)visitor).visitAexp(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_aexp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(96);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(104);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(98);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(99);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3758096384L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						aexp(4);
						}
						break;
					case 2:
						{
						_localctx = new AexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(101);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(102);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						aexp(3);
						}
						break;
					}
					} 
				}
				setState(108);
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
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(INT);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(VAR);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__3);
				setState(112);
				aexp(0);
				setState(113);
				match(T__4);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_bexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(118);
				match(T__16);
				}
				break;
			case 2:
				{
				setState(119);
				match(T__17);
				}
				break;
			case 3:
				{
				setState(120);
				match(NOT);
				setState(121);
				match(T__3);
				setState(122);
				bexp(0);
				setState(123);
				match(T__4);
				}
				break;
			case 4:
				{
				setState(125);
				match(VAR);
				}
				break;
			case 5:
				{
				setState(126);
				aexp(0);
				setState(127);
				match(T__18);
				setState(128);
				aexp(0);
				}
				break;
			case 6:
				{
				setState(130);
				aexp(0);
				setState(131);
				match(T__19);
				setState(132);
				aexp(0);
				}
				break;
			case 7:
				{
				setState(134);
				strexpr();
				setState(135);
				match(T__18);
				setState(136);
				strexpr();
				}
				break;
			case 8:
				{
				setState(138);
				match(T__3);
				setState(139);
				bexp(0);
				setState(140);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(144);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(145);
						match(T__18);
						setState(146);
						bexp(6);
						}
						break;
					case 2:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(147);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(148);
						match(AND);
						setState(149);
						bexp(4);
						}
						break;
					case 3:
						{
						_localctx = new BexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexp);
						setState(150);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(151);
						match(OR);
						setState(152);
						bexp(3);
						}
						break;
					}
					} 
				}
				setState(157);
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
		enterRule(_localctx, 14, RULE_strexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return stm_sempred((StmContext)_localctx, predIndex);
		case 4:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 6:
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
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u00a6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001N\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"S\b\u0001\n\u0001\f\u0001V\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004i\b\u0004\n\u0004\f\u0004l\t\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005t\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008f\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u009a\b\u0006\n\u0006\f\u0006\u009d"+
		"\t\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00a4"+
		"\b\b\u0001\b\u0000\u0003\u0002\b\f\t\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0000\u0003\u0001\u0000\u001d\u001f\u0001\u0000\u001b\u001c\u0002"+
		"\u0000\u001a\u001a##\u00b9\u0000\u0013\u0001\u0000\u0000\u0000\u0002M"+
		"\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000\u0006[\u0001\u0000"+
		"\u0000\u0000\b_\u0001\u0000\u0000\u0000\ns\u0001\u0000\u0000\u0000\f\u008e"+
		"\u0001\u0000\u0000\u0000\u000e\u009e\u0001\u0000\u0000\u0000\u0010\u00a3"+
		"\u0001\u0000\u0000\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0012"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0013"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0005\u0000\u0000\u0001\u0018\u0001"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0006\u0001\uffff\uffff\u0000\u001a"+
		"\u001b\u0005\u0015\u0000\u0000\u001b\u001c\u0005#\u0000\u0000\u001c\u001d"+
		"\u0005\u0001\u0000\u0000\u001dN\u0003\u0010\b\u0000\u001e\u001f\u0005"+
		"#\u0000\u0000\u001f \u0005\u0001\u0000\u0000 N\u0003\u0010\b\u0000!N\u0005"+
		"\u0002\u0000\u0000\"#\u0005\u0003\u0000\u0000#$\u0005\u0004\u0000\u0000"+
		"$%\u0003\b\u0004\u0000%&\u0005\u0005\u0000\u0000&N\u0001\u0000\u0000\u0000"+
		"\'(\u0005\u0006\u0000\u0000()\u0005\u0004\u0000\u0000)*\u0003\u000e\u0007"+
		"\u0000*+\u0005\u0005\u0000\u0000+N\u0001\u0000\u0000\u0000,-\u0005\u0007"+
		"\u0000\u0000-.\u0005\u0004\u0000\u0000./\u0003\f\u0006\u0000/0\u0005\u0005"+
		"\u0000\u00000N\u0001\u0000\u0000\u000012\u0005\b\u0000\u000023\u0005\u0004"+
		"\u0000\u000034\u0005#\u0000\u00004N\u0005\u0005\u0000\u000056\u0005\t"+
		"\u0000\u000067\u0005\u0004\u0000\u000078\u0005#\u0000\u00008N\u0005\u0005"+
		"\u0000\u00009:\u0005\n\u0000\u0000:;\u0005\u0004\u0000\u0000;<\u0005#"+
		"\u0000\u0000<N\u0005\u0005\u0000\u0000=>\u0005\u000b\u0000\u0000>?\u0003"+
		"\f\u0006\u0000?@\u0005\f\u0000\u0000@A\u0003\u0004\u0002\u0000AB\u0005"+
		"\r\u0000\u0000BC\u0003\u0006\u0003\u0000CN\u0001\u0000\u0000\u0000DE\u0005"+
		"\u000e\u0000\u0000EF\u0003\f\u0006\u0000FG\u0005\u000f\u0000\u0000GH\u0003"+
		"\u0002\u0001\u0003HN\u0001\u0000\u0000\u0000IJ\u0005\u0004\u0000\u0000"+
		"JK\u0003\u0002\u0001\u0000KL\u0005\u0005\u0000\u0000LN\u0001\u0000\u0000"+
		"\u0000M\u0019\u0001\u0000\u0000\u0000M\u001e\u0001\u0000\u0000\u0000M"+
		"!\u0001\u0000\u0000\u0000M\"\u0001\u0000\u0000\u0000M\'\u0001\u0000\u0000"+
		"\u0000M,\u0001\u0000\u0000\u0000M1\u0001\u0000\u0000\u0000M5\u0001\u0000"+
		"\u0000\u0000M9\u0001\u0000\u0000\u0000M=\u0001\u0000\u0000\u0000MD\u0001"+
		"\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000NT\u0001\u0000\u0000\u0000"+
		"OP\n\u0001\u0000\u0000PQ\u0005\u0010\u0000\u0000QS\u0003\u0002\u0001\u0002"+
		"RO\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000U\u0003\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0005\u0004\u0000\u0000XY\u0003\u0002\u0001\u0000"+
		"YZ\u0005\u0005\u0000\u0000Z\u0005\u0001\u0000\u0000\u0000[\\\u0005\u0004"+
		"\u0000\u0000\\]\u0003\u0002\u0001\u0000]^\u0005\u0005\u0000\u0000^\u0007"+
		"\u0001\u0000\u0000\u0000_`\u0006\u0004\uffff\uffff\u0000`a\u0003\n\u0005"+
		"\u0000aj\u0001\u0000\u0000\u0000bc\n\u0003\u0000\u0000cd\u0007\u0000\u0000"+
		"\u0000di\u0003\b\u0004\u0004ef\n\u0002\u0000\u0000fg\u0007\u0001\u0000"+
		"\u0000gi\u0003\b\u0004\u0003hb\u0001\u0000\u0000\u0000he\u0001\u0000\u0000"+
		"\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000k\t\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mt\u0005"+
		"\u0019\u0000\u0000nt\u0005#\u0000\u0000op\u0005\u0004\u0000\u0000pq\u0003"+
		"\b\u0004\u0000qr\u0005\u0005\u0000\u0000rt\u0001\u0000\u0000\u0000sm\u0001"+
		"\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000"+
		"t\u000b\u0001\u0000\u0000\u0000uv\u0006\u0006\uffff\uffff\u0000v\u008f"+
		"\u0005\u0011\u0000\u0000w\u008f\u0005\u0012\u0000\u0000xy\u0005 \u0000"+
		"\u0000yz\u0005\u0004\u0000\u0000z{\u0003\f\u0006\u0000{|\u0005\u0005\u0000"+
		"\u0000|\u008f\u0001\u0000\u0000\u0000}\u008f\u0005#\u0000\u0000~\u007f"+
		"\u0003\b\u0004\u0000\u007f\u0080\u0005\u0013\u0000\u0000\u0080\u0081\u0003"+
		"\b\u0004\u0000\u0081\u008f\u0001\u0000\u0000\u0000\u0082\u0083\u0003\b"+
		"\u0004\u0000\u0083\u0084\u0005\u0014\u0000\u0000\u0084\u0085\u0003\b\u0004"+
		"\u0000\u0085\u008f\u0001\u0000\u0000\u0000\u0086\u0087\u0003\u000e\u0007"+
		"\u0000\u0087\u0088\u0005\u0013\u0000\u0000\u0088\u0089\u0003\u000e\u0007"+
		"\u0000\u0089\u008f\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0004\u0000"+
		"\u0000\u008b\u008c\u0003\f\u0006\u0000\u008c\u008d\u0005\u0005\u0000\u0000"+
		"\u008d\u008f\u0001\u0000\u0000\u0000\u008eu\u0001\u0000\u0000\u0000\u008e"+
		"w\u0001\u0000\u0000\u0000\u008ex\u0001\u0000\u0000\u0000\u008e}\u0001"+
		"\u0000\u0000\u0000\u008e~\u0001\u0000\u0000\u0000\u008e\u0082\u0001\u0000"+
		"\u0000\u0000\u008e\u0086\u0001\u0000\u0000\u0000\u008e\u008a\u0001\u0000"+
		"\u0000\u0000\u008f\u009b\u0001\u0000\u0000\u0000\u0090\u0091\n\u0005\u0000"+
		"\u0000\u0091\u0092\u0005\u0013\u0000\u0000\u0092\u009a\u0003\f\u0006\u0006"+
		"\u0093\u0094\n\u0003\u0000\u0000\u0094\u0095\u0005!\u0000\u0000\u0095"+
		"\u009a\u0003\f\u0006\u0004\u0096\u0097\n\u0002\u0000\u0000\u0097\u0098"+
		"\u0005\"\u0000\u0000\u0098\u009a\u0003\f\u0006\u0003\u0099\u0090\u0001"+
		"\u0000\u0000\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0096\u0001"+
		"\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\r\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0002"+
		"\u0000\u0000\u009f\u000f\u0001\u0000\u0000\u0000\u00a0\u00a4\u0003\u000e"+
		"\u0007\u0000\u00a1\u00a4\u0003\b\u0004\u0000\u00a2\u00a4\u0003\f\u0006"+
		"\u0000\u00a3\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u0011\u0001\u0000\u0000"+
		"\u0000\n\u0015MThjs\u008e\u0099\u009b\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}