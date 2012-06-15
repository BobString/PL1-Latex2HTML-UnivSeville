///////////////////////////////
// Analizador sintáctico
///////////////////////////////
class Anasint extends Parser;

options{
	buildAST = true;
	k=2;
}
tokens {
DOC_LATEX;
TXT;
CORCH;
LLAV;
TUPLA;

}
document: instrucciones EOF!
{##=#(#[DOC_LATEX,"DOC_LATEX"],##);} ;

instrucciones: (instruccion)+;

instruccion: BARRA! BEGIN! LLAVEABR! alternativas BARRA! END! LLAVEABR! (IDENT!|DOCUMENT!|CENTER!|ITEMIZE!|ENUMERATE!|TABULAR!) LLAVECERR! 
			|BARRA! SECTION^ config
			|BARRA! SUBSECTION^ config
			|BARRA! SUBSUBSECTION^ config
			|BARRA! GRAPHICS^ config 
			|BARRA! IDENT^ config
			;
			
alternativas: IDENT^  LLAVECERR! contenidos
			|DOCUMENT^  LLAVECERR! contenidos
			|CENTER^  LLAVECERR! contenidos
			|ITEMIZE^  LLAVECERR! contenidos
			|ENUMERATE^ LLAVECERR! contenidos
			|TABULAR^ LLAVECERR! tabla;
			
tabla: (tuplas)+ ;

tuplas: pretextoTabla (AS! pretextoTabla)+ LINEA_LATEX! {##=#(#[TUPLA,"TUPLA"],##);} ;

config : (CORCHAB opt) => corchetes llaves 
	|  (LLAVEABR! pretexto) => LLAVEABR! pretexto LLAVECERR!  
	| pretexto
	;
	
corchetes:  CORCHAB! opt CORCHCERR! {##=#(#[CORCH,"CORCH"],##);};

llaves: LLAVEABR! (textoToken)+ LLAVECERR!  {##=#(#[LLAV,"LLAV"],##);};


opt: (NUMERO (IDENT)*|IDENT) (SEPARADOR! (IDENT|NUMERO (IDENT)*))*	
	;



	
contenidos: (contenido)*;

contenido:  //(BARRA ITEM LLAVEABR) =>BARRA! ITEM^ LLAVEABR! (BARRA! (IDENT^|BF^))+ pretexto LLAVECERR! pretexto
			BARRA! ITEM^ (pretexto)+
			|pretexto	
			|instruccion
				
			;
				
pretexto:  (LLAVEABR BARRA) => neg
			|(textoToken)+ {##=#(#[TXT,"TXT"],##);};

neg: LLAVEABR! (BARRA! (IDENT^|BF^))+ pretexto LLAVECERR!;

textoToken: IDENT | LINEA_LATEX  | BLANCO| NUEVA_LINEA | character;

pretextoTabla: (textoTabla)+ {##=#(#[TXT,"TXT"],##);};		
textoTabla: IDENT |BLANCO | NUEVA_LINEA | character   {##=#(#[TXT,"TXT"],##);}
			|LLAVEABR! (BARRA! (IDENT^|BF^))+ pretextoTabla LLAVECERR!
			;		

character: (SEPARADOR | NUMERO | LETRA | CHARACTER);