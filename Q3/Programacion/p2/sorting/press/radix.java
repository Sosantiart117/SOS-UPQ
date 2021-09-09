class radixSort {

	public static void main(String[] args){

		// datos		:-10	20	13	1	12	8	-3	11	23	0	0	1	11	13	22	-1
		//Ordenados :-10	-3	-1	0	0	1	1	8	11	11	12	13	13	20	22	23

		int[] data = {-10,20,13,1,12,8,-3,11,23,0,0,1,11,13,22,-1};

		// Random datos aleatorios
		int size = 10, range=1000;
		if(args.length != 0 ? true:false){
			data = new int[size];
			for(int i=0; i< size; i++)
				data[i] = (int) ((range * -1) + (Math.random() * (range *2)));
		}
		// Mostrar el arreglo des arreglado
		System.out.print("              Datos:");
		show(data);

		// Hacer copia de los datos antes de ordenar 
		int[] original = new int[data.length];
		for(int i =0; i< data.length; i++)
			original[i] = data[i];

		// ordena los datos
		data = radix(data);

		// Muestar que cambio
		System.out.print("\n          Datos:");
		show(original);
		System.out.print("Datos ordenados:");
		show(data);
	}

// Funciones auxiliares
	static void show(int[] data){
		for(int i=0; i < data.length;i++ )
			System.out.printf(" %4d"+(i==data.length-1?"":","),data[i]);
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
	// Count para radix
	static int[] countingSort(int[] datos, int max, int min, int digit){
		// Ajuste para numeros negativos
		if(min < 0) min *= -1;
		else min =0;
		// Crea arreglo del tamaño max para contar 
		int[] cuenta = new int[min+max+1];
		// Inicializalo en cero
		for(int i=0; i<cuenta.length; i++)
			cuenta[i]=0;
		// Cuenta
		int dato=0;
		for(int i=0; i<datos.length; i++){
			dato = ((datos[i] / digit) % 10) +min;
			cuenta[dato]++;
		}
		// Cuenta acumulada
		for(int i=1; i< cuenta.length; i++)
			cuenta[i] += cuenta[i-1];
		// Salida ----------------------------------------------
		// hacemos la cuenta pero por digitos
		int[] salida = new int[datos.length];
		for(int i = datos.length -1; i >= 0; i--){
			dato = ((datos[i] / digit) % 10) +min;
			salida[cuenta[dato] -1] = datos[i];
			cuenta[dato]--;
		}
		// Mutar el arreglo de datos para regresarlo
		for(int i =0; i< datos.length; i++)
			datos[i] = salida[i];
		return datos;
	}
	static int[] radix(int[] datos){
		// maximo
		int max=getMax(datos);
		// Minimo
		int min=getMin(datos);
		// A partir del número maximo 
		// Pasar por cada uno de los digitos (unidades,decenas....)
		for(int digito=1; max/digito > 0; digito*=10){
			datos=countingSort(datos,max,min,digito);
			System.out.printf("Ordenado por %4d's:",digito);
			show(datos);
		}
		return datos;
	}
}
