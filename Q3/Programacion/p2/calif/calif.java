import java.util.*;

class calif {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		
		// declarar arbitrariamente un arreglo
		int calificaciones[] = {10,20,30,21,31,54,90,90,90,1,34,32,12,32,12,65,76,89,65,43,45,98,84,84,84,100,23,54,32,99};
		// arreglo contador 
		int total[] = new int[11];
		// var auxiliar
		int lim = 10;

		// cálculo
		for(int i=0;i<11;i++){
			total[i]=0;
			for(int j=0; j<calificaciones.length; j++)
				if(calificaciones[j] < lim && calificaciones[j] > lim -11) total[i]++; 
			lim += 10;
		}

		// muestra
		lim = 0;
		for(int i=0; i<11;i++){
			System.out.printf(lim==100?"%7d: ":"%2d a %2d: ",lim,lim+9);
			lim+=10;
			for(int j=0; j<total[i];j++) System.out.print("*");
			System.out.println();
		}
	}
}
