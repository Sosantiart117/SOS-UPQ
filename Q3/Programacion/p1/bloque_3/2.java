import java.util.*;

class b3_2 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){

		// Calificaciones
		float[] parciales = new float[3];
		System.out.println("Ingresa tus calificaciones (Separado por tabs o espacios)");
		System.out.print("Parcial: |1\t|2\t|3\n\t ");
		parciales[0] = scan.nextFloat();
		parciales[1] = scan.nextFloat();
		parciales[2] = scan.nextFloat();
		 
		// Promedio
		float promedio=0;
		for(int i=0; i < 3; i++) promedio+=parciales[i];
		promedio=promedio/3;
		
		// Reglas extras
		// Redondeo
		if(promedio > 9.5) promedio = 10;
		// Beca
		int beca=0;
		if(promedio > 9.1){
			beca = 600;
		} else if(promedio > 8.1){
			beca = 400;
		} else if(promedio > 7){
			beca = 200;
		}

		// Resultado
		for(int i=0; i < 3; i++) System.out.print("Parcial "+i+":\t"+parciales[i] + "\n");
		System.out.print("             -----------\nPromedio Final: "+promedio);
		if(beca != 0) System.out.print("\n Felicidades, tienes una beca de: "+beca+" pesos");
	}
}
