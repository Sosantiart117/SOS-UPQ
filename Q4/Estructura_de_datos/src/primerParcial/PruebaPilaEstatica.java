package primerParcial;

import javax.swing.JOptionPane;

public class PruebaPilaEstatica {

	public static void main(String[] args){

		PilaEstatica pila = new PilaEstatica();

		// Crear menu
		String menu = "<html>"+
			"<h1>- - - - - - - MENU - - - - - -</h1><hr>"+
			"<ol>"+
			"<li>Agregar dato</li>"+
			"<li>Leer dato</li>"+
			"<li>Extraer dato</li>"+
			"<li>Imprimir Pila</li>"+
			"<li>Limpiar Pila</li>"+
			"<li>Salir</li>"+
			"</ol><hr></html>";
		char op = '\0';
		while(op != '6'){
			op = JOptionPane.showInputDialog(menu).charAt(0);
			switch(op){
				case '1':
					pila.push();
					break;
				case '2':
					pila.peek();
					break;
				case '3':
					pila.pop();
					break;
				case '4':
					pila.print();
					break;
				case '5':
					pila.clear();
					break;
				case '6':
					JOptionPane.showMessageDialog(null, "Cerrando Sistema...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "OpcionIncorrecta, elige una del menu");
					break;
			}
		}
	}

}
