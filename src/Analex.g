///////////////////////////////
// Analizador léxico base
///////////////////////////////

class Analex extends Lexer;
options{
k=2;
charVocabulary = '\3'..'\377';
importVocab = Anasint;
}

// Palabras reservadas
tokens {
ENUMERATE="enumerate";	
ITEM="item";
ITEMIZE="itemize";
BF="bf";
TABULAR="tabular";
CENTER="center";
BEGIN="begin";
SECTION="section";
SUBSECTION="subsection";
SUBSUBSECTION="subsubsection";
END="end";
DOCUMENT="document"; 
GRAPHICS="includegraphics";
}
 
protected NUEVA_LINEA : "\n" 
{newline();};

BLANCO : ('\t'|' '|NUEVA_LINEA)
{$setType(Token.SKIP);};

LINEA_LATEX: "\\\\"; 

//COMENTARIOS:
COMMENT:    '%' (~('\n'))* 
{$setType(Token.SKIP);};


//Constantes
protected DIGITO : '0'..'9';
NUMERO : (DIGITO)+('.'(DIGITO)+)?;



//IdentificadoresLLAVE
protected LETRA : 'A'..'Z'|'a'..'z'|'_';
IDENT: LETRA(LETRA|DIGITO)*;


// Separadores y agrupadores
AS: '&';
BARRA : '\\'; 
CORCHAB: '[';
CORCHCERR: ']';
LLAVEABR: '{';
LLAVECERR: '}';
EQ:  '=' ;
SEPARADOR : ';'|',' ;

CHARACTER       :       '!' | '"' | '#' | '$'
                |       '*' | '+' |  '-' | '.' | '/'
                |       ':' | '?' | '@' | '^' |  '`' | '~'
                |       '\u0080'..'\u7fff'
               	|       '\'' | '<' | '>' |'('|')'| '|' 
                ;