package primerParcial;

import java.util.Stack;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 01 Octubre 2021
 * @description Estructura DInamica (usando java)
 *
 */

public class PilaDinamica {

	private Stack<String> pila;

	public PilaDinamica() {

		pila = new Stack<String>();
	}

	public void Menu() {
		char op = '\0';
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
		String dato = "";
		do{
			op = JOptionPane.showInputDialog(menu).charAt(0);
			switch(op){
				case '1': // Agregar dato
					dato = JOptionPane.showInputDialog("Especifica dato a almacenar en pila");
					pila.push(dato);
					break;
				case '2': // Leer la pila
					if(pila.isEmpty()){
						JOptionPane.showMessageDialog(null, "Pila vacia. nada que mostrar");
					} else {
						dato = pila.peek();
						JOptionPane.showMessageDialog(null, "El dato en pila: "+dato);
					}
					break;
				case '3': // extraer de la pila
					if(pila.isEmpty()){
						JOptionPane.showMessageDialog(null, "Pila vacia. nada que hacer");
					} else {
						dato = pila.pop();
						JOptionPane.showMessageDialog(null, "El dato extraido es: "+dato);
					}
					break;
				case '4': // Mostrar la pila
					if(pila.isEmpty()){
						JOptionPane.showMessageDialog(null, "Pila vacia. nada que hacer");
					} else {
						JOptionPane.showMessageDialog(null, "La pila es: "+pila);
					}
					break;
				case '5': // Limpiar la pila
					pila.clear();
					JOptionPane.showMessageDialog(null, "Pila limpiada");
					break;
				case '6': // salir
					JOptionPane.showMessageDialog(null, "Cerrando Sistema...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "OpcionIncorrecta, elige una del menu");
					break;
			}
		}while(op!='6');
		
	}
}
