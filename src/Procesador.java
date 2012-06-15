/////////////////////////////////////
// Procesador.java (clase principal)
/////////////////////////////////////
import java.io.*;
import antlr.collections.AST;
import antlr.debug.misc.ASTFrame;
import antlr.ANTLRException;

public class Procesador {
	public static void main(String args[]) {
		try {
			FileInputStream fis = new FileInputStream("test.tex");
			
			Analex analex = null;
			Anasint anasint = null;
			Evaluador evaluador = null;
			AST arbol = null;
			
			analex = new Analex(fis);
			anasint = new Anasint(analex);
			anasint.document();
			arbol = anasint.getAST();
			
			ASTFrame frame = new ASTFrame("test.tex",arbol);
			frame.setVisible(true);
			System.out.println(arbol.toStringTree());
			
			evaluador = new Evaluador();
			evaluador.documento(arbol);
		
		} catch (ANTLRException re) {
			System.err.println(re.getMessage());
		} catch (FileNotFoundException fnfe) {
			System.err.println("No se encontró el fichero");
		}
	}
}