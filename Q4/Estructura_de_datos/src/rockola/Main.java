package rockola;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Main{

	public static Rockola rockola;

	public static void main(String[] args) {
		try {
			rockola = new Rockola();
		} catch (FileNotFoundException e) {
			String message = "<html>"+
				"<h1>Error!:</h1><hr>"+
				"<h2>Se necesita un archivo \"musicFile.txt\":</h2>"+
				"<p>Este archivo sirve para configurar la bilbiteca"+
				"con los siguientes parametros</p>"+
				"<ul>"+
				"<li>"+
				"<p>a: Para agregar un artista</p>"+
				"</li>"+
				"<li>"+
				"<p>s: Para agregar una cancion</p>"+
				"</li>"+
				"<li>"+
				"<p>f: Para agregar la referencia al archivo de la cancion</p>"+
				"</li>"+
				"</ul>"+
				"<p>Notas importantes:<br/>"+
				"Se debe dejar un espacio despues del parametro <br>"+
				"Es secuancial (Si se mete un artista, las canciones"+
				"despues de este se le agregan al mismo)<br>"+
				"Se pueden agregar comentarios iniciando con #<br>"+
				"Las lineas en blanco no se interpretan"+
				"</p>"+
				"<h3>ej:</h3>"+
				"<p>...<br>a The Beatles<br>s Hey jude<br>f ...\\ruta\\archivo.mp3<br>"+
				"# una nota<br><br>s Yellow Submarine<br>..."+
				"</p>"+
				"</html>";
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		}
		new MainMenu();;
}

}
