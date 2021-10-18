package primerParcial;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 18 octubre 2021
 * @description Cola FIFO
 *
 */

public class ColaEstatica {

	private String cola[];
	private int cont;

	// Constructor metodo público, no tiene tipo de dato y se llama igual que la
	// clase
	public ColaEstatica(){
		this(5);
	}

	public ColaEstatica(int size){
		cola = new String[size];
		cont = 0;
	}

	public void add(String dato){
		cola[cont++] = dato;
		JOptionPane.showMessageDialog(null, "Dato agregado!");
	}

	public String  peek(){
		return cola[0];
	}
	public String poll(){
		String dato = cola[0];
		for(int i =0; i < (cont -1); i++)
			cola[i] = cola[i+1];
		cont--;
		return dato;
	}

	public void show(){

	}

}
