// Generated from /home/mikhirurg/IdeaProjects/BachelorThesis/src/main/antlr4/While.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class WhileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, TYPE=20, INT_TYPE=21, BOOL_TYPE=22, STRING_TYPE=23, 
		VAR=24, INT=25, NOT=26, AND=27, OR=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "TYPE", "INT_TYPE", "BOOL_TYPE", "STRING_TYPE", "VAR", 
			"INT", "NOT", "AND", "OR", "WS"
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


	public WhileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u00af\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0082\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0004\u0017\u0095\b\u0017"+
		"\u000b\u0017\f\u0017\u0096\u0001\u0018\u0004\u0018\u009a\b\u0018\u000b"+
		"\u0018\f\u0018\u009b\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0004\u001c\u00aa\b\u001c\u000b\u001c\f\u001c\u00ab"+
		"\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d\u0001\u0000\u0003\u0002\u0000AZaz\u0001\u000009\u0002\u0000"+
		"\t\n  \u00b3\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000"+
		"\u0000\u0003>\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007"+
		"E\u0001\u0000\u0000\u0000\tH\u0001\u0000\u0000\u0000\u000bM\u0001\u0000"+
		"\u0000\u0000\rR\u0001\u0000\u0000\u0000\u000fX\u0001\u0000\u0000\u0000"+
		"\u0011[\u0001\u0000\u0000\u0000\u0013b\u0001\u0000\u0000\u0000\u0015d"+
		"\u0001\u0000\u0000\u0000\u0017f\u0001\u0000\u0000\u0000\u0019h\u0001\u0000"+
		"\u0000\u0000\u001bj\u0001\u0000\u0000\u0000\u001dl\u0001\u0000\u0000\u0000"+
		"\u001fq\u0001\u0000\u0000\u0000!w\u0001\u0000\u0000\u0000#y\u0001\u0000"+
		"\u0000\u0000%|\u0001\u0000\u0000\u0000\'\u0081\u0001\u0000\u0000\u0000"+
		")\u0083\u0001\u0000\u0000\u0000+\u0087\u0001\u0000\u0000\u0000-\u008c"+
		"\u0001\u0000\u0000\u0000/\u0094\u0001\u0000\u0000\u00001\u0099\u0001\u0000"+
		"\u0000\u00003\u009d\u0001\u0000\u0000\u00005\u00a1\u0001\u0000\u0000\u0000"+
		"7\u00a5\u0001\u0000\u0000\u00009\u00a9\u0001\u0000\u0000\u0000;<\u0005"+
		":\u0000\u0000<=\u0005=\u0000\u0000=\u0002\u0001\u0000\u0000\u0000>?\u0005"+
		"s\u0000\u0000?@\u0005k\u0000\u0000@A\u0005i\u0000\u0000AB\u0005p\u0000"+
		"\u0000B\u0004\u0001\u0000\u0000\u0000CD\u0005;\u0000\u0000D\u0006\u0001"+
		"\u0000\u0000\u0000EF\u0005i\u0000\u0000FG\u0005f\u0000\u0000G\b\u0001"+
		"\u0000\u0000\u0000HI\u0005t\u0000\u0000IJ\u0005h\u0000\u0000JK\u0005e"+
		"\u0000\u0000KL\u0005n\u0000\u0000L\n\u0001\u0000\u0000\u0000MN\u0005e"+
		"\u0000\u0000NO\u0005l\u0000\u0000OP\u0005s\u0000\u0000PQ\u0005e\u0000"+
		"\u0000Q\f\u0001\u0000\u0000\u0000RS\u0005w\u0000\u0000ST\u0005h\u0000"+
		"\u0000TU\u0005i\u0000\u0000UV\u0005l\u0000\u0000VW\u0005e\u0000\u0000"+
		"W\u000e\u0001\u0000\u0000\u0000XY\u0005d\u0000\u0000YZ\u0005o\u0000\u0000"+
		"Z\u0010\u0001\u0000\u0000\u0000[\\\u0005p\u0000\u0000\\]\u0005r\u0000"+
		"\u0000]^\u0005i\u0000\u0000^_\u0005n\u0000\u0000_`\u0005t\u0000\u0000"+
		"`a\u0005(\u0000\u0000a\u0012\u0001\u0000\u0000\u0000bc\u0005)\u0000\u0000"+
		"c\u0014\u0001\u0000\u0000\u0000de\u0005(\u0000\u0000e\u0016\u0001\u0000"+
		"\u0000\u0000fg\u0005+\u0000\u0000g\u0018\u0001\u0000\u0000\u0000hi\u0005"+
		"-\u0000\u0000i\u001a\u0001\u0000\u0000\u0000jk\u0005*\u0000\u0000k\u001c"+
		"\u0001\u0000\u0000\u0000lm\u0005t\u0000\u0000mn\u0005r\u0000\u0000no\u0005"+
		"u\u0000\u0000op\u0005e\u0000\u0000p\u001e\u0001\u0000\u0000\u0000qr\u0005"+
		"f\u0000\u0000rs\u0005a\u0000\u0000st\u0005l\u0000\u0000tu\u0005s\u0000"+
		"\u0000uv\u0005e\u0000\u0000v \u0001\u0000\u0000\u0000wx\u0005=\u0000\u0000"+
		"x\"\u0001\u0000\u0000\u0000yz\u0005<\u0000\u0000z{\u0005=\u0000\u0000"+
		"{$\u0001\u0000\u0000\u0000|}\u0005\"\u0000\u0000}&\u0001\u0000\u0000\u0000"+
		"~\u0082\u0003)\u0014\u0000\u007f\u0082\u0003+\u0015\u0000\u0080\u0082"+
		"\u0003-\u0016\u0000\u0081~\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082(\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005i\u0000\u0000\u0084\u0085\u0005n\u0000\u0000\u0085"+
		"\u0086\u0005t\u0000\u0000\u0086*\u0001\u0000\u0000\u0000\u0087\u0088\u0005"+
		"b\u0000\u0000\u0088\u0089\u0005o\u0000\u0000\u0089\u008a\u0005o\u0000"+
		"\u0000\u008a\u008b\u0005l\u0000\u0000\u008b,\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005s\u0000\u0000\u008d\u008e\u0005t\u0000\u0000\u008e\u008f\u0005"+
		"r\u0000\u0000\u008f\u0090\u0005i\u0000\u0000\u0090\u0091\u0005n\u0000"+
		"\u0000\u0091\u0092\u0005g\u0000\u0000\u0092.\u0001\u0000\u0000\u0000\u0093"+
		"\u0095\u0007\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0001\u0000\u0000\u0000\u00970\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0007\u0001\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c2\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"n\u0000\u0000\u009e\u009f\u0005o\u0000\u0000\u009f\u00a0\u0005t\u0000"+
		"\u0000\u00a04\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005a\u0000\u0000\u00a2"+
		"\u00a3\u0005n\u0000\u0000\u00a3\u00a4\u0005d\u0000\u0000\u00a46\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005o\u0000\u0000\u00a6\u00a7\u0005r\u0000"+
		"\u0000\u00a78\u0001\u0000\u0000\u0000\u00a8\u00aa\u0007\u0002\u0000\u0000"+
		"\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0006\u001c\u0000\u0000"+
		"\u00ae:\u0001\u0000\u0000\u0000\u0005\u0000\u0081\u0096\u009b\u00ab\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}