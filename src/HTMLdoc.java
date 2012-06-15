import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLdoc {

	private String buffer = "";
	

	public HTMLdoc() {
		buffer += "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
		buffer += "<html>";
		buffer += "<head>";
		buffer += "<title>LaTeX Docuemnt</title>";
		buffer += "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">";
		buffer += "<meta name=\"keywords\" content=\"latex, document\">";
		buffer += "<meta name=\"author\" content=\"Roberto Martín Muñoz\">";
		buffer += "</head>";
		buffer += "<body style='margin: 2em 8em;'>";
	}
	
	public void añadeSaltoLinea(){
		buffer += "</br>";
	}
	
	public void añadeSection(String s){
		
		buffer += "<h1>"+s+"</h1>";
	}
	public void añadeSubSection(String s){
		
		buffer += "<h2>"+s+"</h2>";
	}
	public void añadeSubSubSection(String s){
		
		buffer += "<h3>"+s+"</h3>";
	}
	
	public void center(String s){
		buffer += "<center>"+s+"</center>";
	}
	
	public void image(String source){
		buffer += "<img src="+source+">";
	}
	public void añadeTexto(String texto){
		buffer += "<p>"+texto+"</p>";
	}
	public void añadeBold(String texto){
		buffer += "<strong>"+texto+"</strong>";
	}
	public void itemize(List<String> lis){
		buffer +=  "<ul style='margin-left: 3em;'>";
		 for (String item : lis){
			 buffer +="<li>"+item+"</li>";
		  }  
		buffer +=  "</ul>";
	}
	public void enumerate(List<String> lis){
		buffer +=  "<ol style='margin-left: 3em;'>";
		 for (String item : lis){
			 buffer +="<li>"+item+"</li>";
		  }  
		buffer +=  "</ol>";
	}
	public void tabla(List<List<String>> lislis){
		
		buffer +=  "<center><table border='1'> ";
		 for (List<String> lis : lislis){
			 buffer +="<tr>";
			 for(String s : lis){
				 buffer +="<td>" + s + "</td>";
			 }
			 buffer +="</tr>";
		  }  
		buffer +=  "</table></center>";
	}
	
	
	


	public void creaDocumento() {
		buffer += "</body>";
		buffer += "</html>";
		
		File fichero = new File("./", "fichero.html");
		if(fichero.exists()){
			fichero.delete();
			fichero = new File("./", "fichero.html");
		}
		try {
			// A partir del objeto File creamos el fichero físicamente
			if (fichero.createNewFile())
				System.out.println("El fichero se ha creado correctamente");
			else
				System.out.println("No ha podido ser creado el fichero");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		FileWriter fich = null;
		PrintWriter pw = null;
		try {
			fich = new FileWriter("./fichero.html");
			pw = new PrintWriter(fich);
			
				pw.println(buffer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fich.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


	}

}