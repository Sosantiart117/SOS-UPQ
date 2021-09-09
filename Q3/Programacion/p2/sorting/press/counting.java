public class counting {

	public static void main(String[] args){

		// datos
		// int[] data = {10,20,13,32,-1,12,43,8,90,3,-11,-23};
		int[] data = {10,20,13,1,12,8,3,11,23,0,0,1,11,13,22,23};
		
		//mostrat antes de todo
		System.out.print("Datos:\n");
		show(data);
		
		// ordenar
		data = countingSort(data);

		// show after
		System.out.print("Datos ordenados:\n");
		show(data);
	}

// Funciones auxiliares

	static void show(int[] data){
		for(int i=0; i < data.length;i++ )
			System.out.print(data[i]+",");
		System.out.println();
	}

	static int getMax(int[] datos){
		int max = datos[0];
		for(int i = 0; i<datos.length; i++)
			if(datos[i] > max) 
				max=datos[i];
		return max;
	}

// Algoritmo

	static int[] countingSort(int[] datos){
		// Salida
		int[] salida = new int[datos.length +1];
		// obten el maximo
		int max = getMax(datos);
		// Haz la cuenta
		// Crea arreglo del tamaño max para contar 
		int[] cuenta = new int[max+1];
		// Inicializalo en cero
		for(int i=0; i<cuenta.length; i++)
			cuenta[i]=0;
		// Cuenta
		for(int i=0; i<datos.length; i++)
			cuenta[datos[i]]++;
		// Cuenta acumulada
		for(int i=1; i< cuenta.length; i++)
			cuenta[i] += cuenta[i-1];
		// Ordenalos: Hallar el indice de los datos en la cuenta
		// y despues ordenarlos asi en el arreglo de salida
		for(int i = datos.length -1; i >= 0; i--){
			salida[cuenta[datos[i]] -1] = datos[i];
			cuenta[datos[i]]--;
		}
		// Mutar el arreglo de datos para regresarlo
		for(int i =0; i< datos.length; i++)
			datos[i] = salida[i];
		return datos;
	}
}
