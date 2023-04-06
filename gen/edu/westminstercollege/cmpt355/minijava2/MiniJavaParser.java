// Generated from java-escape by ANTLR 4.11.1
package edu.westminstercollege.cmpt355.minijava2;

import edu.westminstercollege.cmpt355.minijava2.node.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, LINE_COMMENT=23, MULTI_COMMENT=24, 
		STRING=25, KEYWORD=26, INT=27, DOUBLE=28, NAME=29, WS=30;
	public static final int
		RULE_methodBody = 0, RULE_statement = 1, RULE_variableDeclaration = 2, 
		RULE_variableDeclarationItem = 3, RULE_expr = 4, RULE_type = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"methodBody", "statement", "variableDeclaration", "variableDeclarationItem", 
			"expr", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "','", "'='", "'++'", "'--'", "'+'", "'-'", 
			"'('", "')'", "'*'", "'/'", "'%'", "'_print'", "'.'", "'new'", "'true'", 
			"'false'", "'double'", "'boolean'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "LINE_COMMENT", 
			"MULTI_COMMENT", "STRING", "KEYWORD", "INT", "DOUBLE", "NAME", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public Block n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 981370826L) != 0) {
				{
				{
				setState(12);
				((MethodBodyContext)_localctx).statement = statement();
				((MethodBodyContext)_localctx).stmts.add(((MethodBodyContext)_localctx).statement);
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);

			        var statements = new ArrayList<Statement>();
			        for (var stmt : ((MethodBodyContext)_localctx).stmts)
			            statements.add(stmt.n);

			        ((MethodBodyContext)_localctx).n =  new Block(_localctx, statements);
			    
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
	public static class StatementContext extends ParserRuleContext {
		public Statement n;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public VariableDeclarationContext variableDeclaration;
		public ExprContext expr;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				match(T__0);
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 981370826L) != 0) {
					{
					{
					setState(22);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).stmts.add(((StatementContext)_localctx).statement);
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(28);
				match(T__1);

				        var statements = new ArrayList<Statement>();
				        for (var stmt : ((StatementContext)_localctx).stmts)
				            statements.add(stmt.n);

				        ((StatementContext)_localctx).n =  new Block(_localctx, statements);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				((StatementContext)_localctx).variableDeclaration = variableDeclaration();

				        ((StatementContext)_localctx).n =  ((StatementContext)_localctx).variableDeclaration.n;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				((StatementContext)_localctx).expr = expr(0);
				setState(34);
				match(T__2);

				        ((StatementContext)_localctx).n =  new ExpressionStatement(_localctx, ((StatementContext)_localctx).expr.n);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				match(T__2);

				        ((StatementContext)_localctx).n =  new EmptyStatement(_localctx);
				    
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public VarDeclarations n;
		public TypeContext type;
		public VariableDeclarationItemContext variableDeclarationItem;
		public List<VariableDeclarationItemContext> args = new ArrayList<VariableDeclarationItemContext>();
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableDeclarationItemContext> variableDeclarationItem() {
			return getRuleContexts(VariableDeclarationItemContext.class);
		}
		public VariableDeclarationItemContext variableDeclarationItem(int i) {
			return getRuleContext(VariableDeclarationItemContext.class,i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((VariableDeclarationContext)_localctx).type = type();
			setState(42);
			((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
			((VariableDeclarationContext)_localctx).args.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(43);
				match(T__3);
				setState(44);
				((VariableDeclarationContext)_localctx).variableDeclarationItem = variableDeclarationItem();
				((VariableDeclarationContext)_localctx).args.add(((VariableDeclarationContext)_localctx).variableDeclarationItem);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(T__2);

			        var arguments = new ArrayList<VarDecs>();
			        for (var arg : ((VariableDeclarationContext)_localctx).args)
			            arguments.add(arg.n);
			        ((VariableDeclarationContext)_localctx).n =  new VarDeclarations(_localctx, new TypeNode(_localctx, ((VariableDeclarationContext)_localctx).type.n), arguments);
			    
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
	public static class VariableDeclarationItemContext extends ParserRuleContext {
		public VarDecs n;
		public Token NAME;
		public ExprContext expr;
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariableDeclarationItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationItem; }
	}

	public final VariableDeclarationItemContext variableDeclarationItem() throws RecognitionException {
		VariableDeclarationItemContext _localctx = new VariableDeclarationItemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclarationItem);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclaration(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				((VariableDeclarationItemContext)_localctx).NAME = match(NAME);
				setState(56);
				match(T__4);
				setState(57);
				((VariableDeclarationItemContext)_localctx).expr = expr(0);

				        ((VariableDeclarationItemContext)_localctx).n =  new VarDeclarationInit(_localctx, (((VariableDeclarationItemContext)_localctx).NAME!=null?((VariableDeclarationItemContext)_localctx).NAME.getText():null), ((VariableDeclarationItemContext)_localctx).expr.n);
				    
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
	public static class ExprContext extends ParserRuleContext {
		public Expression n;
		public ExprContext l;
		public Token op;
		public ExprContext expr;
		public TypeContext type;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public Token NAME;
		public Token INT;
		public Token DOUBLE;
		public Token STRING;
		public ExprContext r;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniJavaParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(63);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(64);
				((ExprContext)_localctx).expr = expr(16);

				        if ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null).equals("-")) {
				            ((ExprContext)_localctx).n =  new Negate(_localctx, ((ExprContext)_localctx).expr.n);
				        } else if (!(((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null).equals("+")) {
				            ((ExprContext)_localctx).n =  new PreIncrement(_localctx, ((ExprContext)_localctx).expr.n, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
				        }
				    
				}
				break;
			case 2:
				{
				setState(67);
				match(T__9);
				setState(68);
				((ExprContext)_localctx).type = type();
				setState(69);
				match(T__10);
				setState(70);
				((ExprContext)_localctx).expr = expr(15);

				        ((ExprContext)_localctx).n =  new Cast(_localctx, new TypeNode(_localctx, ((ExprContext)_localctx).type.n), ((ExprContext)_localctx).expr.n);
				    
				}
				break;
			case 3:
				{
				setState(73);
				match(T__14);
				setState(74);
				match(T__9);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 974030784L) != 0) {
					{
					setState(75);
					((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
					((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(76);
						match(T__3);
						setState(77);
						((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
						((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
						}
						}
						setState(82);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(85);
				match(T__10);

				        var arguments = new ArrayList<Expression>();
				        for (var arg : ((ExprContext)_localctx).args)
				            arguments.add(arg.n);
				        ((ExprContext)_localctx).n =  new Print(_localctx, arguments);
				    
				}
				break;
			case 4:
				{
				setState(87);
				match(T__9);
				setState(88);
				((ExprContext)_localctx).expr = expr(0);
				setState(89);
				match(T__10);

				        ((ExprContext)_localctx).n =  ((ExprContext)_localctx).expr.n;
				    
				}
				break;
			case 5:
				{
				setState(92);
				match(T__16);
				setState(93);
				((ExprContext)_localctx).NAME = match(NAME);
				setState(94);
				match(T__9);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 974030784L) != 0) {
					{
					setState(95);
					((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
					((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(96);
						match(T__3);
						setState(97);
						((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
						((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(105);
				match(T__10);

				        var arguments = new ArrayList<Expression>();
				        for (var arg : ((ExprContext)_localctx).args)
				            arguments.add(arg.n);
				        ((ExprContext)_localctx).n =  new ConstructorCall(_localctx, (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null), arguments);
				    
				}
				break;
			case 6:
				{
				setState(107);
				((ExprContext)_localctx).INT = match(INT);

				        ((ExprContext)_localctx).n =  new IntLiteral(_localctx, Integer.parseInt((((ExprContext)_localctx).INT!=null?((ExprContext)_localctx).INT.getText():null)));
				    
				}
				break;
			case 7:
				{
				setState(109);
				((ExprContext)_localctx).DOUBLE = match(DOUBLE);

				        ((ExprContext)_localctx).n =  new DoubleLiteral(_localctx, Double.parseDouble((((ExprContext)_localctx).DOUBLE!=null?((ExprContext)_localctx).DOUBLE.getText():null)));
				    
				}
				break;
			case 8:
				{
				setState(111);
				((ExprContext)_localctx).STRING = match(STRING);

				        ((ExprContext)_localctx).n =  new StringLiteral(_localctx, (((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null));
				    
				}
				break;
			case 9:
				{
				setState(113);
				match(T__17);

				        ((ExprContext)_localctx).n =  new BooleanLiteral(_localctx, "True");
				    
				}
				break;
			case 10:
				{
				setState(115);
				match(T__18);

				        ((ExprContext)_localctx).n =  new BooleanLiteral(_localctx, "False");
				    
				}
				break;
			case 11:
				{
				setState(117);
				((ExprContext)_localctx).NAME = match(NAME);

				        ((ExprContext)_localctx).n =  new VariableAccess(_localctx, (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null));
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(159);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(122);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(15);

						                  ((ExprContext)_localctx).n =  new BinaryOp(_localctx, ((ExprContext)_localctx).l.n, ((ExprContext)_localctx).r.n, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						              
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(127);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__8) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(14);

						                  ((ExprContext)_localctx).n =  new BinaryOp(_localctx, ((ExprContext)_localctx).l.n, ((ExprContext)_localctx).r.n, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						              
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(132);
						match(T__4);
						setState(133);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(12);

						                  ((ExprContext)_localctx).n =  new Assignment(_localctx, ((ExprContext)_localctx).l.n, ((ExprContext)_localctx).r.n);
						              
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(137);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}

						                  ((ExprContext)_localctx).n =  new PostIncrement(_localctx, ((ExprContext)_localctx).l.n, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null));
						              
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(140);
						match(T__15);
						setState(141);
						((ExprContext)_localctx).NAME = match(NAME);
						setState(142);
						match(T__9);
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 974030784L) != 0) {
							{
							setState(143);
							((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
							((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
							setState(148);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__3) {
								{
								{
								setState(144);
								match(T__3);
								setState(145);
								((ExprContext)_localctx).expr = ((ExprContext)_localctx).expr = expr(0);
								((ExprContext)_localctx).args.add(((ExprContext)_localctx).expr);
								}
								}
								setState(150);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(153);
						match(T__10);

						                  var arguments = new ArrayList<Expression>();
						                  for (var arg : ((ExprContext)_localctx).args)
						                      arguments.add(arg.n);
						                  ((ExprContext)_localctx).n =  new MethodCall(_localctx, ((ExprContext)_localctx).l.n, (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null), arguments);
						              
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(156);
						match(T__15);
						setState(157);
						((ExprContext)_localctx).NAME = match(NAME);

						                  ((ExprContext)_localctx).n =  new FieldAccess(_localctx, ((ExprContext)_localctx).l.n, (((ExprContext)_localctx).NAME!=null?((ExprContext)_localctx).NAME.getText():null));
						              
						}
						break;
					}
					} 
				}
				setState(163);
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
	public static class TypeContext extends ParserRuleContext {
		public Type n;
		public Token NAME;
		public TerminalNode NAME() { return getToken(MiniJavaParser.NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__19);

				        ((TypeContext)_localctx).n =  PrimitiveType.Double;
				    
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(T__20);

				        ((TypeContext)_localctx).n =  PrimitiveType.Boolean;
				    
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(T__21);

				        ((TypeContext)_localctx).n =  PrimitiveType.Int;
				    
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				((TypeContext)_localctx).NAME = match(NAME);

				        ((TypeContext)_localctx).n =  new ClassType((((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null));
				    
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00af\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000"+
		"\f\u0000\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002.\b"+
		"\u0002\n\u0002\f\u00021\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003=\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004O\b\u0004\n\u0004\f\u0004R\t\u0004\u0003\u0004T\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004c\b\u0004\n\u0004\f\u0004f\t\u0004\u0003\u0004"+
		"h\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004x\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u0093\b\u0004\n\u0004\f\u0004\u0096\t\u0004\u0003\u0004\u0098"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00a0\b\u0004\n\u0004\f\u0004\u00a3\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00ad\b\u0005\u0001\u0005\u0000\u0001\b\u0006"+
		"\u0000\u0002\u0004\u0006\b\n\u0000\u0004\u0001\u0000\u0006\t\u0001\u0000"+
		"\f\u000e\u0001\u0000\b\t\u0001\u0000\u0006\u0007\u00c8\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004)\u0001\u0000"+
		"\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\bw\u0001\u0000\u0000\u0000"+
		"\n\u00ac\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000"+
		"\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001\u0000"+
		"\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0000"+
		"\u0000\u0001\u0013\u0014\u0006\u0000\uffff\uffff\u0000\u0014\u0001\u0001"+
		"\u0000\u0000\u0000\u0015\u0019\u0005\u0001\u0000\u0000\u0016\u0018\u0003"+
		"\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d(\u0006\u0001"+
		"\uffff\uffff\u0000\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0006\u0001"+
		"\uffff\uffff\u0000 (\u0001\u0000\u0000\u0000!\"\u0003\b\u0004\u0000\""+
		"#\u0005\u0003\u0000\u0000#$\u0006\u0001\uffff\uffff\u0000$(\u0001\u0000"+
		"\u0000\u0000%&\u0005\u0003\u0000\u0000&(\u0006\u0001\uffff\uffff\u0000"+
		"\'\u0015\u0001\u0000\u0000\u0000\'\u001e\u0001\u0000\u0000\u0000\'!\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000"+
		"\u0000)*\u0003\n\u0005\u0000*/\u0003\u0006\u0003\u0000+,\u0005\u0004\u0000"+
		"\u0000,.\u0003\u0006\u0003\u0000-+\u0001\u0000\u0000\u0000.1\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u0003\u0000\u0000"+
		"34\u0006\u0002\uffff\uffff\u00004\u0005\u0001\u0000\u0000\u000056\u0005"+
		"\u001d\u0000\u00006=\u0006\u0003\uffff\uffff\u000078\u0005\u001d\u0000"+
		"\u000089\u0005\u0005\u0000\u00009:\u0003\b\u0004\u0000:;\u0006\u0003\uffff"+
		"\uffff\u0000;=\u0001\u0000\u0000\u0000<5\u0001\u0000\u0000\u0000<7\u0001"+
		"\u0000\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0006\u0004\uffff"+
		"\uffff\u0000?@\u0007\u0000\u0000\u0000@A\u0003\b\u0004\u0010AB\u0006\u0004"+
		"\uffff\uffff\u0000Bx\u0001\u0000\u0000\u0000CD\u0005\n\u0000\u0000DE\u0003"+
		"\n\u0005\u0000EF\u0005\u000b\u0000\u0000FG\u0003\b\u0004\u000fGH\u0006"+
		"\u0004\uffff\uffff\u0000Hx\u0001\u0000\u0000\u0000IJ\u0005\u000f\u0000"+
		"\u0000JS\u0005\n\u0000\u0000KP\u0003\b\u0004\u0000LM\u0005\u0004\u0000"+
		"\u0000MO\u0003\b\u0004\u0000NL\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QT\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000SK\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005\u000b\u0000\u0000"+
		"Vx\u0006\u0004\uffff\uffff\u0000WX\u0005\n\u0000\u0000XY\u0003\b\u0004"+
		"\u0000YZ\u0005\u000b\u0000\u0000Z[\u0006\u0004\uffff\uffff\u0000[x\u0001"+
		"\u0000\u0000\u0000\\]\u0005\u0011\u0000\u0000]^\u0005\u001d\u0000\u0000"+
		"^g\u0005\n\u0000\u0000_d\u0003\b\u0004\u0000`a\u0005\u0004\u0000\u0000"+
		"ac\u0003\b\u0004\u0000b`\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000g_\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005\u000b\u0000\u0000jx\u0006"+
		"\u0004\uffff\uffff\u0000kl\u0005\u001b\u0000\u0000lx\u0006\u0004\uffff"+
		"\uffff\u0000mn\u0005\u001c\u0000\u0000nx\u0006\u0004\uffff\uffff\u0000"+
		"op\u0005\u0019\u0000\u0000px\u0006\u0004\uffff\uffff\u0000qr\u0005\u0012"+
		"\u0000\u0000rx\u0006\u0004\uffff\uffff\u0000st\u0005\u0013\u0000\u0000"+
		"tx\u0006\u0004\uffff\uffff\u0000uv\u0005\u001d\u0000\u0000vx\u0006\u0004"+
		"\uffff\uffff\u0000w>\u0001\u0000\u0000\u0000wC\u0001\u0000\u0000\u0000"+
		"wI\u0001\u0000\u0000\u0000wW\u0001\u0000\u0000\u0000w\\\u0001\u0000\u0000"+
		"\u0000wk\u0001\u0000\u0000\u0000wm\u0001\u0000\u0000\u0000wo\u0001\u0000"+
		"\u0000\u0000wq\u0001\u0000\u0000\u0000ws\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000x\u00a1\u0001\u0000\u0000\u0000yz\n\u000e\u0000\u0000"+
		"z{\u0007\u0001\u0000\u0000{|\u0003\b\u0004\u000f|}\u0006\u0004\uffff\uffff"+
		"\u0000}\u00a0\u0001\u0000\u0000\u0000~\u007f\n\r\u0000\u0000\u007f\u0080"+
		"\u0007\u0002\u0000\u0000\u0080\u0081\u0003\b\u0004\u000e\u0081\u0082\u0006"+
		"\u0004\uffff\uffff\u0000\u0082\u00a0\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\n\f\u0000\u0000\u0084\u0085\u0005\u0005\u0000\u0000\u0085\u0086\u0003"+
		"\b\u0004\f\u0086\u0087\u0006\u0004\uffff\uffff\u0000\u0087\u00a0\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\n\u0011\u0000\u0000\u0089\u008a\u0007\u0003"+
		"\u0000\u0000\u008a\u00a0\u0006\u0004\uffff\uffff\u0000\u008b\u008c\n\t"+
		"\u0000\u0000\u008c\u008d\u0005\u0010\u0000\u0000\u008d\u008e\u0005\u001d"+
		"\u0000\u0000\u008e\u0097\u0005\n\u0000\u0000\u008f\u0094\u0003\b\u0004"+
		"\u0000\u0090\u0091\u0005\u0004\u0000\u0000\u0091\u0093\u0003\b\u0004\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0097\u008f\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u000b\u0000\u0000"+
		"\u009a\u00a0\u0006\u0004\uffff\uffff\u0000\u009b\u009c\n\b\u0000\u0000"+
		"\u009c\u009d\u0005\u0010\u0000\u0000\u009d\u009e\u0005\u001d\u0000\u0000"+
		"\u009e\u00a0\u0006\u0004\uffff\uffff\u0000\u009fy\u0001\u0000\u0000\u0000"+
		"\u009f~\u0001\u0000\u0000\u0000\u009f\u0083\u0001\u0000\u0000\u0000\u009f"+
		"\u0088\u0001\u0000\u0000\u0000\u009f\u008b\u0001\u0000\u0000\u0000\u009f"+
		"\u009b\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\t\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0005\u0014\u0000\u0000\u00a5\u00ad\u0006\u0005\uffff\uffff\u0000\u00a6"+
		"\u00a7\u0005\u0015\u0000\u0000\u00a7\u00ad\u0006\u0005\uffff\uffff\u0000"+
		"\u00a8\u00a9\u0005\u0016\u0000\u0000\u00a9\u00ad\u0006\u0005\uffff\uffff"+
		"\u0000\u00aa\u00ab\u0005\u001d\u0000\u0000\u00ab\u00ad\u0006\u0005\uffff"+
		"\uffff\u0000\u00ac\u00a4\u0001\u0000\u0000\u0000\u00ac\u00a6\u0001\u0000"+
		"\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ad\u000b\u0001\u0000\u0000\u0000\u000f\u000f\u0019\'/"+
		"<PSdgw\u0094\u0097\u009f\u00a1\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}