package primerParcial;

import javax.swing.JOptionPane;

/** esta es la descripcion 
 * @author Santiago Orozco (Sosantiart11@github)
 * @company UPQ
 * @date 13 septiembre 2021
 *
 */

public class Arreglo {

	private String[] nickName; // No importa tonde van las []
	// private String nickName [] 
	private int cont;

	public Arreglo(){
 		// El numero entre corchetes es el tamaño 
		// Sabemos que somos 27 alumnos concetados
		nickName = new String[27];
		cont = 0;
	}

	public void LlenarArreglo(){

		String dato = "";

		// usamos un for para repasar el arreglo de manera finita
		for(int i = 0; i < nickName.length; i++){
			// JOptionPane: Parte de Swing muestra popUp
			// showInputDialog: Muestra un dialogo y habilita el dialogo
			dato = JOptionPane.showInputDialog("Ingresa el nickname del usaurio "+(i+1));
			nickName[i] = dato;
		}
	}

	public void ImprimirValores() {
		
		String datos = "";

		for(int i = 0; i < nickName.length; i++){
			datos += (i + 1) + ".-" + nickName[i] + "\n";
		}
		// showMessageDialog: Metodo para enviar un mensaje al usuaio (sin input)
		// Primer argumento es al objeto (elemento) al cual se liga el aviso
		JOptionPane.showMessageDialog(null, datos);
	}

}
