package primerParcial;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 17 septiembre 2021
 * @description Arreglo de tipo matriz
 *
 */

public class Matriz {

	private String matriz[][];
	private int count;

	public Matriz(){
		// nombre, edad, comida fav de 5 personas 
		matriz = new String[5][3]; // Matriz[Filas][Columnas]
		count = 0;
	}
	
	public void LlenarValor(){

		String dato = "";

		if(isFull()){
			JOptionPane.showMessageDialog(null, "Matriz llena\nYa no cupo mijo...");
		} else {
			// nombre, edad, comida fav de 5 personas 
			dato = JOptionPane.showInputDialog("Indica tu nombre:");
			matriz[count][0] = dato;

			dato = JOptionPane.showInputDialog("Indica tu edad:");
			matriz[count][1] = dato;

			dato = JOptionPane.showInputDialog("Ingresa tu comida favorita:");
			matriz[count++][2] = dato;

		}
	}

	public void LlenaMatriz(){
		// Metodo wrapper
		for(int i = count; i < matriz.length; i++)
			LlenarValor();
		// Metodo explicito acortado
		// String dato="";
		// String[] tags={"nombre","edad","comida Favorita"};
		// if(isFull()){
		// 	JOptionPane.showMessageDialog(null, "Matriz llena\nYa no cupo mijo...");
		// } else {
		// 	for(int i = cont; i < matriz.length; i++){
		// 		for(int j = 0; j < matriz[i].length; j++){
		//			dato = JOptionPane.showInputDialog("Indica tu "+tags[j]+":");
		// 			matriz[i][j] = dato;
		// 		}
		// 	}
		// }
		// Metodo largo, explicito
		// String dato="";
		// if(isFull()){
		// 	JOptionPane.showMessageDialog(null, "Matriz llena\nYa no cupo mijo...");
		// } else {
		// 	for(int i = cont; i < matriz.length; i++){
		// 		for(int j = 0; j < matriz[i].length; j++){
		// 			switch(j){
		// 				case 0:
		// 					dato = JOptionPane.showInputDialog("Indica tu nombre:");
		// 					break;	
		// 				case 1: 
		// 					dato = JOptionPane.showInputDialog("Indica tu edad:");
		// 					break;
		// 				case 2: 
		// 					dato = JOptionPane.showInputDialog("Ingresa tu comida favorita:");
		// 					break;
		// 			}
		// 			matriz[i][j] = dato;
		// 		}
		// 	}
		// }
	}

	public void ImprimirMatriz(){
		String info = "";

		if(isEmpty()){
			JOptionPane.showMessageDialog(null, "Matriz Vacia\nNo hay que mostrar");
		} else {
			info += "-Nombre-    -Edad-    -Comida fav-\n";
			for(int i = 0; i < count; i++){
				for(int j = 0; j < matriz[i].length; j++){
					info += matriz[i][j] + "    ";
				}
				info += "\n";
			}
			JOptionPane.showMessageDialog(null, info);
		}
	}

	public void Menu(){
		int op = 0;

		do{
			op = Integer.parseInt(
					JOptionPane.showInputDialog("Opciones:"
						+"\n1. Ingresar Valor"
						+"\n2. Llenar el resto de la Matriz"
						+"\n3. Imprimir Matriz"
						+"\n4. Salir"));
			switch(op){
				case 1:
					LlenarValor();
					break;
				case 2: 
					LlenaMatriz();
					break;
				case 3:
					ImprimirMatriz();
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Terminando Programa");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Escoja una opciona valida\n");
			}
		} while ( op != 4 );

	}

	private boolean isEmpty(){
		return count == 0;
	}
	private boolean isFull(){
		return !(count < matriz.length); // Opcion corta
		// opcion larga
		// if(cont == matriz.length)
		// 	return true;
		// else
		// 	return false;
	}

}
