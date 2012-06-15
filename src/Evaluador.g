///////////////////////////////
// Evaluador de expresiones
///////////////////////////////

//1) Construir el arbol (y verificarlo con asframe)
//2)Construir el treeparser "mudo" y verificarlo
//3)Incluir la atribucion en el treeparser "mudo"

header{
	import java.util.*;
}


class Evaluador extends TreeParser;

options
{
importVocab = Anasint;
}

{HTMLdoc html = new HTMLdoc();}

documento: #(DOC_LATEX (instr)*)
			{html.creaDocumento();};

instr : #(DOCUMENT (instrucciones)+) 
	|configuracion
	;

configuracion: #(t:IDENT opciones) 	
			{System.out.println("CONF: "+t);};

opciones {String s ="";}: 
		|s=texto
		| #(CORCH opciones)
		| #(LLAV opciones)
		;

instrucciones {String s ="" , aux="", b=""; List<String> lis= new LinkedList<String>();List<List<String>> lislis= new LinkedList<List<String>>();} : 
			 #(SECTION   (aux=texto { s+=aux + " "; })+) {html.añadeSection(s);}
			| #(SUBSECTION  (aux=texto { s+=aux + " "; })+) {html.añadeSubSection(s);}
			| #(SUBSUBSECTION  (aux=texto { s+=aux + " "; })+) {html.añadeSubSubSection(s);}
			| #(GRAPHICS  #(TXT (aux=texto {s+=aux;  })+)){html.image(s);}  
			| #(CENTER  (aux=texto { s+=aux + " "; })+) {html.center(s);}
			| #(ITEMIZE  (aux=items {  lis.add(aux); })*) {html.itemize(lis);}
			| #(ENUMERATE  (aux=items {lis.add(aux); })*) {html.enumerate(lis);}
			| #(TABULAR  (lis=tuplas {lislis.add(lis); })*) {html.tabla(lislis);}
			| s=texto {html.añadeTexto(s);}
			;


tuplas returns [List<String> res= new LinkedList<String>();] {List<String> lis= new LinkedList<String>(); String aux ="";}: 
		#(TUPLA  (aux=texto {lis.add(aux); })*)  {res=lis;}
		;


items returns [String res=""] {String s ="" , aux="";}: 
		#(ITEM  (aux=texto { s+=aux + " "; })+ ) {res=s;}
		;

texto returns [String res=""] {String s ="" , aux="";}:  
							 r:IDENT {res=r.getText();} 
							| r1:BLANCO {res=r1.getText();} 
							| r2:NUEVA_LINEA{res=r2.getText();} 
							| r3:CHARACTER {res=r3.getText();} 
							| r4:SEPARADOR{res=r4.getText();} 
							| LINEA_LATEX {html.añadeSaltoLinea();} 
							| r6:NUMERO {res=r6.getText();}
							| r8:LETRA {res=r6.getText();}
							| #(BF (aux=texto { s+=aux + " "; })+) {res="<strong>"+s+"</strong>";}
							| #(TXT (aux=texto { s+=aux + " "; })+) {res=s;}; 