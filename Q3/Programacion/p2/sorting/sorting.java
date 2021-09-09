import java.util.*;

public class sorting {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		// datos
		// 10	20	13	1	12	8	3	11	23	0	0	1	11	13	22	23
		// Ordenados
		// 0	0	1	1	3	8	10	11	11	12	13	13	20	22	23	23	
		int[] data = {-10,20,13,1,12,8,-3,11,23,0,0,1,11,13,22,23,-1};

		// Random datos aleatorios
		int size = 10, range=1000;
		if(args.length != 0 && args[0].equals("rand")){
			data = new int[size];
			for(int i=0; i< size; i++)
				data[i] = (int) ((range * -1) + (Math.random() * (range *2)));
		}

		// Selection algorithm
		String[] sorts = {
			"Bubble",
			"Selection",
			"Insertion",
			"Merge",
			"QuickSort",
			"Counting",
			"Radix",
			"Bucket",
			"Heap",
			"Shell"
		};

		System.out.print("\nSeleccionar algoritmo de ordenamiento:");
		for(int i=0; i < sorts.length; i++)
			System.out.printf("\n%5d) %s", i+1 ,sorts[i]);
		System.out.print("\n>> ");
		int algorithm = scan.nextInt();

		// Mostrar el arreglo des arreglado
		System.out.print("\n\nDatos:\n");
		show(data);

		// Ordenar los datos
		switch(algorithm){
			case 1:
				data=bubble(data);
				break;
			case 2:
				data=selection(data);
				break;
			case 3:
				data=insertion(data);
				break;
			case 4:
				data=merge(data);
				break;
			case 5:
				data=quick(data);
				break;
			case 6:
				data=countingSort(data);
				break;
			case 7:
				data=radix(data);
				break;
			case 8:
				data=bucket(data);
				break;
			case 9:
				data=heap(data);
				break;
			case 10:
				data=shell(data);
				break;
		}
		
		// show after
		System.out.print("Datos ordenados:\n");
		show(data);
	}

// Funciones auxiliares

	static void swap(int[] array, int origen, int destino){
		int num = array[origen];
		array[origen]=array[destino];
		array[destino] = num;
	}

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

	static int getMin(int[] datos){
		int min = datos[0];
		for(int i = 0; i<datos.length; i++)
			if(datos[i] < min) 
				min=datos[i];
		return min;
	}
	
// Algoritmos
// soring(arreglo a ordenar) return arreglo ordenado

	static int[] bubble(int[] datos){
		for(int i=0; i < datos.length-1; i++){
			for(int j=0; j < datos.length-i-1; j++){
				if(datos[j]>datos[j+1])
					swap(datos,j,j+1);
			}
		}
		return datos;
	}

	static int[] selection(int[] datos){
		for(int i=0; i < datos.length-1; i++){
			int min = i;
			for(int j=i+1; j < datos.length; j++){
				if(datos[min] > datos[j]) 
					min = j;
			}
			swap(datos,i,min);
		}
		return datos;
	}

	static int[] insertion(int[] datos){
		for(int i=1; i < datos.length; i++){
			int key = datos[i], j=i;
			while(j > 0 && key < datos[j-1]){
				datos[j]=datos[j-1];
				j--;
			}
			datos[j] = key;
		}
		return datos;
	}

	static int[] merge(int[] datos){
		return datos;
	}

	static int[] quick(int[] datos){
		return datos;
	}

	static int[] countingSort(int[] datos){
		// obten el maximo
		int max = getMax(datos);
		int min = getMin(datos);
		// arreglo para negativos
		if(min < 0) min *= -1;
		else min = 0;
		// Crea arreglo del tamaño max para contar 
		int[] cuenta = new int[min+max+1];
		// Inicializalo en cero
		for(int i=0; i<cuenta.length; i++)
			cuenta[i]=0;
		// Haz la cuenta
		// Cuenta
		for(int i=0; i<datos.length; i++)
			cuenta[datos[i]+min]++;
		// Cuenta acumulada
		for(int i=1; i< cuenta.length; i++)
			cuenta[i] += cuenta[i-1];
		// Ordenalos: Hallar el indice de los datos en la cuenta
		// y despues ordenarlos asi en el arreglo de salida
		// Salida
		int[] salida = new int[datos.length];
		for(int i = datos.length -1; i >= 0; i--){
			salida[cuenta[datos[i]+min] -1] = datos[i];
			cuenta[datos[i]+min]--;
		}
		// Mutar el arreglo de datos para regresarlo
		for(int i =0; i< datos.length; i++)
			datos[i] = salida[i];
		return datos;
	}

	static int[] radix(int[] datos){
		// Implementation of counting inside radix
		// maximo
		int max=getMax(datos);
		// A partir del número maximo 
		// Pasar por cada uno de los digitos (unidades,decenas....)
		int[] cuenta = new int[20];
		int[] salida = new int[datos.length];
		for(int digit=1; max/digit > 0; digit*=10){
			// Inicializalo en cero
			for(int i=0; i<cuenta.length; i++)
				cuenta[i]=0;
			// Cuenta
			for(int i=0; i<datos.length; i++)
				cuenta[((datos[i] / digit) % 10) +10]++;
			// Cuenta acumulada
			for(int i=1; i< cuenta.length; i++)
				cuenta[i] += cuenta[i-1];
			// Salida ----------------------------------------------
			// hacemos la cuenta pero por digitos
			for(int i = datos.length -1; i >= 0; i--){
				int dato = ((datos[i] / digit) % 10) +10;
				salida[cuenta[dato] -1] = datos[i];
				cuenta[dato]--;
			}
			// Mutar el arreglo de datos para regresarlo
			for(int i =0; i< datos.length; i++)
				datos[i] = salida[i];
		}
		return datos;
	}

	static int[] bucket(int[] datos){
		return datos;
	}

	static int[] heap(int[] datos){
		return datos;
	}

	static int[] shell(int[] datos){
		return datos;
	}
}
