// $ANTLR : "Anasint.g" -> "Anasint.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class Anasint extends antlr.LLkParser       implements AnasintTokenTypes
 {

protected Anasint(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected Anasint(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenStream lexer) {
  this(lexer,2);
}

public Anasint(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void document() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST document_AST = null;
		
		try {      // for error handling
			instrucciones();
			astFactory.addASTChild(currentAST, returnAST);
			match(Token.EOF_TYPE);
			if ( inputState.guessing==0 ) {
				document_AST = (AST)currentAST.root;
				document_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(DOC_LATEX,"DOC_LATEX")).add(document_AST));
				currentAST.root = document_AST;
				currentAST.child = document_AST!=null &&document_AST.getFirstChild()!=null ?
					document_AST.getFirstChild() : document_AST;
				currentAST.advanceChildToEnd();
			}
			document_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = document_AST;
	}
	
	public final void instrucciones() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST instrucciones_AST = null;
		
		try {      // for error handling
			{
			int _cnt1237=0;
			_loop1237:
			do {
				if ((LA(1)==BARRA)) {
					instruccion();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt1237>=1 ) { break _loop1237; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1237++;
			} while (true);
			}
			instrucciones_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = instrucciones_AST;
	}
	
	public final void instruccion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST instruccion_AST = null;
		
		try {      // for error handling
			if ((LA(1)==BARRA) && (LA(2)==BEGIN)) {
				match(BARRA);
				match(BEGIN);
				match(LLAVEABR);
				alternativas();
				astFactory.addASTChild(currentAST, returnAST);
				match(BARRA);
				match(END);
				match(LLAVEABR);
				{
				switch ( LA(1)) {
				case IDENT:
				{
					match(IDENT);
					break;
				}
				case DOCUMENT:
				{
					match(DOCUMENT);
					break;
				}
				case CENTER:
				{
					match(CENTER);
					break;
				}
				case ITEMIZE:
				{
					match(ITEMIZE);
					break;
				}
				case ENUMERATE:
				{
					match(ENUMERATE);
					break;
				}
				case TABULAR:
				{
					match(TABULAR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(LLAVECERR);
				instruccion_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (LA(2)==SECTION)) {
				match(BARRA);
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp16_AST);
				match(SECTION);
				config();
				astFactory.addASTChild(currentAST, returnAST);
				instruccion_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (LA(2)==SUBSECTION)) {
				match(BARRA);
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp18_AST);
				match(SUBSECTION);
				config();
				astFactory.addASTChild(currentAST, returnAST);
				instruccion_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (LA(2)==SUBSUBSECTION)) {
				match(BARRA);
				AST tmp20_AST = null;
				tmp20_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp20_AST);
				match(SUBSUBSECTION);
				config();
				astFactory.addASTChild(currentAST, returnAST);
				instruccion_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (LA(2)==GRAPHICS)) {
				match(BARRA);
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp22_AST);
				match(GRAPHICS);
				config();
				astFactory.addASTChild(currentAST, returnAST);
				instruccion_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (LA(2)==IDENT)) {
				match(BARRA);
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp24_AST);
				match(IDENT);
				config();
				astFactory.addASTChild(currentAST, returnAST);
				instruccion_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		returnAST = instruccion_AST;
	}
	
	public final void alternativas() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alternativas_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp25_AST);
				match(IDENT);
				match(LLAVECERR);
				contenidos();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			case DOCUMENT:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp27_AST);
				match(DOCUMENT);
				match(LLAVECERR);
				contenidos();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			case CENTER:
			{
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp29_AST);
				match(CENTER);
				match(LLAVECERR);
				contenidos();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			case ITEMIZE:
			{
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp31_AST);
				match(ITEMIZE);
				match(LLAVECERR);
				contenidos();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			case ENUMERATE:
			{
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp33_AST);
				match(ENUMERATE);
				match(LLAVECERR);
				contenidos();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			case TABULAR:
			{
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp35_AST);
				match(TABULAR);
				match(LLAVECERR);
				tabla();
				astFactory.addASTChild(currentAST, returnAST);
				alternativas_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = alternativas_AST;
	}
	
	public final void config() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST config_AST = null;
		
		try {      // for error handling
			boolean synPredMatched1249 = false;
			if (((LA(1)==CORCHAB))) {
				int _m1249 = mark();
				synPredMatched1249 = true;
				inputState.guessing++;
				try {
					{
					match(CORCHAB);
					opt();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1249 = false;
				}
				rewind(_m1249);
inputState.guessing--;
			}
			if ( synPredMatched1249 ) {
				corchetes();
				astFactory.addASTChild(currentAST, returnAST);
				llaves();
				astFactory.addASTChild(currentAST, returnAST);
				config_AST = (AST)currentAST.root;
			}
			else {
				boolean synPredMatched1251 = false;
				if (((LA(1)==LLAVEABR) && (_tokenSet_3.member(LA(2))))) {
					int _m1251 = mark();
					synPredMatched1251 = true;
					inputState.guessing++;
					try {
						{
						match(LLAVEABR);
						pretexto();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched1251 = false;
					}
					rewind(_m1251);
inputState.guessing--;
				}
				if ( synPredMatched1251 ) {
					match(LLAVEABR);
					pretexto();
					astFactory.addASTChild(currentAST, returnAST);
					match(LLAVECERR);
					config_AST = (AST)currentAST.root;
				}
				else if ((_tokenSet_3.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
					pretexto();
					astFactory.addASTChild(currentAST, returnAST);
					config_AST = (AST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_1);
				} else {
				  throw ex;
				}
			}
			returnAST = config_AST;
		}
		
	public final void contenidos() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contenidos_AST = null;
		
		try {      // for error handling
			{
			_loop1267:
			do {
				if ((_tokenSet_4.member(LA(1))) && (_tokenSet_5.member(LA(2)))) {
					contenido();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop1267;
				}
				
			} while (true);
			}
			contenidos_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = contenidos_AST;
	}
	
	public final void tabla() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tabla_AST = null;
		
		try {      // for error handling
			{
			int _cnt1243=0;
			_loop1243:
			do {
				if ((_tokenSet_6.member(LA(1)))) {
					tuplas();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt1243>=1 ) { break _loop1243; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1243++;
			} while (true);
			}
			tabla_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = tabla_AST;
	}
	
	public final void tuplas() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tuplas_AST = null;
		
		try {      // for error handling
			pretextoTabla();
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt1246=0;
			_loop1246:
			do {
				if ((LA(1)==AS)) {
					match(AS);
					pretextoTabla();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt1246>=1 ) { break _loop1246; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1246++;
			} while (true);
			}
			match(LINEA_LATEX);
			if ( inputState.guessing==0 ) {
				tuplas_AST = (AST)currentAST.root;
				tuplas_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TUPLA,"TUPLA")).add(tuplas_AST));
				currentAST.root = tuplas_AST;
				currentAST.child = tuplas_AST!=null &&tuplas_AST.getFirstChild()!=null ?
					tuplas_AST.getFirstChild() : tuplas_AST;
				currentAST.advanceChildToEnd();
			}
			tuplas_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = tuplas_AST;
	}
	
	public final void pretextoTabla() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pretextoTabla_AST = null;
		
		try {      // for error handling
			{
			int _cnt1283=0;
			_loop1283:
			do {
				if ((_tokenSet_6.member(LA(1)))) {
					textoTabla();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt1283>=1 ) { break _loop1283; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1283++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				pretextoTabla_AST = (AST)currentAST.root;
				pretextoTabla_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TXT,"TXT")).add(pretextoTabla_AST));
				currentAST.root = pretextoTabla_AST;
				currentAST.child = pretextoTabla_AST!=null &&pretextoTabla_AST.getFirstChild()!=null ?
					pretextoTabla_AST.getFirstChild() : pretextoTabla_AST;
				currentAST.advanceChildToEnd();
			}
			pretextoTabla_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = pretextoTabla_AST;
	}
	
	public final void opt() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST opt_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case NUMERO:
			{
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp41_AST);
				match(NUMERO);
				{
				_loop1259:
				do {
					if ((LA(1)==IDENT)) {
						AST tmp42_AST = null;
						tmp42_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp42_AST);
						match(IDENT);
					}
					else {
						break _loop1259;
					}
					
				} while (true);
				}
				break;
			}
			case IDENT:
			{
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp43_AST);
				match(IDENT);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop1264:
			do {
				if ((LA(1)==SEPARADOR)) {
					match(SEPARADOR);
					{
					switch ( LA(1)) {
					case IDENT:
					{
						AST tmp45_AST = null;
						tmp45_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp45_AST);
						match(IDENT);
						break;
					}
					case NUMERO:
					{
						AST tmp46_AST = null;
						tmp46_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp46_AST);
						match(NUMERO);
						{
						_loop1263:
						do {
							if ((LA(1)==IDENT)) {
								AST tmp47_AST = null;
								tmp47_AST = astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp47_AST);
								match(IDENT);
							}
							else {
								break _loop1263;
							}
							
						} while (true);
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					break _loop1264;
				}
				
			} while (true);
			}
			opt_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = opt_AST;
	}
	
	public final void corchetes() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST corchetes_AST = null;
		
		try {      // for error handling
			match(CORCHAB);
			opt();
			astFactory.addASTChild(currentAST, returnAST);
			match(CORCHCERR);
			if ( inputState.guessing==0 ) {
				corchetes_AST = (AST)currentAST.root;
				corchetes_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CORCH,"CORCH")).add(corchetes_AST));
				currentAST.root = corchetes_AST;
				currentAST.child = corchetes_AST!=null &&corchetes_AST.getFirstChild()!=null ?
					corchetes_AST.getFirstChild() : corchetes_AST;
				currentAST.advanceChildToEnd();
			}
			corchetes_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = corchetes_AST;
	}
	
	public final void llaves() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST llaves_AST = null;
		
		try {      // for error handling
			match(LLAVEABR);
			{
			int _cnt1255=0;
			_loop1255:
			do {
				if ((_tokenSet_11.member(LA(1)))) {
					textoToken();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt1255>=1 ) { break _loop1255; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1255++;
			} while (true);
			}
			match(LLAVECERR);
			if ( inputState.guessing==0 ) {
				llaves_AST = (AST)currentAST.root;
				llaves_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LLAV,"LLAV")).add(llaves_AST));
				currentAST.root = llaves_AST;
				currentAST.child = llaves_AST!=null &&llaves_AST.getFirstChild()!=null ?
					llaves_AST.getFirstChild() : llaves_AST;
				currentAST.advanceChildToEnd();
			}
			llaves_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		returnAST = llaves_AST;
	}
	
	public final void pretexto() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pretexto_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LLAVEABR:
			{
				neg();
				astFactory.addASTChild(currentAST, returnAST);
				pretexto_AST = (AST)currentAST.root;
				break;
			}
			case IDENT:
			case LINEA_LATEX:
			case NUMERO:
			case SEPARADOR:
			case BLANCO:
			case NUEVA_LINEA:
			case LETRA:
			case CHARACTER:
			{
				{
				int _cnt1275=0;
				_loop1275:
				do {
					if ((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2)))) {
						textoToken();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt1275>=1 ) { break _loop1275; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt1275++;
				} while (true);
				}
				if ( inputState.guessing==0 ) {
					pretexto_AST = (AST)currentAST.root;
					pretexto_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TXT,"TXT")).add(pretexto_AST));
					currentAST.root = pretexto_AST;
					currentAST.child = pretexto_AST!=null &&pretexto_AST.getFirstChild()!=null ?
						pretexto_AST.getFirstChild() : pretexto_AST;
					currentAST.advanceChildToEnd();
				}
				pretexto_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = pretexto_AST;
	}
	
	public final void textoToken() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST textoToken_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp52_AST = null;
				tmp52_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp52_AST);
				match(IDENT);
				textoToken_AST = (AST)currentAST.root;
				break;
			}
			case LINEA_LATEX:
			{
				AST tmp53_AST = null;
				tmp53_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp53_AST);
				match(LINEA_LATEX);
				textoToken_AST = (AST)currentAST.root;
				break;
			}
			case BLANCO:
			{
				AST tmp54_AST = null;
				tmp54_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp54_AST);
				match(BLANCO);
				textoToken_AST = (AST)currentAST.root;
				break;
			}
			case NUEVA_LINEA:
			{
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp55_AST);
				match(NUEVA_LINEA);
				textoToken_AST = (AST)currentAST.root;
				break;
			}
			case NUMERO:
			case SEPARADOR:
			case LETRA:
			case CHARACTER:
			{
				character();
				astFactory.addASTChild(currentAST, returnAST);
				textoToken_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = textoToken_AST;
	}
	
	public final void contenido() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contenido_AST = null;
		
		try {      // for error handling
			if ((LA(1)==BARRA) && (LA(2)==ITEM)) {
				match(BARRA);
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp57_AST);
				match(ITEM);
				{
				int _cnt1270=0;
				_loop1270:
				do {
					if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
						pretexto();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt1270>=1 ) { break _loop1270; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt1270++;
				} while (true);
				}
				contenido_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_3.member(LA(1)))) {
				pretexto();
				astFactory.addASTChild(currentAST, returnAST);
				contenido_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==BARRA) && (_tokenSet_13.member(LA(2)))) {
				instruccion();
				astFactory.addASTChild(currentAST, returnAST);
				contenido_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = contenido_AST;
	}
	
	public final void neg() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST neg_AST = null;
		
		try {      // for error handling
			match(LLAVEABR);
			{
			int _cnt1279=0;
			_loop1279:
			do {
				if ((LA(1)==BARRA)) {
					match(BARRA);
					{
					switch ( LA(1)) {
					case IDENT:
					{
						AST tmp60_AST = null;
						tmp60_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp60_AST);
						match(IDENT);
						break;
					}
					case BF:
					{
						AST tmp61_AST = null;
						tmp61_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp61_AST);
						match(BF);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else {
					if ( _cnt1279>=1 ) { break _loop1279; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1279++;
			} while (true);
			}
			pretexto();
			astFactory.addASTChild(currentAST, returnAST);
			match(LLAVECERR);
			neg_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = neg_AST;
	}
	
	public final void character() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST character_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SEPARADOR:
			{
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(SEPARADOR);
				break;
			}
			case NUMERO:
			{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(NUMERO);
				break;
			}
			case LETRA:
			{
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(LETRA);
				break;
			}
			case CHARACTER:
			{
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(CHARACTER);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			character_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		returnAST = character_AST;
	}
	
	public final void textoTabla() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST textoTabla_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(IDENT);
				textoTabla_AST = (AST)currentAST.root;
				break;
			}
			case BLANCO:
			{
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(BLANCO);
				textoTabla_AST = (AST)currentAST.root;
				break;
			}
			case NUEVA_LINEA:
			{
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(NUEVA_LINEA);
				textoTabla_AST = (AST)currentAST.root;
				break;
			}
			case NUMERO:
			case SEPARADOR:
			case LETRA:
			case CHARACTER:
			{
				character();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					textoTabla_AST = (AST)currentAST.root;
					textoTabla_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TXT,"TXT")).add(textoTabla_AST));
					currentAST.root = textoTabla_AST;
					currentAST.child = textoTabla_AST!=null &&textoTabla_AST.getFirstChild()!=null ?
						textoTabla_AST.getFirstChild() : textoTabla_AST;
					currentAST.advanceChildToEnd();
				}
				textoTabla_AST = (AST)currentAST.root;
				break;
			}
			case LLAVEABR:
			{
				match(LLAVEABR);
				{
				int _cnt1287=0;
				_loop1287:
				do {
					if ((LA(1)==BARRA)) {
						match(BARRA);
						{
						switch ( LA(1)) {
						case IDENT:
						{
							AST tmp72_AST = null;
							tmp72_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp72_AST);
							match(IDENT);
							break;
						}
						case BF:
						{
							AST tmp73_AST = null;
							tmp73_AST = astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp73_AST);
							match(BF);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else {
						if ( _cnt1287>=1 ) { break _loop1287; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt1287++;
				} while (true);
				}
				pretextoTabla();
				astFactory.addASTChild(currentAST, returnAST);
				match(LLAVECERR);
				textoTabla_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_15);
			} else {
			  throw ex;
			}
		}
		returnAST = textoTabla_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"DOC_LATEX",
		"TXT",
		"CORCH",
		"LLAV",
		"TUPLA",
		"BARRA",
		"BEGIN",
		"LLAVEABR",
		"END",
		"IDENT",
		"DOCUMENT",
		"CENTER",
		"ITEMIZE",
		"ENUMERATE",
		"TABULAR",
		"LLAVECERR",
		"SECTION",
		"SUBSECTION",
		"SUBSUBSECTION",
		"GRAPHICS",
		"AS",
		"LINEA_LATEX",
		"CORCHAB",
		"CORCHCERR",
		"NUMERO",
		"SEPARADOR",
		"ITEM",
		"BF",
		"BLANCO",
		"NUEVA_LINEA",
		"LETRA",
		"CHARACTER"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 65263380994L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 65263380480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 65263380992L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 66352852480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 65229826048L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 65229826560L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 50855936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 134217728L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 2048L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 65263378432L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 65263905282L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 15737856L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 65280682498L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 65280681984L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	
	}
