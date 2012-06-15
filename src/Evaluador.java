// $ANTLR : "Evaluador.g" -> "Evaluador.java"$

	import java.util.*;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class Evaluador extends antlr.TreeParser       implements EvaluadorTokenTypes
 {
HTMLdoc html = new HTMLdoc();public Evaluador() {
	tokenNames = _tokenNames;
}

	public final void documento(AST _t) throws RecognitionException {
		
		AST documento_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST __t112 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,DOC_LATEX);
			_t = _t.getFirstChild();
			{
			_loop114:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==IDENT||_t.getType()==DOCUMENT)) {
					instr(_t);
					_t = _retTree;
				}
				else {
					break _loop114;
				}
				
			} while (true);
			}
			_t = __t112;
			_t = _t.getNextSibling();
			html.creaDocumento();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void instr(AST _t) throws RecognitionException {
		
		AST instr_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case DOCUMENT:
			{
				AST __t116 = _t;
				AST tmp2_AST_in = (AST)_t;
				match(_t,DOCUMENT);
				_t = _t.getFirstChild();
				{
				int _cnt118=0;
				_loop118:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						instrucciones(_t);
						_t = _retTree;
					}
					else {
						if ( _cnt118>=1 ) { break _loop118; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt118++;
				} while (true);
				}
				_t = __t116;
				_t = _t.getNextSibling();
				break;
			}
			case IDENT:
			{
				configuracion(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void instrucciones(AST _t) throws RecognitionException {
		
		AST instrucciones_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String s ="" , aux="", b=""; List<String> lis= new LinkedList<String>();List<List<String>> lislis= new LinkedList<List<String>>();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SECTION:
			{
				AST __t125 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,SECTION);
				_t = _t.getFirstChild();
				{
				int _cnt127=0;
				_loop127:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt127>=1 ) { break _loop127; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt127++;
				} while (true);
				}
				_t = __t125;
				_t = _t.getNextSibling();
				html.añadeSection(s);
				break;
			}
			case SUBSECTION:
			{
				AST __t128 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,SUBSECTION);
				_t = _t.getFirstChild();
				{
				int _cnt130=0;
				_loop130:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt130>=1 ) { break _loop130; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt130++;
				} while (true);
				}
				_t = __t128;
				_t = _t.getNextSibling();
				html.añadeSubSection(s);
				break;
			}
			case SUBSUBSECTION:
			{
				AST __t131 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,SUBSUBSECTION);
				_t = _t.getFirstChild();
				{
				int _cnt133=0;
				_loop133:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt133>=1 ) { break _loop133; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt133++;
				} while (true);
				}
				_t = __t131;
				_t = _t.getNextSibling();
				html.añadeSubSubSection(s);
				break;
			}
			case GRAPHICS:
			{
				AST __t134 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,GRAPHICS);
				_t = _t.getFirstChild();
				AST __t135 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,TXT);
				_t = _t.getFirstChild();
				{
				int _cnt137=0;
				_loop137:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux;
					}
					else {
						if ( _cnt137>=1 ) { break _loop137; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt137++;
				} while (true);
				}
				_t = __t135;
				_t = _t.getNextSibling();
				_t = __t134;
				_t = _t.getNextSibling();
				html.image(s);
				break;
			}
			case CENTER:
			{
				AST __t138 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,CENTER);
				_t = _t.getFirstChild();
				{
				int _cnt140=0;
				_loop140:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt140>=1 ) { break _loop140; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt140++;
				} while (true);
				}
				_t = __t138;
				_t = _t.getNextSibling();
				html.center(s);
				break;
			}
			case ITEMIZE:
			{
				AST __t141 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,ITEMIZE);
				_t = _t.getFirstChild();
				{
				_loop143:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ITEM)) {
						aux=items(_t);
						_t = _retTree;
						lis.add(aux);
					}
					else {
						break _loop143;
					}
					
				} while (true);
				}
				_t = __t141;
				_t = _t.getNextSibling();
				html.itemize(lis);
				break;
			}
			case ENUMERATE:
			{
				AST __t144 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,ENUMERATE);
				_t = _t.getFirstChild();
				{
				_loop146:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ITEM)) {
						aux=items(_t);
						_t = _retTree;
						lis.add(aux);
					}
					else {
						break _loop146;
					}
					
				} while (true);
				}
				_t = __t144;
				_t = _t.getNextSibling();
				html.enumerate(lis);
				break;
			}
			case TABULAR:
			{
				AST __t147 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,TABULAR);
				_t = _t.getFirstChild();
				{
				_loop149:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==TUPLA)) {
						lis=tuplas(_t);
						_t = _retTree;
						lislis.add(lis);
					}
					else {
						break _loop149;
					}
					
				} while (true);
				}
				_t = __t147;
				_t = _t.getNextSibling();
				html.tabla(lislis);
				break;
			}
			case TXT:
			case IDENT:
			case LINEA_LATEX:
			case NUMERO:
			case SEPARADOR:
			case BF:
			case BLANCO:
			case NUEVA_LINEA:
			case LETRA:
			case CHARACTER:
			{
				s=texto(_t);
				_t = _retTree;
				html.añadeTexto(s);
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void configuracion(AST _t) throws RecognitionException {
		
		AST configuracion_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST t = null;
		
		try {      // for error handling
			AST __t120 = _t;
			t = _t==ASTNULL ? null :(AST)_t;
			match(_t,IDENT);
			_t = _t.getFirstChild();
			opciones(_t);
			_t = _retTree;
			_t = __t120;
			_t = _t.getNextSibling();
			System.out.println("CONF: "+t);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void opciones(AST _t) throws RecognitionException {
		
		AST opciones_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String s ="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 3:
			{
				break;
			}
			case TXT:
			case IDENT:
			case LINEA_LATEX:
			case NUMERO:
			case SEPARADOR:
			case BF:
			case BLANCO:
			case NUEVA_LINEA:
			case LETRA:
			case CHARACTER:
			{
				s=texto(_t);
				_t = _retTree;
				break;
			}
			case CORCH:
			{
				AST __t122 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,CORCH);
				_t = _t.getFirstChild();
				opciones(_t);
				_t = _retTree;
				_t = __t122;
				_t = _t.getNextSibling();
				break;
			}
			case LLAV:
			{
				AST __t123 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,LLAV);
				_t = _t.getFirstChild();
				opciones(_t);
				_t = _retTree;
				_t = __t123;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final String  texto(AST _t) throws RecognitionException {
		String res="";
		
		AST texto_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST r = null;
		AST r1 = null;
		AST r2 = null;
		AST r3 = null;
		AST r4 = null;
		AST r6 = null;
		AST r8 = null;
		String s ="" , aux="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case IDENT:
			{
				r = (AST)_t;
				match(_t,IDENT);
				_t = _t.getNextSibling();
				res=r.getText();
				break;
			}
			case BLANCO:
			{
				r1 = (AST)_t;
				match(_t,BLANCO);
				_t = _t.getNextSibling();
				res=r1.getText();
				break;
			}
			case NUEVA_LINEA:
			{
				r2 = (AST)_t;
				match(_t,NUEVA_LINEA);
				_t = _t.getNextSibling();
				res=r2.getText();
				break;
			}
			case CHARACTER:
			{
				r3 = (AST)_t;
				match(_t,CHARACTER);
				_t = _t.getNextSibling();
				res=r3.getText();
				break;
			}
			case SEPARADOR:
			{
				r4 = (AST)_t;
				match(_t,SEPARADOR);
				_t = _t.getNextSibling();
				res=r4.getText();
				break;
			}
			case LINEA_LATEX:
			{
				AST tmp14_AST_in = (AST)_t;
				match(_t,LINEA_LATEX);
				_t = _t.getNextSibling();
				html.añadeSaltoLinea();
				break;
			}
			case NUMERO:
			{
				r6 = (AST)_t;
				match(_t,NUMERO);
				_t = _t.getNextSibling();
				res=r6.getText();
				break;
			}
			case LETRA:
			{
				r8 = (AST)_t;
				match(_t,LETRA);
				_t = _t.getNextSibling();
				res=r6.getText();
				break;
			}
			case BF:
			{
				AST __t159 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,BF);
				_t = _t.getFirstChild();
				{
				int _cnt161=0;
				_loop161:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt161>=1 ) { break _loop161; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt161++;
				} while (true);
				}
				_t = __t159;
				_t = _t.getNextSibling();
				res="<strong>"+s+"</strong>";
				break;
			}
			case TXT:
			{
				AST __t162 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,TXT);
				_t = _t.getFirstChild();
				{
				int _cnt164=0;
				_loop164:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_1.member(_t.getType()))) {
						aux=texto(_t);
						_t = _retTree;
						s+=aux + " ";
					}
					else {
						if ( _cnt164>=1 ) { break _loop164; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt164++;
				} while (true);
				}
				_t = __t162;
				_t = _t.getNextSibling();
				res=s;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return res;
	}
	
	public final String  items(AST _t) throws RecognitionException {
		String res="";
		
		AST items_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String s ="" , aux="";
		
		try {      // for error handling
			AST __t155 = _t;
			AST tmp17_AST_in = (AST)_t;
			match(_t,ITEM);
			_t = _t.getFirstChild();
			{
			int _cnt157=0;
			_loop157:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_1.member(_t.getType()))) {
					aux=texto(_t);
					_t = _retTree;
					s+=aux + " ";
				}
				else {
					if ( _cnt157>=1 ) { break _loop157; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt157++;
			} while (true);
			}
			_t = __t155;
			_t = _t.getNextSibling();
			res=s;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return res;
	}
	
	public final List<String>  tuplas(AST _t) throws RecognitionException {
		List<String> res= new LinkedList<String>();;
		
		AST tuplas_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		List<String> lis= new LinkedList<String>(); String aux ="";
		
		try {      // for error handling
			AST __t151 = _t;
			AST tmp18_AST_in = (AST)_t;
			match(_t,TUPLA);
			_t = _t.getFirstChild();
			{
			_loop153:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_1.member(_t.getType()))) {
					aux=texto(_t);
					_t = _retTree;
					lis.add(aux);
				}
				else {
					break _loop153;
				}
				
			} while (true);
			}
			_t = __t151;
			_t = _t.getNextSibling();
			res=lis;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return res;
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
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 67427082272L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 67410862112L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	}
	
