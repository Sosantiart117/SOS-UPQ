package primerParcial;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 27 septiembre 2021
 * @description Estructura fija de la pila
 * stack hecha con arreglos para ejemplificar
 *
 */

public class PilaEstatica {

	private String PILA[];
	private int CONT;

	// Constructor metodo público, no tiene tipo de dato y se llama igual que la
	// clase
	public PilaEstatica(){
		this(10);
	}

	public PilaEstatica(int size){
		PILA = new String[size];
		CONT = 0;
	}

	public void push(){
		if(isFull())
			JOptionPane.showMessageDialog(null, "Pila llena, no s epude almacenar mas datos");
		else{
			String dato="";
			dato = JOptionPane.showInputDialog("Ingresa tu equipo de futbol favorito");
			PILA[CONT++]=dato;
			JOptionPane.showMessageDialog(null, "Dato almacenado con exito");
		}
	}

	public void peek(){
		if(isEmpty())
			JOptionPane.showMessageDialog(null, "Pila vacia, no hay datos para  leer");
		else{
			String dato = "";
			dato = PILA [CONT -1];
			JOptionPane.showMessageDialog(null, "El dato en pila es: "+dato);
		}
	}

	public void pop(){
		if(isEmpty())
			JOptionPane.showMessageDialog(null, "Pila vacia, no hay datos para extraer");
		else {
			String dato = "";
			dato = PILA[--CONT];
			JOptionPane.showMessageDialog(null, "Dato "+dato+" extraido con éxito");
		}
	}

	public void print(){
		if(isEmpty())
			JOptionPane.showMessageDialog(null, "Pila vacia, no hay datos para extraer");
		else{
			String datos = "";
			datos += "Pila: [";
			for(int i= 0;i<CONT;i++)
				datos += ",{"+i+":"+PILA[i]+"}";
			datos += "]";
			JOptionPane.showMessageDialog(null, datos);
		}
	}

	public void clear() {
		CONT = 0;
		JOptionPane.showMessageDialog(null, "La pila se ha vaciado");
	}

	public boolean isEmpty(){
		return CONT == 0;
		// if(cont == 0)
		// 	return true;
		// else
		// 	return false;
	}

	public boolean isFull(){
		return CONT == PILA.length;
		// if(cont == pila.length)
		// 	return true;
		// else
		// 	return false;
	}

}
